package application.model;

/**
 * The Interface ThreadListener
 * 
 * @author Thomas Whaley
 * @version 1.0
 */
public interface ThreadListener {

	/**
	 * Defines the behavior of what happens when the thread completes.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	void notifyComplete();
	
}
