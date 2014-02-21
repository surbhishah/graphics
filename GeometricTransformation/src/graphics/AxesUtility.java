package graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class AxesUtility {

	public static void drawAxes(JApplet applet, Graphics g, Point center,
			Color color) {
		g.setColor(color);
		g.drawLine(0, center.y, applet.getWidth(), center.y);
		g.drawLine(center.x, 0, center.x, applet.getHeight());
	}

	public static void drawCoordinateSystem(JApplet applet, Graphics g,
			Color color, int scale, Point center) {
		int width = applet.getWidth();
		int height = applet.getHeight();
		int scaleX = scale;
		int scaleY = scale;
		g.setColor(color);
		for (int i = 0; i < width; i += scaleY) {
			g.drawLine(0, i, width, i);// Draw lines parallel to y axis

		}
		for (int i = 0; i < height; i += scaleX) {
			g.drawLine(i, 0, i, height);// Draw lines parallel to x axis
		}
		Point point;
		for (int i = 0; i < width; i += scaleY) {
			for (int j = 0; j < height; j += scaleX) {
				point = new Point(i, j);
				// converts the new axes system to that of the computer system
				point = point.translateAxesFromStandard(center);
				// writes point location
				String pointLocation = "(" + point.x + "," + point.y + ")";
				g.drawString(pointLocation, i, j);
			}
		}

	}

}
