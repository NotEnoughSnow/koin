package notenoughsnow.screen;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import notenoughsnow.application.App;
import notenoughsnow.controller.Coin_controller;
import notenoughsnow.controller.Presistance_controller;
import notenoughsnow.controller.Turn_controller;
import notenoughsnow.model.Model;
import notenoughsnow.state.Coin;
import notenoughsnow.util.Screen;

public class Game_screen implements Screen {
	
	private Group root;
	
	public Game_screen(Scene scene,Presistance_controller p_controller) {
		

		root = new Group();
		
		Text player_turn_text = new Text("");
		
		player_turn_text.setX(App.width/2-150);
		player_turn_text.setY(100);
		player_turn_text.setStyle("-fx-font: 25 arial;");

		
		Button next_turn_button = new Button("end turn");

		next_turn_button.setPrefWidth(150);
		next_turn_button.setPrefHeight(70);
		
		next_turn_button.setLayoutX(App.width/2-next_turn_button.getPrefWidth()/2);
		next_turn_button.setLayoutY(550);
		
		
		   Turn_controller t_controller = new Turn_controller(player_turn_text);
		   Coin_controller c_controller = new Coin_controller();
		   
		   
		next_turn_button.setDisable(true);
		next_turn_button.setOnMouseClicked(new EventHandler<Event>() {
			
			 

            @Override
			public void handle(Event event) {
           
            	
            	if(t_controller.end_turn(scene,player_turn_text)) {
            		p_controller.save(Model.state.current_player);
                    scene.setRoot(new End_screen(scene, p_controller).getRoot());
            		dispose();

            	}
            		  
          	  }
            
                                                         });
		
		int i;
	for(i = 0;i<10;i++) {
			
			Coin c = new Coin(i);
			
			c.img.setOnMouseClicked(new EventHandler<Event>() {
				
	              @Override
				public void handle(Event event) {
	            
	            	  c_controller.change_selected(c);
	            	 
	            	  next_turn_button.setDisable(!t_controller.check_validity());

	              								} 
	                                                           });
			
			c_controller.add_coin(c);
		}
	
	
	
	
	HBox hbox = new HBox();
    hbox.setPadding(new Insets(15, 64, 15, 64));
    
    //Arbitrary
    hbox.setTranslateY(340);
    
    
    // window_width = pad_right + pad_left + num_coins * coin_width + (num_coins-1)*spacing
    float spacing = (-64*2 - 72*i + 1100)/(i-1); 
    hbox.setSpacing(spacing);
    
    for(Coin c : Model.state.coins)
    hbox.getChildren().add(c.img);
	
	
		 // root.getChildren().add(c.img);
		root.getChildren().add(next_turn_button);
		root.getChildren().add(player_turn_text);
		root.getChildren().add(hbox);
		
	} 

	@Override
	public Group getRoot() {
		return root;
	}

	@Override
	public void dispose() {
    	root.getChildren().clear();
    	Model.state.coins.clear();
	}
 
	
	
	

}
