package notenoughsnow.screen;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import notenoughsnow.application.App;
import notenoughsnow.controller.Persistence_controller;
import notenoughsnow.model.Model;
import notenoughsnow.util.Screen;

/**
 * End Screen.
 * @see Screen
 * @see notenoughsnow.screen
 * 
 * @author notenoughsnow
 *
 */
public class End_screen implements Screen {
	

	private Group root;
 
	/**
	 * Creates an end screen instance.
	 * 
	 * @param scene parent scene.
	 * @param p_controller Persistence controller.
	 */
	public End_screen(Scene scene, Persistence_controller p_controller) {
		root = new Group();

		//TODO separate components
		Text winner_text = new Text("Winner");
		Text winner_name = new Text(Model.state.current_player.name);
		winner_text.setStyle("-fx-font: 54 arial;");
		
		winner_name.setStyle("-fx-font: 62 arial;");
		winner_name.setFill(Color.PURPLE); 
		
		VBox vbox = new VBox(winner_text,winner_name);

		vbox.setTranslateX(400);
		vbox.setTranslateY(300);
		vbox.setAlignment(Pos.CENTER);


		
		Button start_game_button = new Button("Return to Main Menu");

		start_game_button.setPrefWidth(150);
		start_game_button.setPrefHeight(70);
		
		start_game_button.setLayoutX(App.width/2-start_game_button.getPrefWidth()/2);
		start_game_button.setLayoutY(550);
		
		start_game_button.setOnMouseClicked(new EventHandler<Event>() {
			
            @Override
			public void handle(Event event) {
            	
            	
        		scene.setRoot(new Menu_screen(scene,p_controller).getRoot());
        		dispose();
          	  }
            
                                                         });
		
		
		root.getChildren().add(start_game_button);
		root.getChildren().add(vbox);
		

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
