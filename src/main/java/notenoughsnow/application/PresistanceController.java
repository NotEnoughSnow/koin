package notenoughsnow.application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.tinylog.Logger;

import jakarta.xml.bind.JAXBException;
import notenoughsnow.model.Model;
import notenoughsnow.model.Player;
import notenoughsnow.presistance.Game_result;
import notenoughsnow.presistance.Presistance;
import notenoughsnow.presistance.Session;
import notenoughsnow.util.JAXBHelper;

public class PresistanceController {
	
	public PresistanceController() {
		load();
	}
	
	public void save(Player winner) {
		
	      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		    LocalDateTime now = LocalDateTime.now();  
		
		var data = new Presistance();
	    

		var games = new ArrayList<Game_result>();
			var game = new Game_result(); 
				game.setId(293484);

				game.setDateTime(dtf.format(now));
				game.setMoves(5);

				var players = new ArrayList<String>();
					players.add(Model.player_one.name);
					players.add(Model.player_two.name);
				game.setPlayers(players);
	    
				game.setWinner(winner.name);
		
	      games.add(game);
	      
	      Session.loaded_session.getGames().add(game);
	      data.setGames(Session.loaded_session.getGames());
	      
	      	
	      
	      try {
	        JAXBHelper.toXML(data, System.out);
	        JAXBHelper.toXML(data, new FileOutputStream("save.xml"));
	       //JAXBHelper.toXML(data, new FileOutputStream("src/main/resource/save.xml"));

			} catch (FileNotFoundException | JAXBException e) {
				e.printStackTrace();
			}
	}
	
	private static void create_empty_file() {
		  
		Logger.info("creating new file");
	    
	
	var data = new Presistance();
    

	var games = new ArrayList<Game_result>();
	
      
      data.setGames(games);
       
      
      try {
        JAXBHelper.toXML(data, System.out);
        JAXBHelper.toXML(data, new FileOutputStream("save.xml"));
        //AXBHelper.toXML(data, new FileOutputStream("src/main/resources/save.xml"));

		} catch (FileNotFoundException | JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static void load() {
		
		   
		//ClassLoader classLoader = Controller.class.getClassLoader();
		
		try 
		//(InputStream xmlfile = classLoader.getResourceAsStream("save.xml"))
		{
			InputStream xmlfile = new FileInputStream("save.xml");

			Session.loaded_session = JAXBHelper.fromXML(Presistance.class, xmlfile);
			
			Logger.info(Session.loaded_session);
		    
		   		     
		}
		catch(JAXBException e) {
			
		} catch (IOException | IllegalArgumentException e) {
			  Logger.info("save file not found");
			  create_empty_file();
			  Session.loaded_session = new Presistance();
			  Session.loaded_session.setGames(new ArrayList<Game_result>());
			  }
	}

}
