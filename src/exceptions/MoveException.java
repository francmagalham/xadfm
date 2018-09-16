package exceptions;

public class MoveException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public MoveException (String msg) {
		super (msg);
	}
}
