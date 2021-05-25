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

import org.junit.jupiter.api.BeforeAll;

class StateInit {
 
    
	@BeforeAll
    static void init() {
		
    	Coin_controller c_controller = new Coin_controller();
    	
    	Model.state = new Game_state();
    	Model.turn = new Turn_state();
 
   	 	c_controller.add_coin(new Coin(1));
   	 	c_controller.add_coin(new Coin(2));
   	 	c_controller.add_coin(new Coin(3));
   	 	c_controller.add_coin(new Coin(4));
   	 	c_controller.add_coin(new Coin(5));
   	 	
   	    c_controller.flip_selected(Model.state.coins.get(1));
   	 	c_controller.flip_selected(Model.state.coins.get(4));
   	 	c_controller.flip_selected(Model.state.coins.get(3));

   	 	
 	
    }

}