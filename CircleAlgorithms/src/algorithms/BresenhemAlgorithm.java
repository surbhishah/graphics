package algorithms;

import graphics.Point;

import java.awt.Graphics;

import circle.Circle;

public class BresenhemAlgorithm extends CircleDrawingAlgorithm {

	@Override
	public void drawCircle(Circle circle, Graphics g, Point coordinateCenter) {
		int radius = circle.getRadius();
		int x = 0, y = radius, d = 3 - 2 * radius;
		for (x = 1; x <= radius / 1.414; x++) {
			if (d < 0) {
				d += 6 + 4 * x;
			} else {
				d += 4 * (x - y) + 10;
				y--;
			}
			drawSymmetricPoints(x, y, g, coordinateCenter);
		}
	}

}
