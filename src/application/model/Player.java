package application.model;

/**
 * Represents a player in the Tic Tac Toe game.
 * 
 * @author Thomas Whaley
 * @version 1.0
 *
 */
public class Player {

	private String name;
	private PlayerType type;
	private boolean isX;
	private boolean isO;
	
	/**
	 * Creates a new Player object.
	 * 
	 * @precondition: name != null && type != null
	 * @postcondition: getName() == name && isX() [if type == PlayerType.X]
	 * 					&& isO() [if type == PlayerType.O]
	 * 
	 * @param name the player's name
	 * @param type the player's type
	 */
	public Player(String name, PlayerType type) {
		if (name == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.NULL_NAME);
		}
		if (type == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.NULL_PLAYER_TYPE);
		}
		
		this.name = name;
		this.type = type;
		if (type == PlayerType.X) {
			this.isX = true;
			this.isO = false;
		} else if (type == PlayerType.O) {
			this.isX = false;
			this.isO = true;
		}
	}
	
	/**
	 * Gets the player's type.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return player type
	 */
	public PlayerType getType() {
		return this.type;
	}
	
	/**
	 * Gets the player's name
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return the player's name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets whether or not the player is x
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return whether or not the player is x
	 */
	public boolean isX() {
		return this.isX;
	}
	
	/**
	 * Gets whether or not the player is o
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return whether or not the player is o
	 */
	public boolean isO() {
		return this.isO;
	}
	
	@Override
	public String toString() {
		return this.name + ": " + PlayerType.getString(this.type);
	}
}
