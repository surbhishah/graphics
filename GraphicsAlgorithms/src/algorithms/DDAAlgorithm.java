package algorithms;

import graphics.Point;

import java.awt.Graphics;

import lines.Line;

public class DDAAlgorithm implements LineDrawingAlgorithm {

	@Override
	public void drawLine(Line line, Point center, Graphics g) {
		Point p1 = line.getP1();
		Point p2 = line.getP2();
		int x1 = p1.x;
		int y1 = p1.y;
		int x2 = p2.x;
		int y2 = p2.y;
		int dx = x2 - x1;
		int dy = y2 - y1;
		int steps;
		if (Math.abs(dx) > Math.abs(dy)) {
			steps = Math.abs(dx);
		} else {
			steps = Math.abs(dy);
		}
		double xinc = dx / (float) steps;
		double yinc = dy / (float) steps;
		double x = x1, y = y1;
		Point point = new Point();
		point.x = (int) Math.round(x);
		point.y = (int) Math.round(y);
		line.drawPoint(point, g, center);
		for (int i = 0; i < steps; i++) {
			x += xinc;
			y += yinc;
			point.x = (int) Math.round(x);
			point.y = (int) Math.round(y);
			line.drawPoint(point, g, center);
		}

	}

}
