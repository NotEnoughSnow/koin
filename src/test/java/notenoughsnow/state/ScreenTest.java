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
import notenoughsnow.controller.Presistance_controller;
import notenoughsnow.controller.Turn_controller;
import notenoughsnow.model.Model;
import notenoughsnow.screen.Menu_screen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

class ScreenTest {
 
	static Menu_screen menu;
    
	@BeforeAll
	
    static void init() {
		
		Application.launch(App.class);
    	
		Group root = new Group();
		Scene scene = new Scene(root,Color.BEIGE);
    	 menu = new Menu_screen(scene, new Presistance_controller());
    	
    	


    }
	
	 @Test
	    void root_test() {
	    	assertNotEquals(menu.getRoot(), null);
	    }
	
    @Test
    void despose_test() {
    	menu.dispose();
    	assertEquals(menu.getRoot().getChildren().size(), 0);
    }

}