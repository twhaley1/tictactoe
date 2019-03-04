package application.viewmodel;

import java.util.ArrayList;

import application.model.Player;
import application.model.PlayerController;
import application.model.PlayerType;
import application.model.UI;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * View Model Class for the GameScreenController
 * 
 * @author Thomas Whaley
 * @version 1.0
 */
public class GameScreenViewModel {

	private PlayerController players;
	private Player currentPlayer;
	private boolean inProgress;
	
	private StringProperty topLeftProperty;
	private StringProperty topMiddleProperty;
	private StringProperty topRightProperty;
	private StringProperty middleLeftProperty;
	private StringProperty middleMiddleProperty;
	private StringProperty middleRightProperty;
	private StringProperty bottomLeftProperty;
	private StringProperty bottomMiddleProperty;
	private StringProperty bottomRightProperty;
	
	private StringProperty topLabelProperty;
	
	/**
	 * Creates a new GameScreenViewModel object
	 * 
	 * @precondition: none
	 * @postcondition: inProgress()==true
	 */
	public GameScreenViewModel() {
		
		this.topLeftProperty = new SimpleStringProperty();
		this.topMiddleProperty = new SimpleStringProperty();
		this.topRightProperty = new SimpleStringProperty();
		this.middleLeftProperty = new SimpleStringProperty();
		this.middleMiddleProperty = new SimpleStringProperty();
		this.middleRightProperty = new SimpleStringProperty();
		this.bottomLeftProperty = new SimpleStringProperty();
		this.bottomMiddleProperty = new SimpleStringProperty();
		this.bottomRightProperty = new SimpleStringProperty();
		this.topLabelProperty = new SimpleStringProperty();
		
		this.inProgress = true;
	}
	
	/**
	 * Sets the view model's player controller and current player
	 * 
	 * @precondition: players != null
	 * @postcondition: getPlayerController().equals(players) && getCurrentPlayer().equals(players.getPlayers().get(0))
	 * 
	 * @param players the PlayerController to set to the view model
	 */
	public void setPlayers(PlayerController players) {
		if (players == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.NULL_PLAYER_CONTROLLER);
		}
		
		this.players = players;
		this.currentPlayer = this.players.getPlayers().get(0);
		
