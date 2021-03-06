package algorithms;

import graphics.Point;

import java.awt.Graphics;

import circle.Circle;

public class MidPointAlgorithm extends CircleDrawingAlgorithm {

	@Override
	public void drawCircle(Circle circle, Graphics g, Point coordinateCenter) {
		int radius = circle.getRadius();
		int x = 0, y = radius, p = 1 - radius;
		for (x = 1; x <= radius / 1.414; x++) {
			if (p < 0) {
				p += 2 * x + 1;
			} else {
				y--;
				p += 2 * (x - y) + 1;
			}
			drawSymmetricPoints(x, y, g, coordinateCenter);
		}
	}
}
