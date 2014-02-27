package geometricTransformations;

import exceptions.InvalidMatrixOperationException;
import graphics.Point;
import matrices.Matrix;

public class Rotation implements GeometricTransformation {
	private final int angle;// angle in degrees
	private final Point rotationPoint;

	public Rotation(int angle, Point rotationPoint) {
		this.angle = angle;
		this.rotationPoint = rotationPoint;
	}

	@Override
	public Matrix transform(Matrix points)
			throws InvalidMatrixOperationException {
		double radian = Math.PI * angle / 180;
		double cos = Math.cos(radian);
		double sin = Math.sin(radian);
		double matrix[][] = {
				{ cos, sin, 0 },
				{ -sin, cos, 0 },
				{ rotationPoint.x * (1 - cos) + rotationPoint.y * sin,
						rotationPoint.y * (1 - cos) - rotationPoint.x * sin, 1 } };
		Matrix rotationMatrix = new Matrix(matrix);
		Matrix resultMatrix = points.multiply(rotationMatrix);
		return resultMatrix;
	}

}