		this.topLabelProperty.set(String.format(UI.TOP_LABEL, this.currentPlayer.getName()));
	}
	
	/**
	 * Sets all of the StringProperties bound to the gui components to "_"
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	public void clearFields() {
		this.topLeftProperty.set("_");
		this.topMiddleProperty.set("_");
		this.topRightProperty.set("_");
		this.middleLeftProperty.set("_");
		this.middleMiddleProperty.set("_");
		this.middleRightProperty.set("_");
		this.bottomLeftProperty.set("_");
		this.bottomMiddleProperty.set("_");
		this.bottomRightProperty.set("_");
	}
	
	/**
	 * Checks if the current state of the game is a victory
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return true if there has been a victory
	 * 			false if the game is not over.
	 */
	private boolean isWin() {
		if (this.topLeftProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) &&
				this.topMiddleProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) && 
				this.topRightProperty.get().equals(PlayerType.getString(this.currentPlayer.getType()))) {
			return true;
		}
		if (this.middleLeftProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) &&
				this.middleMiddleProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) && 
				this.middleRightProperty.get().equals(PlayerType.getString(this.currentPlayer.getType()))) {
			return true;
		}
		if (this.bottomLeftProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) &&
				this.bottomMiddleProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) && 
				this.bottomRightProperty.get().equals(PlayerType.getString(this.currentPlayer.getType()))) {
			return true;
		}
		if (this.topLeftProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) &&
				this.middleLeftProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) && 
				this.bottomLeftProperty.get().equals(PlayerType.getString(this.currentPlayer.getType()))) {
			return true;
		}
		if (this.topMiddleProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) &&
				this.middleMiddleProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) && 
				this.bottomMiddleProperty.get().equals(PlayerType.getString(this.currentPlayer.getType()))) {
			return true;
		}
		if (this.topRightProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) &&
				this.middleRightProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) && 
				this.bottomRightProperty.get().equals(PlayerType.getString(this.currentPlayer.getType()))) {
			return true;
		}
		if (this.topLeftProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) &&
				this.middleMiddleProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) && 
				this.bottomRightProperty.get().equals(PlayerType.getString(this.currentPlayer.getType()))) {
			return true;
		}
		if (this.topRightProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) &&
				this.middleMiddleProperty.get().equals(PlayerType.getString(this.currentPlayer.getType())) && 
				this.bottomLeftProperty.get().equals(PlayerType.getString(this.currentPlayer.getType()))) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks if the game board is full.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return true if the board is full
	 * 			false if the board still has places not taken left
	 */
	private boolean isFull() {
		if (!this.topLeftProperty.get().equals("_") && !this.topMiddleProperty.get().equals("_") && !this.topRightProperty.get().equals("_")
				&& !this.middleLeftProperty.get().equals("_") && !this.middleMiddleProperty.get().equals("_") && !this.middleRightProperty.get().equals("_")
				&& !this.bottomLeftProperty.get().equals("_") && !this.bottomMiddleProperty.get().equals("_") && !this.bottomRightProperty.get().equals("_")) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Switches to the next player.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void changeToNextPlayer() {
		this.currentPlayer = this.players.nextPlayer(this.currentPlayer);
	}
	
	/**
	 * Processes what happens when a player clicks a place on the board.
	 * 
	 * @precondition: property != null
	 * @postcondition: inProgress()==false if a player wins
	 * 
	 * @param property the property that the player has clicked on
	 */
	private void processTurn(StringProperty property) {
		
		String currentContent = property.get();
		if (!currentContent.equals("O") && !currentContent.equals("X") && this.inProgress) {
			property.set(PlayerType.getString(this.currentPlayer.getType()));
		}
		
		if (this.isWin()) {
			this.players.setWinner(this.currentPlayer);
			this.inProgress = false;
	
		} else {
			if (this.isFull()) {
				this.inProgress = false;
			}
		}
		
		this.processTurn();
		
	}
	
	/**
	 * public process turn method that swaps the current player and changes according labels.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void processTurn() {
		if (this.inProgress) {
			this.changeToNextPlayer();
			this.topLabelProperty.set(String.format(UI.TOP_LABEL, this.currentPlayer.getName()));
		}
	}
	
	/**
	 * Runs when the player clicks the topLeft game section.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	public boolean topLeft() {
		this.processTurn(this.topLeftProperty);
		
		if (!this.inProgress) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Runs when the player clicks the topMiddle game section.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	public boolean topMiddle() {
		this.processTurn(this.topMiddleProperty);
		
		if (!this.inProgress) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Runs when the player clicks the topRight game section.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	public boolean topRight() {
		this.processTurn(this.topRightProperty);
		
		if (!this.inProgress) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Runs when the player clicks the middleLeft game section.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	public boolean middleLeft() {
		this.processTurn(this.middleLeftProperty);
		
		if (!this.inProgress) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Runs when the player clicks the center game section.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	public boolean middleMiddle() {
		this.processTurn(this.middleMiddleProperty);
		
		if (!this.inProgress) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Runs when the player clicks the middleRight game section.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	public boolean middleRight() {
		this.processTurn(this.middleRightProperty);
		
		if (!this.inProgress) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Runs when the player clicks the bottomLeft game section.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	public boolean bottomLeft() {
		this.processTurn(this.bottomLeftProperty);
		
		if (!this.inProgress) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Runs when the player clicks the bottomMiddle game section.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	public boolean bottomMiddle() {
		this.processTurn(this.bottomMiddleProperty);
		
		if (!this.inProgress) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Runs when the player clicks the bottomRight game section.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	public boolean bottomRight() {
		this.processTurn(this.bottomRightProperty);
		
		if (!this.inProgress) {
			return true;
		}
		
		return false;
	}

	/**
	 * Gets the collection of players managed by the PlayerController
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return collection of players in the game
	 */
	public ArrayList<Player> getPlayers() {
		return this.players.getPlayers();
	}
	
	/**
	 * Gets the PlayerController
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return player controller
	 */
	public PlayerController getPlayerController() {
		return this.players;
	}

	/**
	 * Gets the top label property
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return top label property
	 */
	public StringProperty topLabelProperty() {
		return this.topLabelProperty;
	}
	
	/**
	 * Gets the top left string property
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return top left string property
	 */
	public StringProperty topLeftProperty() {
		return this.topLeftProperty;
	}

	/**
	 * Gets the top middle string property
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return top middle string property
	 */
	public StringProperty topMiddleProperty() {
		return this.topMiddleProperty;
	}

	/**
	 * Gets the top right string property
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return top right string property
	 */
	public StringProperty topRightProperty() {
		return this.topRightProperty;
	}

	/**
	 * Gets the middle left string property
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return middle left string property
	 */
	public StringProperty middleLeftProperty() {
		return this.middleLeftProperty;
	}

	/**
	 * Gets the center string property
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return center string property
	 */
	public StringProperty middleMiddleProperty() {
		return this.middleMiddleProperty;
	}

	/**
	 * Gets the middle right string property
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return middle right string property
	 */
	public StringProperty middleRightProperty() {
		return this.middleRightProperty;
	}

	/**
	 * Gets the bottom left string property
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return bottom left string property
	 */
	public StringProperty bottomLeftProperty() {
		return this.bottomLeftProperty;
	}

	/**
	 * Gets the bottom middle string property
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return bottom middle string property
	 */
	public StringProperty bottomMiddleProperty() {
		return this.bottomMiddleProperty;
	}

	/**
	 * Gets the bottom right string property
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return bottom right string property
	 */
	public StringProperty bottomRightProperty() {
		return this.bottomRightProperty;
	}
	
}
