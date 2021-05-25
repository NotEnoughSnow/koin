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
import notenoughsnow.screen.Menu_screen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;

class CoinTest {
  
    @Test
    void coin_test() {
    	
    	Coin_controller c_controller = new Coin_controller();
    	Model.turn = new Turn_state();
    	Model.turn.selected = new ArrayList<Coin>();
    	
    	Model.state = new Game_state();
    	Model.state.coins = new ArrayList<Coin>();
    	
    	Coin c = new Coin(1);
    	
    	assertEquals(c.position,1);

    	c_controller.flip_selected(c);
    	
    	assertTrue(c.selected);
    	assertFalse(c.tails);
    	assertEquals(Model.turn.selected.size(),1);

    	c_controller.flip_selected(c);

    	assertFalse(c.selected);
    	assertFalse(c.tails);
    	assertEquals(Model.turn.selected.size(),0);
    	
    	c_controller.add_coin(c);
    	
    	assertEquals(Model.state.coins.size(),1);

    	

    	
    }
    

}