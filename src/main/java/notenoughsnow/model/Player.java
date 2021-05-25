package notenoughsnow.model;



/**
 * Player wrapper class.
 * Players are the game's main participants.
 * 
 * @author notenoughsnow
 *
 */
public class Player {
	
	/**
	 * Variable to store player name.
	 */
	public String name;
	
	/**
	 * Creates a Player with the given name.
	 * @param name the given name.
	 */
	public Player(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		Player o = (Player) obj;
		
		return this.name.equals(o.name);
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
	
	
	 
}
