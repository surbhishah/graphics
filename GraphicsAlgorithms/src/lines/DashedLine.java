package lines;

import graphics.Point;

import java.awt.Color;
import java.awt.Graphics;

import capTypes.CapType;

public class DashedLine extends Line {
	public DashedLine(Point p1, Point p2) {
		super(p1, p2);
	}

	public DashedLine(Point p1, Point p2, Color color) {
		super(p1, p2, color);
	}

	public DashedLine(Point p1, Point p2, int thickness, CapType capType,
			Color color) {
		super(p1, p2, thickness, capType, color);
	}

	@Override
	public void drawPoint(Point point, Graphics g, Point center) {
		if (this.p1.x == this.p2.x) {// Line parallel to y axis slope = infinite
			if (point.y % 30 <= 20) {
				super.drawPoint(point, g, center);
			}
		} else {
			double slope = getSlope();
			if (slope < 1 && slope > -1) {
				if (point.x % 30 <= 20) {
					super.drawPoint(point, g, center);
				}
			} else {
				if (point.y % 30 <= 20) {
					super.drawPoint(point, g, center);
				}

			}
		}
	}
}
