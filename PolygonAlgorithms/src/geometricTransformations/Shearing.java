package geometricTransformations;

import matrices.Matrix;
import exceptions.InvalidMatrixOperationException;


public class Shearing implements GeometricTransformation {
	private final int shx;
	private final int shy;
	private final int xref;// x = xref
	private final int yref;// y = yref
	public Shearing(int shx,  int yref, int shy, int xref){
		this.shx = shx;
		this.shy = shy;
		this.xref = xref;
		this.yref = yref;
	}
	@Override
	public Matrix transform(Matrix points)
			throws InvalidMatrixOperationException {
		double matrix[][] = { { 1, shy, 0 }, { shx, 1, 0 },
				{ -shx*yref, -shy*xref, 1 } };
		Matrix reflectionMatrix = new Matrix(matrix);
		Matrix resultMatrix = points.multiply(reflectionMatrix);
		return resultMatrix;
	}

	
}
