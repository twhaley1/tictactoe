package application.model;

/**
 * The Abstract Controller class.
 * 
 * @author Thomas Whaley
 * @version 1.0
 */
public abstract class Controller {

	private PlayerController playerController;
	
	/**
	 * Binds players to the controller's corresponding view model. Not necessary for
	 * controller's that do not use a view model.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public abstract void bindPlayersToViewModel();
	
	/**
	 * Gets the player controller
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return player controller
	 */
	public PlayerController getPlayerController() {
		return this.playerController;
	}
	
	/**
	 * Sets a PlayerController object. Used to 
	 * carry information about the players of the game.
	 * 
	 * @precondition: pc != null
	 * @postcondition: getPlayerController() == pc
	 * 
	 * @param pc the PlayerController to set to the Controller
	 */
	public void setPlayerController(PlayerController pc) {
		if (pc == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.NULL_PLAYER_CONTROLLER);
		}
		
		this.playerController = pc;
	}
}
