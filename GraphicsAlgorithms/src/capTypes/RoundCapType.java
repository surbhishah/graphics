package capTypes;

import graphics.Point;

import java.awt.Graphics;

import lines.Line;

public class RoundCapType implements CapType {

	@Override
	public void drawCap(Line line, Point center, Graphics g) {
		Point p1 = line.getP1();
		Point p2 = line.getP2();
		int thickness = line.getThickness();
		Point p3 = new Point(p1.x - (thickness - 2) / 2, p1.y + thickness / 2);
		Point p4 = new Point(p2.x - (thickness - 2) / 2, p2.y + thickness / 2);
		p3 = p3.translate(center);
		p4 = p4.translate(center);
		g.setColor(line.getColor());
		g.fillOval(p3.x, p3.y, thickness, thickness);
		g.fillOval(p4.x, p4.y, thickness, thickness);
	}
}
