package notenoughsnow.model;



/**
 * Player wrapper class.
 * Players are the game's main participants.
 * 
 * @author notenoughsnow
 *
 */
public class Player {
	
	
	public String name;
	
	public Player(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		Player o = (Player) obj;
		
		return this.name.equals(o.name);
	}
	
	
	
	 
}
