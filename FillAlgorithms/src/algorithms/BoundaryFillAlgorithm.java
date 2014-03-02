package algorithms;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Robot;

public class BoundaryFillAlgorithm implements FillAlgorithm {
	public void fill(int x, int y, Graphics g, Color fillColor,
			Color boundaryColor) throws AWTException{
		Robot robot = new Robot();
		Color currentPixelColor = robot.getPixelColor(x, y);
		if (!currentPixelColor.equals(boundaryColor)
				&& !currentPixelColor.equals(fillColor)) {
			g.setColor(fillColor);
			g.drawLine(x, y, x, y);
			//fill(x+1, y, g, fillColor, boundaryColor);
			//fill(x-1, y, g, fillColor, boundaryColor);
			//fill(x, y+1, g, fillColor, boundaryColor);
			//fill(x, y-1, g, fillColor, boundaryColor);
			
		}

	}
}
