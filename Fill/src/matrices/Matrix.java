package matrices;

import exceptions.InvalidMatrixOperationException;

public class Matrix {
	public double matrix[][];
	public final int rows;
	public final int columns;

	public Matrix(double matrix[][]) {
		this.matrix = matrix;
		this.rows = matrix.length;
		this.columns = matrix[0].length;
	}

	public Matrix multiply(Matrix m) throws InvalidMatrixOperationException {
		int rows1 = this.rows;
		int columns1 = this.columns;
		int rows2 = m.rows;
		int columns2 = m.columns;
		if (columns1 != rows2) {// Matrix m cannot be multiplied
			throw new InvalidMatrixOperationException(
					"Matrices cannot be multiplied because they have incompatible dimensions");
		}
		double result[][] = new double[rows1][columns2];
		int sum;
		for (int i = 0; i < rows1; i++) {
			for (int j = 0; j < columns2; j++) {
				sum = 0;
				for (int k = 0; k < columns1; k++) {
					sum += this.matrix[i][k] * m.matrix[k][j];
				}
				result[i][j] = sum;
			}
		}
		Matrix resultMatrix = new Matrix(result);
		return resultMatrix;
	}

	public Matrix add(Matrix m) throws InvalidMatrixOperationException {
		if (m.rows != rows || m.columns != columns) {
			throw new InvalidMatrixOperationException(
					"Matrices cannot be added because they have incompatible dimensions");
		}
		double result[][] = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result[i][j] = this.matrix[i][j] + m.matrix[i][j];
			}
		}
		Matrix resultMatrix = new Matrix(result);
		return resultMatrix;
	}
}
