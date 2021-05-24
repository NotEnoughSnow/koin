package notenoughsnow.controller;

import java.util.Collections;

import notenoughsnow.model.Model;
import notenoughsnow.state.Coin;
import notenoughsnow.state.Coin_view;

public class Coin_controller {

	
	public void change_selected(Coin c) {
		if(!c.selected) { 
      	  c.selected = true; 
      	  
      	  c.img.setImage(Coin_view.selected_img);
      	  
      	  Model.turn.selected.add(c);
      	  Collections.sort(Model.turn.selected); 
   	  } 
  	  else {
  		  c.selected = false; 
  		  
  		  if(c.tails)
      	    c.img.setImage(Coin_view.tails_img);
  		  else
          	c.img.setImage(Coin_view.heads_img);
  		  
      	  Model.turn.selected.remove(Model.turn.selected.indexOf(c));
      	  
  		  
  	  }		
	}
	
	public void add_coin(Coin c) {
		Model.state.coins.add(c);
	}

}
