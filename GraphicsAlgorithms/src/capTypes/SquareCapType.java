package capTypes;

import graphics.Point;

import java.awt.Graphics;

import lines.Line;

public class SquareCapType implements CapType {

	@Override
	public void drawCap(Line line, Point center, Graphics g) {
		Point p1 = line.getP1();
		Point p2 = line.getP2();
		int thickness = line.getThickness();
		if (p1.x == p2.x) {// Infinite slope
			return;// No need of butt..already there
		} else {
			double slope = line.getSlope();
			double cos = Math.sqrt(1 / (1 + slope * slope));// (secx)^2 = 1 +
															// (tanx)^2
			double sin = slope * cos;// tan = sin/cos
			if (slope <= 1 && slope >= -1) {
				Point t3 = new Point();
				t3.x = p1.x - (int) Math.round(thickness * sin * cos / 2);
				t3.y = p1.y + (int) Math.round(thickness * cos * cos / 2);

				Point t1 = new Point(p1.x, p1.y + thickness / 2);
				Point t2 = new Point(p1.x, p1.y - (thickness - 1) / 2);

				t1 = t1.translate(center);
				t2 = t2.translate(center);
				t3 = t3.translate(center);

				int xPoints[] = { t1.x, t2.x, t3.x };
				int yPoints[] = { t1.y, t2.y, t3.y };
				g.setColor(line.getColor());
				g.fillPolygon(xPoints, yPoints, 3);

				Point t4 = new Point();
				t4.x = p2.x + (int) Math.round(thickness * sin * cos / 2);
				t4.y = p2.y - (int) Math.round(thickness * cos * cos / 2);

				Point t5 = new Point(p2.x, p2.y + thickness / 2);
				Point t6 = new Point(p2.x, p2.y - (thickness - 1) / 2);
				t4 = t4.translate(center);
				t5 = t5.translate(center);
				t6 = t6.translate(center);
				int xPoints1[] = { t4.x, t5.x, t6.x };
				int yPoints1[] = { t4.y, t5.y, t6.y };
				g.fillPolygon(xPoints1, yPoints1, 3);
			} else {

				Point t3 = new Point();
				t3.x = p1.x + thickness / 2
						- (int) Math.round(thickness * cos * cos);
				t3.y = p1.y - (int) Math.round(thickness * sin * cos);

				Point t1 = new Point(p1.x + thickness / 2, p1.y);
				Point t2 = new Point(p1.x - (thickness - 1) / 2, p1.y);

				t1 = t1.translate(center);
				t2 = t2.translate(center);
				t3 = t3.translate(center);

				int xPoints[] = { t1.x, t2.x, t3.x };
				int yPoints[] = { t1.y, t2.y, t3.y };
				g.setColor(line.getColor());
				g.fillPolygon(xPoints, yPoints, 3);

				Point t4 = new Point();
				t4.x = p2.x - thickness / 2
						+ (int) Math.round(thickness * cos * cos);
				t4.y = p2.y + (int) Math.round(thickness * sin * cos);

				Point t5 = new Point(p2.x + thickness / 2, p2.y);
				Point t6 = new Point(p2.x - (thickness - 1) / 2, p2.y);
				t4 = t4.translate(center);
				t5 = t5.translate(center);
				t6 = t6.translate(center);
				int xPoints1[] = { t4.x, t5.x, t6.x };
				int yPoints1[] = { t4.y, t5.y, t6.y };
				g.fillPolygon(xPoints1, yPoints1, 3);

			}
		}

	}

}
