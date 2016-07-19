package comp102x.project.task;

import comp102x.ColorImage;

public class ScreenTransition {
    
    public void changeScreen(ColorImage image, int x, int y, int width, int height,
			int stripeSize) {
	
    	if (height <= stripeSize * 2 || width <= stripeSize * 2) {
            animateStripe(image, x, y, width, height, "toRight");
        } else {
            animateStripe(image, x, y, width, stripeSize, "toRight");
            animateStripe(image, x + width - stripeSize, y + stripeSize, height, stripeSize, "toBottom");
            animateStripe(image, x, y + height - stripeSize, width - stripeSize, stripeSize, "toLeft");
            animateStripe(image, x, y + stripeSize, height - stripeSize * 2, stripeSize, "toTop");
            changeScreen(image, x + stripeSize, y + stripeSize, width - stripeSize * 2, height - stripeSize * 2, stripeSize);
        }
    }
    
    private void animateStripe(ColorImage image, int left, int top,
			int length, int stripeSize, String direction) {

		long delay = (long) Math.pow(10, 5);
		
		switch (direction) {

		case "toRight":
			for (int i = 0; i < length; i++) {
				image.drawRectangle(left + i, top, 1, stripeSize);
				pauseByTicks(delay);
			}
			break;

		case "toBottom":
			for (int i = 0; i < length; i++) {
				image.drawRectangle(left, top + i, stripeSize, 1);
				pauseByTicks(delay);
			}
			break;

		case "toLeft":
			for (int i = length - 1; i >= 0; i--) {
				image.drawRectangle(left + i, top, 1, stripeSize);
				pauseByTicks(delay);
			}
			break;

		case "toTop":
			for (int i = length - 1; i >= 0; i--) {
				image.drawRectangle(left, top + i, stripeSize, 1);
				pauseByTicks(delay);
			}
			break;

		default:
			System.err.println("Invalid direction: " + direction);
			System.err.println("Only \"toRight\", \"toBottom\", \"toLeft\", \"toTop\" are allowed!");
		}
	}

	private void pauseByTicks(long ticks) {
		while (ticks != 0) {
			ticks--;
		}
	}

}
