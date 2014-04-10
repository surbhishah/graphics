package fillAlgorithms;

import graphics.Point;

public class Edge {
	public Point p1;
	public Point p2;

	public Edge(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Edge(int x1, int y1, int x2, int y2) {
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
	}

	public double getSlope() {
		if (p1.x == p2.x)
			return Double.POSITIVE_INFINITY;
		else
			return ((double) p1.y - p2.y) / (p1.x - p2.x);
	}
}
