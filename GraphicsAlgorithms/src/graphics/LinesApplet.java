package graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

import lines.DashedLine;
import lines.DottedAndDashedLine;
import lines.DottedLine;
import lines.Line;
import algorithms.BresenhemAlgorithm;
import algorithms.LineDrawingAlgorithm;
import capTypes.ButtCapType;
import capTypes.CapType;
import capTypes.NoCapType;
import capTypes.RoundCapType;
import capTypes.SquareCapType;

@SuppressWarnings("serial")
public class LinesApplet extends JApplet {

	@Override
	public void paint(Graphics g) {
		Point center = new Point(400, 400);
		AxesUtility.drawCoordinateSystem(this, g, Color.BLACK, 100, center);
		AxesUtility.drawAxes(this, g, center, Color.BLACK);
		LineDrawingAlgorithm algoBresen = new BresenhemAlgorithm();
		LineDrawingAlgorithm algoDDA = new BresenhemAlgorithm();

		// Solid Line
		Point p = new Point(0, 0);
		Point q = new Point(-200, 200);
		Line solidLine = new Line(p, q, Color.BLUE);
		solidLine.drawLine(center, g, algoBresen);

		// Dashed Line
		Point r = new Point(0, 0);
		Point s = new Point(300, 300);
		Line dashedLine = new DashedLine(r, s, Color.BLACK);
		dashedLine.drawLine(center, g, algoDDA);

		// Dotted Line
		Point t = new Point(0, 0);
		Point u = new Point(-200, -220);
		Line dottedLine = new DottedLine(t, u, Color.BLUE);
		dottedLine.drawLine(center, g, algoBresen);

		// Dashed and Dotted Line
		Point v = new Point(0, 0);
		Point w = new Point(300, -200);
		Line dashedAndDottedLine = new DottedAndDashedLine(v, w, Color.RED);
		dashedAndDottedLine.drawLine(center, g, algoDDA);

		Point x = new Point(200, 200);
		Point y = new Point(300, 100);
		CapType cap = new NoCapType();
		Line line = new Line(x, y, 15, cap, Color.GREEN);
		line.drawLine(center, g, algoDDA);

		// Butt Cap
		Point p1 = new Point(100, 190);
		Point p2 = new Point(0, 100);
		cap = new ButtCapType();
		Line line1 = new Line(p1, p2, 15, cap, Color.CYAN);
		line1.drawLine(center, g, algoBresen);

		// Square Cap
		Point p3 = new Point(200, -90);
		Point p4 = new Point(300, 0);
		cap = new SquareCapType();
		Line line2 = new DashedLine(p3, p4, 15, cap, Color.YELLOW);
		line2.drawLine(center, g, algoBresen);

		// Round Cap
		Point p5 = new Point(0, 0);
		Point p6 = new Point(100, -90);// Not working
		cap = new RoundCapType();
		Line line3 = new DottedAndDashedLine(p5, p6, 15, cap, Color.RED);
		line3.drawLine(center, g, algoBresen);

	}

}