package circle;

import graphics.Point;

import java.awt.Graphics;

import algorithms.CircleDrawingAlgorithm;

public class Circle {

	private final int radius;
	private final Point center;

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(int centerX, int centerY, int radius) {
		center = new Point(centerX, centerY);
		this.radius = radius;
	}

	public void drawCircle(CircleDrawingAlgorithm algo, Graphics g,
			Point coordinateCenter) {
		// Shifting the origin to the center of the circle
		Point origin = new Point();
		// Shift the center to standard coordinate system
		origin = this.center.translate(coordinateCenter);
		// circle will be drawn at 0,0 center only
		Circle circle = new Circle(new Point(0, 0), this.radius);
		algo.drawCircle(circle, g, origin);
	}

	public int getRadius() {
		return radius;
	}

	public Point getCenter() {
		return center;
	}
}
