package notenoughsnow.application;


import org.tinylog.Logger;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import notenoughsnow.controller.Presistance_controller;
import notenoughsnow.model.Model;
import notenoughsnow.screen.Menu_screen;
import notenoughsnow.state.Coin_view;


/**
 * Responsible for initializing the stage, scene and window of the application
 *
 */
public class App extends Application {
	
	public static final int  width = 1100;
	public static final int height = 800;
 
    
	@Override
	public void start(Stage stage) {
		
		new Coin_view();
		new Model();
		
		Logger.info(Coin_view.heads_img);
		
		Presistance_controller p_controller = new Presistance_controller();
		p_controller.load();

		stage.setWidth(width);
		stage.setHeight(height);
		stage.setResizable(false);
		
		Group root = new Group();
		Scene scene = new Scene(root,Color.BEIGE);
		stage.setScene(scene);
		
		// sets the current screen
		stage.getScene().setRoot(new Menu_screen(scene,p_controller).getRoot());
		

		stage.show();
		  
	}

 
	

	
	
	





}
