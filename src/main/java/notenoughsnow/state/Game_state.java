package notenoughsnow.state;

import java.util.ArrayList;

import notenoughsnow.model.Player;

/**
 * 
 * Provides the current game state.
 * Stores created {@link Coin} and their values as well as the current player and the moves played during the game.
 * 
 * @author notenoughsnow
 *
 */
public class Game_state {
	
	/**
	 * The state List.
	 */
	public ArrayList<Coin> coins;
	
	/**
	 * Current player.
	 */
	public Player current_player;
	
	/**
	 * Moves Played.
	 */
	public int moves_played;

	/**
	 * Initializes the state list.
	 */
	public Game_state() {
		coins = new ArrayList<Coin>();
		
	}

}
