package matrices;

public class Matrix {
	public int matrix[][];

	public Matrix(int matrix[][]) {
		this.matrix = matrix;
	}
	public Matrix multiply(Matrix m){
		int rows1 = this.matrix.length;
		int columns1 = this.matrix[0].length; 
		int rows2 = m.matrix.length;
		int columns2 = m.matrix[0].length;
		int result[][]= new int[rows1][columns2];
		int sum;
		if(columns1 != rows2){
			return null;
		}
		for(int i = 0 ; i< rows1 ; i++){
			for(int j = 0 ; j<columns2 ; j++){
				sum = 0;
				for(int k=0 ; k< columns1 ; k++){
					sum +=  this.matrix[i][k] * m.matrix[k][j];
				}
				result[i][j] = sum;
			}
		}
		Matrix resultMatrix = new Matrix(result);
		return resultMatrix;
	}
}
