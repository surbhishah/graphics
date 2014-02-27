package exceptions;

@SuppressWarnings("serial")
public class InvalidMatrixOperationException extends Exception {
	public InvalidMatrixOperationException() {
		super("InvalidMatrixOperationException raised");
	}

	public InvalidMatrixOperationException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return "InvalidMatrixOperationException...\n\nMessage:"
				+ this.getMessage() + "\n\nStackTrace:" + this.getStackTrace();
	}
}
