package notenoughsnow.persistence;

import notenoughsnow.model.Player;

/**
 * 
 * Hold data to be used for calculating high-scores.
 * 
 * 
 * @author notenoughsnow
 *
 */
public class Player_score implements Comparable<Player_score>{
	
	
	/**
	 * Stored Player.
	 */
	public Player player;
	
	/**
	 * Assigned Score.
	 */
	public int score;
	
	/**
	 * Creates a new player instance.
	 * 
	 * @param player mainly through {@code player.name}
	 */
	public Player_score(Player player) {
		this.player = player;
		score = 1;
	}

	@Override
	public boolean equals(Object obj) {
		Player_score o = (Player_score) obj;
		return o.player.equals(this.player);
	}
	
    
	@Override
	public String toString() {
		return player+"( "+score+" )";
	}

	@Override
	public int compareTo(Player_score o) {
	
		if(this.score>o.score)
			return -1;
		if(this.score<o.score)
			return 1;
		return 0;
	}
   
}
