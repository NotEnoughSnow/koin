package notenoughsnow.model;

import notenoughsnow.state.Game_state;
import notenoughsnow.state.Turn_state;

/**
 * A model to hold various game data such as states and players.
 * Provides global access points for the data for ease of access but is used restrictively.
 * 
 * 
 * @author notenoughsnow
 *
 */
public class Model {
	/**
	 * Game state.
	 */
	public static Game_state state;
	/**
	 * Turn state.
	 */
	public static Turn_state turn;
	
	/**
	 * First Player.
	 */
	public static Player player_one;
	/**
	 * Second Player.
	 */
	public static Player player_two;
	
	
	/**
	 * Used for initializing state variables.
	 */
	public Model() {
		
		state = new Game_state();
		turn = new Turn_state();

	}

}
