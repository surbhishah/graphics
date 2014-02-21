package capTypes;

import graphics.Point;

import java.awt.Graphics;

import lines.Line;

public interface CapType {
	public void drawCap(Line line, Point center, Graphics g);

}
