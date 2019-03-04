package application.model;

/**
 * The Interface CountThreadListener.
 * 
 * @author Thomas Whaley
 * @version 1.0
 */
public interface CountThreadListener extends ThreadListener {

	/**
	 * Defines the behavior to be implemented each second of the counting thread.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	void update(int seconds);
}
