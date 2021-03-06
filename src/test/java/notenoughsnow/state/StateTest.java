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

class StateTest {
 
    
	@BeforeAll
    static void init() {
		
		
		StateInit.init();
    }
	
    @Test
    void size_test() {
    	assertEquals(Model.state.coins.size(),5);
   
    	
    }
    
    @Test
    void compare_test() {
    	
    	assertEquals(Model.state.coins.get(1).compareTo(Model.state.coins.get(0)),1);
    	assertEquals(Model.state.coins.get(2).compareTo(Model.state.coins.get(1)),1);
    	assertEquals(Model.state.coins.get(3).compareTo(Model.state.coins.get(2)),1);
    	assertEquals(Model.state.coins.get(4).compareTo(Model.state.coins.get(3)),1);

    	assertEquals(Model.state.coins.get(2).compareTo(Model.state.coins.get(4)),-1);
    	
    	assertEquals(Model.state.coins.get(1).compareTo(Model.state.coins.get(1)),0);
    	
    }
    

}