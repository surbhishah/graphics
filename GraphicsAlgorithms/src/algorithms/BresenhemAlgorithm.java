package algorithms;

import graphics.Point;

import java.awt.Graphics;

import lines.Line;

public class BresenhemAlgorithm implements LineDrawingAlgorithm {

	@Override
	public void drawLine(Line line, Point center, Graphics g) {
		Point p1 = line.getP1();
		Point p2 = line.getP2();
		if (p1.x == p2.x) { // Line parallel to y axis, slope= infinite
			int start, end;
			if (p1.y < p2.y) {
				start = p1.y;
				end = p2.y;
			} else {
				start = p2.y;
				end = p1.y;
			}
			Point point = new Point();
			for (int i = start; i < end; i++) {
				point.x = p1.x;
				point.y = i;
				line.drawPoint(point, g, center);
			}
		} else if (p1.y == p2.y) { // Line parallel to x axis, slope = zero

			int start, end;
			if (p1.x < p2.x) {
				start = p1.x;
				end = p2.x;
			} else {
				start = p2.x;
				end = p1.x;
			}
			Point point = new Point();
			for (int i = start; i < end; i++) {
				point.x = i;
				point.y = p1.y;
				line.drawPoint(point, g, center);
			}
		} else { // General Line with slope not zero or infinite
			double slope = ((double) p1.y - (double) p2.y)
					/ ((double) p1.x - (double) p2.x);
			if (slope > -1 && slope < 1) { // |m| < 1
				int dy = Math.abs(p1.y - p2.y);
				int dx = Math.abs(p1.x - p2.x);
				int decision_var = 2 * dy - dx;
				int xini, yini, xend, x, y;
				if (p1.x < p2.x) {
					xini = p1.x;
					yini = p1.y;
					xend = p2.x;
				} else {
					xini = p2.x;
					yini = p2.y;
					xend = p1.x;
				}
				x = xini;
				y = yini;
				Point point = new Point();
				point.x = xini;
				point.y = yini;
				line.drawPoint(point, g, center);
				while (x < xend) {
					if (decision_var > 0) {
						decision_var += 2 * dy - 2 * dx;
						if (slope < 0) // If slope is negative, decrement y
							y--;
						else
							// If slope is positive, increment y
							y++;

					} else {
						decision_var += 2 * dy;
					}
					x++;
					point.x = x;
					point.y = y;
					line.drawPoint(point, g, center);
				}

			} else { // |m| >=1
				int dy = Math.abs(p1.y - p2.y);
				int dx = Math.abs(p1.x - p2.x);
				int decision_var = dy - 2 * dx;
				int xini, yini, yend, x, y;
				if (p1.y < p2.y) {
					yini = p1.y;
					xini = p1.x;
					yend = p2.y;
				} else {
					yini = p2.y;
					xini = p2.x;
					yend = p1.y;
				}
				x = xini;
				y = yini;
				Point point = new Point();
				point.x = xini;
				point.y = yini;
				line.drawPoint(point, g, center);
				while (y < yend) {
					if (decision_var < 0) {
						decision_var += 2 * dy - 2 * dx;
						if (slope < 0) // If slope is negative, decrement x
							x--;
						else
							// If slope is positive, increment x
							x++;

					} else {
						decision_var -= 2 * dx;

					}
					y++;
					point.x = x;
					point.y = y;
					line.drawPoint(point, g, center);
				}

			}

		}

	}

}
