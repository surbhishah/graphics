package algorithms;

import graphics.Point;

import java.awt.Color;
import java.awt.Graphics;

import circle.Circle;

public class DirectEquationUse extends CircleDrawingAlgorithm {

	@Override
	public void drawCircle(Circle circle, Graphics g, Point coordinateCenter) {
		int radius = circle.getRadius();
		int x, y;
		Point point = new Point();
		for (x = -radius; x <= radius ; x++) {
			y = getY(circle, x);
			point.x = x;
			point.y = y;
			point.translateAndDrawPoint(g, coordinateCenter, Color.BLUE);
			point.y = -y;
			point.translateAndDrawPoint(g, coordinateCenter, Color.BLUE);
		}
	}

	private int getY(Circle circle, int x) {
		int radius_square = (int) Math.pow(circle.getRadius(), 2);
		return (int) (circle.getCenter().y + Math.round(Math.sqrt(radius_square
				- Math.round(Math.pow(circle.getCenter().x - x, 2)))));
	}

}
