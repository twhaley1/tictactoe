package application.model;

/**
 * Exception to be thrown when players have matching types.
 * 
 * @author Thomas Whaley
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IllegalTypeException extends IllegalArgumentException {
	
	/**
	 * Constructs a new IllegalTypeException
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @param message the exception message
	 */
	public IllegalTypeException(String message) {
		super(message);
	}
}
