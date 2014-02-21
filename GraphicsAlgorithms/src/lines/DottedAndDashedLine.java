package lines;

import graphics.Point;

import java.awt.Color;
import java.awt.Graphics;

import capTypes.CapType;

public class DottedAndDashedLine extends Line {
	public DottedAndDashedLine(Point p1, Point p2) {
		super(p1, p2);
	}

	public DottedAndDashedLine(Point p1, Point p2, Color color) {
		super(p1, p2, color);
	}

	public DottedAndDashedLine(Point p1, Point p2, int thickness,
			CapType capType, Color color) {
		super(p1, p2, thickness, capType, color);
	}

	@Override
	public void drawPoint(Point point, Graphics g, Point center) {
		int mod;
		if (this.p1.x == this.p2.x) {// Line parallel to y axis slope = infinite
			mod = point.y % 30;
			if (mod <= 11 || mod >= 18 || mod == 14) {
				super.drawPoint(point, g, center);
			}
		}
		else{
			double slope = getSlope();
			if (slope < 1 && slope > -1) {
				mod = point.x % 30;
				if (mod <= 11 || mod >= 18 || mod == 14) {
					super.drawPoint(point, g, center);
				}
			} else {
				mod = point.y % 30;
				if (mod <= 11 || mod >= 18 || mod == 14) {
					super.drawPoint(point, g, center);
				}
	
			}
		}

	}
}
