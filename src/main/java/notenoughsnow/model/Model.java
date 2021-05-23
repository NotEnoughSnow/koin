package notenoughsnow.model;

import notenoughsnow.state.Game_state;
import notenoughsnow.state.Turn_state;

public class Model {
	
	public static Game_state state;
	public static Turn_state turn;
	
	public static Player player_one;
	public static Player player_two;
	
	
	
	public Model() {
		
		
		state = new Game_state();
		turn = new Turn_state();
		
		player_one = new Player("yeet");
		player_two = new Player("el wiwi");
		
		
		state.current_player = player_one;

	}

}
