package notenoughsnow.state;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import notenoughsnow.application.App;
import notenoughsnow.controller.Coin_controller;
import notenoughsnow.controller.Turn_controller;
import notenoughsnow.model.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

class StateTest {
 
    
	@BeforeAll
	
    static void init() {
		
		Application.launch(App.class);
    	
    	Coin_controller c_controller = new Coin_controller();
    	
    	Model.state = new Game_state();
    	Model.turn = new Turn_state();
 
   	 	c_controller.add_coin(new Coin(1));
   	 	c_controller.add_coin(new Coin(2));
   	 	c_controller.add_coin(new Coin(3));
   	 	c_controller.add_coin(new Coin(4));
   	 	c_controller.add_coin(new Coin(5));
   	 	
   	    c_controller.change_selected(Model.state.coins.get(1));
   	 	c_controller.change_selected(Model.state.coins.get(4));
   	 	c_controller.change_selected(Model.state.coins.get(3));


    }
	
    @Test
    void state_test() {
    	assertEquals(Model.state.coins.size(),5);
    	assertEquals(Model.state.coins.get(1).compareTo(Model.state.coins.get(0)),1);
    	assertEquals(Model.state.coins.get(2).compareTo(Model.state.coins.get(1)),1);
    	assertEquals(Model.state.coins.get(3).compareTo(Model.state.coins.get(2)),1);
    	assertEquals(Model.state.coins.get(4).compareTo(Model.state.coins.get(3)),1);

    	assertEquals(Model.state.coins.get(2).compareTo(Model.state.coins.get(4)),-1);
    	
    	assertEquals(Model.state.coins.get(1).compareTo(Model.state.coins.get(1)),0);
    	
    	
    	
    }
    
    @Test
    void turn_test() {
    	
    	Turn_controller t_controller  = new Turn_controller();
    	
    	assertEquals(Model.turn.selected.size(),3);

    	assertNotEquals(Model.turn.selected.get(0).compareTo(Model.turn.selected.get(1)),0);
    	assertNotEquals(Model.turn.selected.get(0).compareTo(Model.turn.selected.get(2)),0);
    	assertNotEquals(Model.turn.selected.get(1).compareTo(Model.turn.selected.get(2)),0);

    	assertEquals(Model.turn.selected.get(0).position,2);
    	assertEquals(Model.turn.selected.get(1).position,4);
    	assertEquals(Model.turn.selected.get(2).position,5);
    	
    	assertTrue(t_controller.check_validity());


    }

}