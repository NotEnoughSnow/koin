package notenoughsnow.state;

import java.util.ArrayList;

/**
 * 
 * Stores the selected coins in a given turn.
 * The coin list is expectedly sorted, The list will be sorted for each coin addition.
 * Turn Controller is responsible for adding and sorting coins to the list.
 * @see notenoughsnow.controller.Turn_controller
 * 
 * 
 * @author notenoughsnow
 *
 */
public class Turn_state {
	 
	/**
	 * Selected coins list.
	 */
	public ArrayList<Coin> selected;
	
	/**
	 * Initializes selected list.
	 */
	public Turn_state() {
		selected = new ArrayList<Coin>();
		
		
 	} 
	
	
}
