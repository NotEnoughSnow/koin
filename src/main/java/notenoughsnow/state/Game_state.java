package notenoughsnow.state;

import java.util.ArrayList;

import notenoughsnow.model.Player;

public class Game_state {
	
	
	public ArrayList<Coin> coins;
	public Player current_player;

	public Game_state() {
		coins = new ArrayList<Coin>();
		
	}

}
