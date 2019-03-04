package application.model;

import java.util.ArrayList;

/**
 * Wrapper class for a collection of players
 * 
 * @author Thomas Whaley
 * @version 1.0
 *
 */
public class PlayerController {

	private ArrayList<Player> players;
	private Player winner;
	
	/**
	 * Creates a new PlayerController object
	 * 
	 * @precondition: none
	 * @postcondition: collection of players is instantiated
	 */
	public PlayerController() {
		this.players = new ArrayList<Player>();
	}
	
	/**
	 * Gets the collection of players.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return collection of players
	 */
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	
	/**
	 * Gets the winner of the game.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the winner. NOTE: A CALL TO THIS METHOD WILL RESULT IN NULL
	 * IF THE WINNER HAS NOT BEEN SET YET. THIS MEANS A PLAYER HAS NOT WON.
	 */
	public Player getWinner() {
		return this.winner;
	}
	
	/**
	 * Sets the game's winner.
	 * 
	 * @precondition none
	 * @postcondition getWinner() == thePlayer
	 * 
	 * @param thePlayer the player to set as the winner
	 */
	public void setWinner(Player thePlayer) {
		this.winner = thePlayer;
	}
	
	/**
	 * Gets the number of players in the collection.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return number of players
	 */
	public int numberOfPlayers() {
		return this.players.size();
	}
	
	/**
	 * Adds a player to the collection of players.
	 * 
	 * @precondition: newPlayer != null && !this.matchesTypes(newPlayer)
	 * @postcondition: numberOfPlayers() == numberOfPlayers()@prev + 1
	 * 
	 * @param newPlayer the player to add to the collection
	 * @return true if the player was added successfully
	 * 			false if the player was not added
	 */
	public boolean add(Player newPlayer) {
		if (newPlayer == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.NULL_NEW_PLAYER);
		}
		if (this.matchesTypes(newPlayer)) {
			throw new IllegalTypeException(UI.ExceptionMessages.MATCHING_TYPES);
		}
		
		return this.players.add(newPlayer);
	}
	
	/**
	 * Gets the other player in the collection of two players.
	 * 
	 * @precondition: currentPlayer != null
	 * @postcondition: none
	 * 
	 * @param currentPlayer the player whose turn just ended.
	 * @return the next player 
	 */
	public Player nextPlayer(Player currentPlayer) {
		if (currentPlayer == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.NULL_PLAYER);
		}
		
		if (currentPlayer.equals(this.players.get(0))) {
			return this.players.get(1);
		} else {
			return this.players.get(0);
		}
	}
	
	/**
	 * Determines if a player contains a PlayerType that is already taken by
	 * another player in the collection.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @param newPlayer the player to compare to the collection
	 * @return true if the type is already in the collection
	 * 			false if the type is not already taken
	 */
	private boolean matchesTypes(Player newPlayer) {
		PlayerType checkType = newPlayer.getType();
		
		for (Player currentPlayer : this.players) {
			if (currentPlayer.getType() == checkType) {
				return true;
			}
		}
		
		return false;
	}
}
