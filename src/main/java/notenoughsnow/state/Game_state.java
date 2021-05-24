package notenoughsnow.state;

import java.util.ArrayList;

import notenoughsnow.model.Player;

public class Game_state {
	
	
	public ArrayList<Coin> coins;
	public Player current_player;
	public int moves_played;

	public Game_state() {
		coins = new ArrayList<Coin>();
		
	}

}
