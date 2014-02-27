package shapes;

import graphics.Point;

import java.awt.Color;
import java.awt.Graphics;

import lines.BresenhemAlgorithm;
import lines.Line;
import lines.LineDrawingAlgorithm;
import matrices.Matrix;

public class Polygon implements Shape {
	Point vertices[];// vertices should be ordered..end points of a line must be
						// in order
	Color color;
	int n ;// n = no of sides 
	public Polygon(Point vertices[]) {
		this.vertices = vertices;
		this.color = Color.blue;
		this.n = vertices.length;
	}

	public Polygon(Point vertices[], Color color) {
		this(vertices);
		this.color = color;
	}

	public void draw(Graphics g, Point coordinateCenter) {
		Line line;
		LineDrawingAlgorithm algo = new BresenhemAlgorithm();
		for (int i = 0; i < n - 1; i++) {
			line = new Line(vertices[i], vertices[i + 1]);
			line.drawLine(coordinateCenter, g, algo);
		}
		line = new Line(vertices[0], vertices[n - 1]);
		line.drawLine(coordinateCenter, g, algo);

	}

	@Override
	public Matrix mapToMatrix() {
		int matrix[][] = new int[n][3];
		int i=0;
		for(Point vertex: vertices){
			matrix[i][0] = vertex.x;
			matrix[i][1] = vertex.y;
			matrix[i][2] = 1;
			i++;
		}
		Matrix polygonMatrix = new Matrix(matrix);
		return polygonMatrix;
	}

}
