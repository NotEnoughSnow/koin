package notenoughsnow.screen;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import notenoughsnow.application.App;
import notenoughsnow.application.PresistanceController;
import notenoughsnow.controller.Turn_controller;
import notenoughsnow.util.Screen;

public class Menu_screen implements Screen {
	
	private Group root;
	
	
	private Button start_game_button;
	private Button score_button;
	private Text welcome_text = new Text("Welcome!");

	
	public Menu_screen(Scene scene, PresistanceController p_controller) {
		root = new Group();
		
		welcome_text.setX(App.width/2-50);
		welcome_text.setY(100);
		
		
		start_game_button = new Button("start game");

		start_game_button.setPrefWidth(150);
		start_game_button.setPrefHeight(70);
		
		start_game_button.setLayoutX(App.width/2-start_game_button.getPrefWidth()/2);
		start_game_button.setLayoutY(550);
		
		

		start_game_button.setOnMouseClicked(new EventHandler<Event>() {
			
            @Override
			public void handle(Event event) {
            	
            	
        		scene.setRoot(new Game_screen(scene, p_controller).getRoot());
        		dispose();
          	  }
            
                                                         });
		
		
		score_button = new Button("High Scores");

		score_button.setPrefWidth(150);
		score_button.setPrefHeight(70);
		
		score_button.setLayoutX(App.width/2-score_button.getPrefWidth()/2);
		score_button.setLayoutY(550+200);

		score_button.setOnMouseClicked(new EventHandler<Event>() {
			
            @Override
			public void handle(Event event) {
            	
            	
        		scene.setRoot(new Score_screen().getRoot());
        		dispose();
          	  }
            
                                                         });
		
		
		root.getChildren().add(start_game_button);
		root.getChildren().add(welcome_text);
		

	}

	@Override
	public Group getRoot() {
		return root;
	}

	@Override
	public void dispose() {
    	root.getChildren().clear();		
	}

}
