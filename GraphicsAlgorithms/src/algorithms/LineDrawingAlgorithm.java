package algorithms;

import graphics.Point;

import java.awt.Graphics;

import lines.Line;

public interface LineDrawingAlgorithm {
	void drawLine(Line line, Point center, Graphics g);
}
