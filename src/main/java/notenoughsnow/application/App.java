package notenoughsnow.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.tinylog.Logger;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import notenoughsnow.model.Model;
import notenoughsnow.presistance.Game_result;
import notenoughsnow.presistance.Presistance;
import notenoughsnow.presistance.Session;
import notenoughsnow.screen.Game_screen;
import notenoughsnow.screen.Menu_screen;


/**
 * Hello world!
 *
 */
public class App extends Application {
	
	public static final int  width = 1100;
	public static final int height = 800;
 
    
	@Override
	public void start(Stage stage) {
		
		  
		new Model();
		
		PresistanceController p_controller = new PresistanceController();

		stage.setWidth(width);
		stage.setHeight(height);
		stage.setResizable(false);
		// sets the current screen
		
		Group root = new Group();
		Scene scene = new Scene(root,Color.BEIGE);
		stage.setScene(scene);
		
		stage.getScene().setRoot(new Menu_screen(scene,p_controller).getRoot());
		

		stage.show();
		  
	}

 
	

	
	
	





}
