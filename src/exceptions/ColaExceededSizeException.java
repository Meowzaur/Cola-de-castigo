package exceptions;

public class ColaExceededSizeException extends IndexOutOfBoundsException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ColaExceededSizeException(String s) {
		super(s);
	}

}
