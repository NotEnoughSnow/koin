package notenoughsnow.screen;

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

class ScreenTest {
 
	static Mock_screen mock;
    
	@BeforeAll
    static void init() {
		mock = new Mock_screen();
    }
	
	 @Test
	    void root_test() {
	    	assertNotEquals(mock.getRoot(), null);
	    }
	
	 @Test
	 void dispose_test() {
		 
		 assertNotEquals(mock.getRoot().getChildren().size(), 0);
		 mock.dispose();
		 assertEquals(mock.getRoot().getChildren().size(), 0);
	 }

}