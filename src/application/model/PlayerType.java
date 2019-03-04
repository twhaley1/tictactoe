package application.model;

/**
 * The Enumeration PlayerType
 * 
 * @author Thomas Whaley
 * @version 1.0
 *
 */
public enum PlayerType {

	X, O;
	
	/**
	 * Gets the corresponding PlayerType.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @param value represents if x is true or false
	 * @return X if value==true else O if value==false
	 */
	public static PlayerType isX(boolean value) {
		if (value) {
			return PlayerType.X;
		} else {
			return PlayerType.O;
		}
	}
	
	/**
	 * Gets the corresponding PlayerType
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @param value represents if o is true or false
	 * @return O if value==true else X if value==false
	 */
	public static PlayerType isO(boolean value) {
		if (value) {
			return PlayerType.O;
		} else {
			return PlayerType.X;
		}
	}
	
	/**
	 * Gets the corresponding string of a PlayerType
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @param type the PlayerType to get the corresponding String
	 * @return empty string if type==null 
	 * 			"X" if type==PlayerType.X
	 * 			"O" if type==PlayerType.O
	 */
	public static String getString(PlayerType type) {
		if (type == null) {
			return "";
		} else if (type == PlayerType.X) {
			return "X";
		} else {
			return "O";
		}
	}
}
