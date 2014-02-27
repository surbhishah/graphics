package geometricTransformations;

import lines.Line;
import matrices.Matrix;
import exceptions.InvalidMatrixOperationException;
import graphics.Point;

public class Reflection implements GeometricTransformation {
	Line line;

	public Reflection(Line line) {
		this.line = line;
	}

	@Override
	public Matrix transform(Matrix points)
			throws InvalidMatrixOperationException {
		Point p1 = line.getP1();
		Point p2 = line.getP2();
		if (p1.x == p2.x) {
			// Line parallel to y axis
			double matrix[][] = { { -1, 0, 0 }, { 0, 1, 0 }, { 2 * p1.x, 0, 1 } };
			Matrix reflectionMatrix = new Matrix(matrix);
			Matrix resultMatrix = points.multiply(reflectionMatrix);
			return resultMatrix;
		} else {
			// Arbitrary line
			double tanx = line.getSlope();
			double c = (int) Math.round((p1.y - tanx * p1.x));
			double cosx = Math.sqrt(1 / (1 + tanx * tanx));// (secx)^2 = 1 +
			// (tanx)^2
			double sinx = tanx * cosx;// tan = sin/cos
			double cos2x = cosx * cosx - sinx * sinx;
			double sin2x = 2 * sinx * cosx;
			double matrix[][] = {
					{ cos2x, sin2x, 0 },
					{ sin2x, -cos2x, 0 },
					{ (int) Math.round(-c * sin2x),
							(int) Math.round(c * cos2x + c), 1 } };
			Matrix reflectionMatrix = new Matrix(matrix);
			Matrix resultMatrix = points.multiply(reflectionMatrix);
			return resultMatrix;
		}
	}

}
