package lines;

import graphics.Point;

import java.awt.Color;
import java.awt.Graphics;

import algorithms.LineDrawingAlgorithm;
import capTypes.CapType;
import capTypes.NoCapType;

public class Line {

	protected Point p1;
	protected Point p2;
	protected int thickness;
	protected CapType cap;
	protected Color color;

	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.thickness = 1;// Default thickness
		this.cap = new NoCapType();// Default cap type
		this.color = Color.BLUE;// Default color
	}

	public Line(Point p1, Point p2, Color color) {
		this.p1 = p1;
		this.p2 = p2;
		this.thickness = 1;// Default thickness
		this.cap = new NoCapType();// Default cap type
		this.color = color;// Default color
	}

	public Line(int x1, int y1, int x2, int y2) {
		p1 = new Point(x1, y1);
		p2 = new Point(x2, y2);
		this.thickness = 1;// Default thickness
		this.cap = new NoCapType();// Default cap type
		this.color = Color.BLUE;// Default color
	}

	public Line(Point p1, Point p2, int thickness, CapType cap, Color color) {
		this(p1, p2);
		this.thickness = thickness;
		this.cap = cap;
		this.color = color;
	}

	public Line(int x1, int y1, int x2, int y2, int thickness, CapType cap,
			Color color) {
		this(x1, y1, x2, y2);
		this.thickness = thickness;
		this.cap = cap;
		this.color = color;
	}

	public Point getP1() {
		return this.p1;
	}

	public Point getP2() {
		return this.p2;
	}

	public double getSlope() throws ArithmeticException {
		return ((double) p1.y - p2.y) / ((double) p1.x - p2.x);
	}

	public Color getColor() {
		return this.color;
	}

	public int getThickness() {
		return this.thickness;
	}

	public void drawLine(Point center, Graphics g, LineDrawingAlgorithm algo) {
		Point virtualCenter;
		// I am shifting the center to one of the end points of the line
		// so that one point will be (0,0)
		p1 = p1.translate(center);
		p2 = p2.translate(center);
		if (p1.x < p2.x) {
			virtualCenter = p1;
		} else {
			virtualCenter = p2;
		}
		p1 = p1.translateAxesFromStandard(virtualCenter);
		p2 = p2.translateAxesFromStandard(virtualCenter);
		algo.drawLine(this, virtualCenter, g);
		if (thickness != 1)
			cap.drawCap(this, virtualCenter, g);
	}

	public void drawPoint(Point point, Graphics g, Point center) {
		Point thickingPoint = new Point();
		// Draw the actual point
		point.translateAndDrawPoint(g, center, color);
		if (p1.x == p2.x) { // Line parallel to y axis
			for (int i = 1; i <= thickness / 2; i++) {
				thickingPoint.x = point.x + i;
				thickingPoint.y = point.y;
				thickingPoint.translateAndDrawPoint(g, center, color);
			}
			for (int i = 1; i <= (thickness - 1) / 2; i++) {
				thickingPoint.x = point.x - i;
				thickingPoint.y = point.y;
				thickingPoint.translateAndDrawPoint(g, center, color);
			}

		} else {
			double slope = getSlope();
			if (slope > -1 && slope < 1) {
				for (int i = 1; i <= thickness / 2; i++) {
					thickingPoint.x = point.x;
					thickingPoint.y = point.y + i;
					thickingPoint.translateAndDrawPoint(g, center, color);
				}
				for (int i = 1; i <= (thickness - 1) / 2; i++) {
					thickingPoint.x = point.x;
					thickingPoint.y = point.y - i;
					thickingPoint.translateAndDrawPoint(g, center, color);

				}
			} else {
				for (int i = 1; i <= thickness / 2; i++) {
					thickingPoint.x = point.x + i;
					thickingPoint.y = point.y;
					thickingPoint.translateAndDrawPoint(g, center, color);
				}
				for (int i = 1; i <= (thickness - 1) / 2; i++) {
					thickingPoint.x = point.x - i;
					thickingPoint.y = point.y;
					thickingPoint.translateAndDrawPoint(g, center, color);
				}

			}
		}
	}
}
