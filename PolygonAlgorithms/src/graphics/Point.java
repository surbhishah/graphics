package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class Point {
	public int x;
	public int y;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void drawPoint(Graphics g, Color color) {
		g.setColor(color);
		g.drawLine(x, y, x, y);
	}

	// translate the point to the axes of the system from axes of center
	public Point translate(Point center) {
		return new Point(center.x + this.x, center.y - this.y);
	}

	// translate the point from axes of system to axes of center
	public Point translateAxesFromStandard(Point center) {
		return new Point(this.x - center.x, center.y - this.y);
	}

	public void translateAndDrawPoint(Graphics g, Point center, Color color) {
		Point translatedPoint = this.translate(center);
		translatedPoint.drawPoint(g, color);
	}

}
