package lines;

import graphics.Point;

import java.awt.Graphics;

public interface LineDrawingAlgorithm {
	void drawLine(Line line, Point center, Graphics g);
}
