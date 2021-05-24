package notenoughsnow.controller;

import javafx.scene.text.Text;
import notenoughsnow.model.Model;
import notenoughsnow.model.Player;
import notenoughsnow.state.Coin;

public class Turn_controller {
	 
	
	public void update_turn_text(Text player_turn_text) {
		
		player_turn_text.setText("Player "+Model.state.current_player.name+"'s turn!");

	}
	
	/**
	 * Ends the turn by flipping selected coins.
	 * Acts as the logical part of the operation.
	 * @see #end_turn_view()
	 */
	public void end_turn() {
		
		for(Coin c:Model.turn.selected) {
				
		c.tails = !c.tails;
		c.selected = false;
			}  
		
		Model.turn.selected.clear();
			swap_players(); 
	  }
	
	
	/**
	 * Ends the turn by flipping selected coins.
	 * Acts as the graphical part of the operation.
	 * Must be called first.
	 * @see #end_turn()
	 */
	public void end_turn_view() {

			for(Coin c:Model.turn.selected)
					c.flip();
	     }
	
	/**
	 * Method to check game conclusion.
	 * @return True if the game is over, False if not.
	 */
	public boolean check_game_goal() {
		
		for(Coin c:Model.state.coins) {
			if (!c.tails) return false; 
		}
		return true;
	}
	
	/**
	 * swap current {@link Player} by another on turn-end.
	 */
	public void swap_players() {
		
		if(Model.state.current_player == Model.player_one) {
			Model.state.current_player = Model.player_two;
		}
		else {
			Model.state.current_player = Model.player_one; 
		}
	}
	

	 
	/**
	 * Checks the turn validity after each selected {@link Coin}.
	 * @return True if the turn is valid, False if not.

	 */
	public boolean check_validity() {
		
		if(Model.turn.selected.size()>0 
				&& Model.turn.selected.size() < 4 
				&& !Model.turn.selected.get(Model.turn.selected.size()-1).tails)  
			    return true;
		
		return false;
		}
	
}
