package events;


public class MissingConnectionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissingConnectionException(String message) {
		super(message);
	}
}