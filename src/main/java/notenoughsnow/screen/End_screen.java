package notenoughsnow.screen;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import notenoughsnow.application.App;
import notenoughsnow.application.PresistanceController;
import notenoughsnow.model.Model;
import notenoughsnow.util.Screen;

public class End_screen implements Screen {
	
	private Group root;
	
	
	private Button start_game_button;
	private Text winner_text;

	
	public End_screen(Scene scene, PresistanceController p_controller) {
		root = new Group();
		
		winner_text = new Text("Winner\n"+Model.state.current_player.name);
		winner_text.setX(App.width/2-50);
		winner_text.setY(100);
		
		
		start_game_button = new Button("return to main menu");

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
		root.getChildren().add(winner_text);
		

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
