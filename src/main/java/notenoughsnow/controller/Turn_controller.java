package notenoughsnow.controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import notenoughsnow.model.Model;
import notenoughsnow.model.Player;
import notenoughsnow.state.Coin;

public class Turn_controller {
	
	public Turn_controller(Text player_turn_text) {
		update_turn_text(player_turn_text);
	}
	
	public void update_turn_text(Text player_turn_text) {
		
		player_turn_text.setText("Player "+Model.state.current_player.name+"'s turn!");

	}
	
	public boolean end_turn(Scene scene,Text player_text) {
		
		boolean goal = true;
		 
			for(Coin c:Model.state.coins) {
				
				if(c.selected) {
					if(c.tails) {
						c.img.setImage(c.heads_img);
						c.tails = false;
					}
					else {
						c.img.setImage(c.tails_img);
						c.tails = true;
				    	}  
					    
					c.selected = false;
					Model.turn.selected.clear();
				}
				
				if (!c.tails) goal = false; 
				
			} 
			
			if(goal) {
				return end_game(scene);
			}
			
			
			if(Model.state.current_player == Model.player_one) {
				Model.state.current_player = Model.player_two;
			}
			else {
				Model.state.current_player = Model.player_one;

			}
				update_turn_text(player_text);
				return false;
	  }
	

	public void validate_turn(Button next_turn_button) {

	  if (check_validity()) next_turn_button.setDisable(false);
	  else 
		next_turn_button.setDisable(true);
		}
	
	public static  boolean check_validity() {
		
		if(Model.turn.selected.size()>0 && Model.turn.selected.size() < 4 && !Model.turn.selected.get(Model.turn.selected.size()-1).tails)  
			 
			return true;
			
				
		
		return false;
		}
	
	
	public static boolean end_game(Scene scene) { 
		return true;
	}

}
