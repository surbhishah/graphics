package lines;

import graphics.Point;

import java.awt.Color;
import java.awt.Graphics;

import capTypes.CapType;

public class DottedLine extends Line {

	public DottedLine(Point p1, Point p2) {
		super(p1, p2);
	}

	public DottedLine(Point p1, Point p2, Color color) {
		super(p1, p2, color);
	}

	public DottedLine(Point p1, Point p2, int thickness, CapType capType,
			Color color) {
		super(p1, p2, thickness, capType, color);
	}

	@Override
	public void drawPoint(Point point, Graphics g, Point center) {
		if (this.p1.x == this.p2.x) {// Line parallel to y axis slope = infinite
			if (point.y % 5 <= 2) {
				super.drawPoint(point, g, center);
			}
		}
		else{
			double slope = getSlope();
			if (slope < 1 && slope > -1) {
				if (point.x % 5 <= 2) {
					super.drawPoint(point, g, center);
				}
			} else {
				if (point.y % 5 <= 2) {
					super.drawPoint(point, g, center);
				}
	
			}
		}

	}

}
