package algorithms;

import graphics.Point;

import java.awt.Color;
import java.awt.Graphics;

import circle.Circle;

public abstract class CircleDrawingAlgorithm {

	public abstract void drawCircle(Circle circle, Graphics g,
			Point coordinateCenter);

	public void drawSymmetricPoints(int x, int y, Graphics g,
			Point coordinateCenter) {
		Point point = new Point();
		// 1st half quadrant
		point.x = x;
		point.y = y;
		point.translateAndDrawPoint(g, coordinateCenter, Color.BLUE);
		// 2nd half quadrant
		point.x = y;
		point.y = x;
		point.translateAndDrawPoint(g, coordinateCenter, Color.BLUE);
		// 3rd half quadrant
		point.x = y;
		point.y = -x;
		point.translateAndDrawPoint(g, coordinateCenter, Color.BLUE);
		// 4th half quadrant
		point.x = x;
		point.y = -y;
		point.translateAndDrawPoint(g, coordinateCenter, Color.BLUE);
		// 5th half quadrant
		point.x = -x;
		point.y = -y;
		point.translateAndDrawPoint(g, coordinateCenter, Color.BLUE);
		// 6th half quadrant
		point.x = -y;
		point.y = -x;
		point.translateAndDrawPoint(g, coordinateCenter, Color.BLUE);
		// 7th half quadrant
		point.x = -y;
		point.y = x;
		point.translateAndDrawPoint(g, coordinateCenter, Color.BLUE);
		// 8th half quadrant
		point.x = -x;
		point.y = y;
		point.translateAndDrawPoint(g, coordinateCenter, Color.BLUE);

	}

}
