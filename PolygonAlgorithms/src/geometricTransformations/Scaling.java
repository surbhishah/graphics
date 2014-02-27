package geometricTransformations;

import matrices.Matrix;
import exceptions.InvalidMatrixOperationException;

public class Scaling implements GeometricTransformation {
	private final int sx;
	private final int sy;

	public Scaling(int sx, int sy) {
		this.sx = sx;
		this.sy = sy;
	}

	@Override
	public Matrix transform(Matrix points)
			throws InvalidMatrixOperationException {
		double matrix[][] = { { sx, 0, 0 }, { 0, sy, 0 }, { 0, 0, 1 } };
		Matrix scaledMatrix = new Matrix(matrix);
		Matrix resultMatrix = points.multiply(scaledMatrix);
		return resultMatrix;
	}

}
