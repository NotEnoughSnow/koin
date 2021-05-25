package notenoughsnow.state;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import notenoughsnow.application.App;
import notenoughsnow.controller.Coin_controller;
import notenoughsnow.controller.Persistence_controller;
import notenoughsnow.controller.Turn_controller;
import notenoughsnow.model.Model;
import notenoughsnow.model.Player;
import notenoughsnow.screen.Menu_screen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

class TurnTest {
 
    
	@BeforeAll
    static void init() {
		 
		StateInit.init();
    }
 
    @Test
    void size_test() {
    	
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
    
    @Test
    void compare_test() {
    	 
    	assertNotEquals(Model.turn.selected.get(0).compareTo(Model.turn.selected.get(1)),0);
    	assertNotEquals(Model.turn.selected.get(0).compareTo(Model.turn.selected.get(2)),0);
    	assertNotEquals(Model.turn.selected.get(1).compareTo(Model.turn.selected.get(2)),0);
 

    }
    
    @Test
    void position_test() {
    	assertEquals(Model.turn.selected.get(0).position,2);
    	assertEquals(Model.turn.selected.get(1).position,4);
    	assertEquals(Model.turn.selected.get(2).position,5);
  

    }
    
    @Test
    void validity_test() {
    	
    	Turn_controller t_controller  = new Turn_controller();
    	
    	assertTrue(t_controller.check_validity());

    }
    
    @AfterAll
    static void endTurn_test() {
    	
    	Turn_controller t_controller  = new Turn_controller();

    	t_controller.end_turn();
    	
    	assertEquals(Model.turn.selected.size(),0);
    	
     	Model.player_one = new Player("John");
    	Model.player_two = new Player("Ron");
    	Model.state.current_player = Model.player_one;
    	
    	t_controller.swap_players();
    	
    	assertEquals(Model.state.current_player,Model.player_two);

    }
    
    @Test
     void goal_test() {
    	
    	Turn_controller t_controller  = new Turn_controller();

    	
    	for(Coin c : Model.state.coins) {
    		c.tails = true;
    	}
    	
    	assertTrue(Model.state.coins.get(0).tails);
    	assertTrue(Model.state.coins.get(1).tails);
    	assertTrue(Model.state.coins.get(2).tails);
    	assertTrue(Model.state.coins.get(3).tails);
    	assertTrue(Model.state.coins.get(4).tails);

    	
    	assertTrue(t_controller.check_game_goal());

    }
    

}