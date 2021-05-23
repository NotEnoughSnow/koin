package notenoughsnow.application;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * 
 *
 */
public class App extends Application {
	
	public static final int  width = 1100;
	public static final int height = 800;
 
    
	@Override
	public void start(Stage stage) throws Exception {

		stage.setWidth(width);
		stage.setHeight(height);
		stage.setResizable(false);
		stage.show();
		  
		
	}
	
	

}
