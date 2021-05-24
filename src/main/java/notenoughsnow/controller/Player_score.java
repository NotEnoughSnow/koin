package notenoughsnow.controller;

public class Player_score implements Comparable<Player_score>{
	
	

	public String player;
	public int score;
	
	public Player_score(String player) {
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
			return 11;
		return 0;
	}
   
}
