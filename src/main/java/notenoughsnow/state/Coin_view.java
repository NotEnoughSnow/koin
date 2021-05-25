package notenoughsnow.state;

import javafx.scene.image.Image;

/**
 * Provides global access point to coin images to be used during the game.
 * Coins will switch views to the predefined views when called.
 * 
 * @author notenoughsnow
 *
 */
public class Coin_view {
	
	 /**
		 * Image source for heads.
		 */
	 public static Image heads_img =  new Image("assets/coin1.png");
	 /**
		 * Image source for tails.
		 */
	 public static Image tails_img =  new Image("assets/coin2.png");
	 /**
		 * Image source for selected.
		 */
	 public static Image selected_img =  new Image("assets/coin3.png");
	 
	 
	 

}
