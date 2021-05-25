package notenoughsnow.screen;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import notenoughsnow.application.App;
import notenoughsnow.controller.Persistence_controller;
import notenoughsnow.model.Model;
import notenoughsnow.model.Player;
import notenoughsnow.util.Screen;

/**
 * Menu Screen.
 * @see Screen
 * @see notenoughsnow.screen
 * 
 * @author notenoughsnow
 *
 */
public class Menu_screen implements Screen {

	private Group root;


	/**
	 * Creates a game screen instance.
	 * 
	 * @param scene parent scene.
	 * @param p_controller Persistence controller.
	 */
	public Menu_screen(Scene scene, Persistence_controller p_controller) {
		root = new Group();
		
		//TODO separate components

		Text welcome_text = new Text("Welcome! please select player names and start!");
		welcome_text.setX(App.width/2-270);
		welcome_text.setY(500);
		welcome_text.setStyle("-fx-font: 25 arial;");

		
	    
		
	    TextField player_one_field = new TextField();  
	    player_one_field.setText("player one");
	    TextField player_two_field = new TextField();  
	    player_two_field.setText("player two");

	    HBox player_fields = new HBox();
	    
	    player_fields.setTranslateY(540);
	    player_fields.setTranslateX(340);
	    player_fields.setSpacing(100);
	    
	    player_fields.getChildren().add(player_one_field);
	    player_fields.getChildren().add(player_two_field);

	
		
		ImageView coin = new ImageView(new Image("assets/coin.png")); 
		coin.setTranslateX(800);
		coin.setTranslateY(200);
		
		ImageView logo = new ImageView(new Image("assets/logo.png")); 
		logo.setTranslateX(450);
		logo.setTranslateY(100);

		Button start_game_button = new Button("Start game");
		Button exit_button = new Button("Exit game");
		Button score_button = new Button("High Scores");


		start_game_button.setOnMouseClicked(new EventHandler<Event>() {
			
            @Override
			public void handle(Event event) {
            	
            	Model.player_one = new Player(player_one_field.getText());
            	Model.player_two = new Player(player_two_field.getText());
            	Model.state.current_player = Model.player_one;
            	
        		scene.setRoot(new Game_screen(scene, p_controller).getRoot());
        		dispose();
          	  }
            
                                                         });
		score_button.setOnMouseClicked(new EventHandler<Event>() {
			
            @Override
			public void handle(Event event) {
            	
            	 
        		scene.setRoot(new Score_screen(scene, p_controller).getRoot());
        		dispose();
          	  }
            
                                                         });
		exit_button.setOnMouseClicked(new EventHandler<Event>() {
			
            @Override
			public void handle(Event event) {
            	
            	 
            	Platform.exit();
                System.exit(0);
          	  }
            
                                                         });
		
		VBox vbox = new VBox();
		  
		vbox.setTranslateX(App.width/2-400);
		vbox.setTranslateY(300);
		vbox.setScaleX(2);
		vbox.setScaleY(2);
		
		
		
		


        vbox.getChildren().add(start_game_button);
        vbox.getChildren().add(score_button);
        vbox.getChildren().add(exit_button);
		
		
		
		root.getChildren().add(vbox);
		root.getChildren().add(welcome_text);
		root.getChildren().add(coin);
		root.getChildren().add(logo);
		root.getChildren().add(player_fields);

		

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
