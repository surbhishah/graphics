package fillAlgorithms;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class BoundaryFillAlgorithm implements FillAlgorithm {
	public BufferedImage fill(BufferedImage img, int x, int y, Color fillColor,
			Color boundaryColor) {
		__fill(img, x, y, fillColor.getRGB(), boundaryColor.getRGB());
		return img;

	}

	private void __fill(BufferedImage img, int x, int y, int fillColorRGB,
			int boundaryColorRGB) {
		// reads the pixel value of pixel at x,y
		int currentRGB = img.getRGB(x, y);
		// if pixel is neither boundary color nor fill color
		// then fills the color
		if (currentRGB != fillColorRGB && currentRGB != boundaryColorRGB) {
			img.setRGB(x, y, fillColorRGB);
			// recursive call
			__fill(img, x + 1, y, fillColorRGB, boundaryColorRGB);
			__fill(img, x - 1, y, fillColorRGB, boundaryColorRGB);
			__fill(img, x, y + 1, fillColorRGB, boundaryColorRGB);
			__fill(img, x, y - 1, fillColorRGB, boundaryColorRGB);

		}

	}
}
