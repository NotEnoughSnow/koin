package notenoughsnow.controller;

import java.util.Collections;

import notenoughsnow.model.Model;
import notenoughsnow.state.Coin;
import notenoughsnow.state.Coin_view;

/**
 * 
 * Class responsible for managing graphical and logical coin operations.
 * 
 * 
 * @author notenoughsnow
 *
 */
public class Coin_controller {

	/**
	 * Updates the logical part of the {@link Coin} flip.
	 * 
	 * @see #flip_selected_view(Coin)
	 * @param coin the selected coin
	 */
	public void flip_selected(Coin coin) {
		
		if(!coin.selected) { 
      	  coin.selected = true;
      	  Model.turn.selected.add(coin);
      	  Collections.sort(Model.turn.selected); 
      	  
   	  } 
  	  else {
  		  coin.selected = false; 
      	  Model.turn.selected.remove(Model.turn.selected.indexOf(coin));
      	   
  	  }		
	}
	
	/**
	 * Updates the graphical part of the {@link Coin} flip.
	 * Must be called first.
	 * 
	 * @see #flip_selected(Coin)
	 * @param coin the selected coin
	 */
	public void flip_selected_view(Coin coin) {
		
		if(!coin.selected) {
      	  coin.img.setImage(Coin_view.selected_img);
      	  
   	  } 
  	  else {
  		  coin.restore();
  	  }		
	}
	 
	/**
	 * Adds the given coin to the state.
	 * 
	 * @param coin to be added
	 */
	public void add_coin(Coin coin) {
		Model.state.coins.add(coin);
	}
	
	

}
