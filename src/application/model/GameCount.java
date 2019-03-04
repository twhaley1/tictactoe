package application.model;

import javafx.application.Platform;

/**
 * The Class GameCount.
 * 
 * @author Thomas Whaley
 * @version 1.0
 *
 */
public class GameCount implements Runnable {

	private int count;
	private int seconds;
	private boolean isCounting;
	private CountThreadListener listener;
	
	/**
	 * Creates a new game count object.
	 * 
	 * @precondition seconds >= 0
	 * @postcondition getCount() == 0 && getSeconds() == seconds && isCounting() == false
	 * @param seconds
	 */
	public GameCount(int seconds, CountThreadListener listener) {
		if (seconds < 0) {
			throw new IllegalArgumentException("Invalid unit of time.");
		}
		
		this.count = 0;
		this.seconds = seconds;
		this.isCounting = false;
		this.listener = listener;
	}
	
	/**
	 * Gets the current count 
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return current count
	 */
	public int getCount() {
		return this.count;
	}
	
	/**
	 * Resets the current count
	 * 
	 * @precondition none
	 * @postcondition getCount() == 0 && isCounting()
	 */
	public void resetCount() {
		this.count = 0;
		this.isCounting = true;
	}
	
	/**
	 * Gets the current number of seconds that the game count is counting to.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return number of seconds
	 */
	public int getSeconds() {
		return this.seconds;
	}
	
	/**
	 * Gets the current number of seconds remaining in the game count.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return number of seconds remaining in the game count
	 */
	private int getSecondsRemaining() {
		int timeRemaining = this.seconds - this.count;
		if (timeRemaining > 0) {
			return timeRemaining;
		} else {
			return 0;
		}
	}
	
	/**
	 * Gets if the game count is still counting or not.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the counter is still counting
	 * 			false if the counter has not started counting or is finished counting
	 */
	public boolean isCounting() {
		return this.isCounting;
	}
	
	@Override
	public void run() {
		Platform.runLater(() -> this.listener.update(-1));
		this.isCounting = true;
		long currentTime = System.currentTimeMillis();
		while (this.isCounting) {
			long currentLoopTime = System.currentTimeMillis();
			long delta = currentLoopTime - currentTime;
			if (delta >= 1000) {
				currentTime = System.currentTimeMillis();
				if (this.getSecondsRemaining() <= 5) {
					Platform.runLater(() -> this.listener.update(this.getSecondsRemaining()));
				}
				this.count++;
			}
			if (this.count == this.seconds) {
				this.isCounting = false;
				break;
			}
		}
		Platform.runLater(() -> this.listener.notifyComplete());
	}

}
