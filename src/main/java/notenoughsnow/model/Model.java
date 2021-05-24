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
	
	public static Game_state state;
	public static Turn_state turn;
	
	public static Player player_one;
	public static Player player_two;
	
	
	
	public Model() {
		
		state = new Game_state();
		turn = new Turn_state();
		
		player_one = new Player("");
		player_two = new Player("");
		
		
		state.current_player = player_one;

	}

}
