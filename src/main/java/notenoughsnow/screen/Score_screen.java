package notenoughsnow.screen;

import java.util.ArrayList;
import java.util.Collections;

import org.tinylog.Logger;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import notenoughsnow.application.App;
import notenoughsnow.controller.Player_score;
import notenoughsnow.controller.Presistance_controller;
import notenoughsnow.presistance.Game_result;
import notenoughsnow.presistance.Session;
import notenoughsnow.util.Screen;

public class Score_screen implements Screen {
	
	private Group root;


	
	public Score_screen(Scene scene, Presistance_controller p_controller) {
		root = new Group();
		
		Text welcome_text = new Text("Top 5 HighScores!");
		welcome_text.setX(App.width/2-150);
		welcome_text.setY(100);
		welcome_text.setStyle("-fx-font: 31 arial;");

		
	
		
		
		ArrayList<Player_score> scores = get_score();
    	  Collections.sort(scores); 
		Logger.info(scores);

	    VBox vbox = new VBox();
	    vbox.setTranslateX(450);
	    vbox.setTranslateY(150);
	    vbox.setSpacing(25);
	    
	    for (int i = 0;i < 5 ; i++) {
	    	Text player_name = new Text(scores.get(i).player);
			Text player_score = new Text(Integer.toString(scores.get(i).score));
			player_name.setStyle("-fx-font: 24 arial;");
			player_score.setStyle("-fx-font: 24 arial;");

	    	HBox hbox = new HBox();
			hbox.setSpacing(50);
			hbox.setAlignment(Pos.CENTER_RIGHT);
			
			hbox.getChildren().add(player_name);
			hbox.getChildren().add(player_score);
			
		    vbox.getChildren().add(hbox);

	    }


		Button menu_button = new Button("Back to Main Menu");
		menu_button.setScaleX(2);
		menu_button.setScaleY(2);
		menu_button.setTranslateX(App.width/2-50);
		menu_button.setTranslateY(500);

		
		menu_button.setOnMouseClicked(new EventHandler<Event>() {
			
            @Override
			public void handle(Event event) {
            	
        		scene.setRoot(new Menu_screen(scene,p_controller).getRoot());
        		dispose();

          	  }
            
                                                         });
		 
		
		
		
		 
		root.getChildren().add(welcome_text); 
		root.getChildren().add(menu_button); 
		root.getChildren().add(vbox); 

		

	}

	private ArrayList<Player_score> get_score() {
		ArrayList<Player_score> s = new ArrayList<Player_score>();
		
		for (Game_result x : Session.loaded_session.getGames()) {
			Player_score val = new Player_score(x.getWinner());
			
			if(s.contains(val)) s.get(s.indexOf(val)).score++;
			else s.add(val);
		}
		
		return s;
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
