package fillAlgorithms;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class FloodFillAlgorithm implements FillAlgorithm {
	public BufferedImage fill(BufferedImage img, int x, int y, Color fillColor,
			Color oldColor) {
		__fill(img, x, y, fillColor.getRGB(), oldColor.getRGB());
		return img;

	}

	private void __fill(BufferedImage img, int x, int y, int fillColorRGB,
			int oldColorRGB) {
		// reads the pixel value of pixel at x,y
		int currentRGB = img.getRGB(x, y);
		// if pixel is neither boundary color nor fill color
		// then fills the color
		if (currentRGB == oldColorRGB) {
			img.setRGB(x, y, fillColorRGB);
			// recursive call
			__fill(img, x + 1, y, fillColorRGB, oldColorRGB);
			__fill(img, x - 1, y, fillColorRGB, oldColorRGB);
			__fill(img, x, y + 1, fillColorRGB, oldColorRGB);
			__fill(img, x, y - 1, fillColorRGB, oldColorRGB);

		}

	}
}
