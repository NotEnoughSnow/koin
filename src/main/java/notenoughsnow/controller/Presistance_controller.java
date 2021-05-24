package notenoughsnow.controller;

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

public class Presistance_controller {
 
	
	public void save() {
		
	      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		    LocalDateTime now = LocalDateTime.now();  
		
		var data = new Presistance();

		var games = new ArrayList<Game_result>();
			var game = new Game_result();

				game.setDateTime(dtf.format(now));
				game.setMoves(Model.state.moves_played);

				var players = new ArrayList<String>();
					players.add(Model.player_one.name);
					players.add(Model.player_two.name);
				game.setPlayers(players);
	    
				game.setWinner(Model.state.current_player.name);
		
	      games.add(game);
	      
	      Session.session.getGames().add(game);
	      
	      data.setGames(Session.session.getGames());
	      
	      try {
			Logger.info("saving session");
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
	
	public void load() {
		
		   
		//ClassLoader classLoader = Controller.class.getClassLoader();
		
		try 
		//(InputStream xmlfile = classLoader.getResourceAsStream("save.xml"))
		{
			InputStream xmlfile = new FileInputStream("save.xml");

			Session.session = JAXBHelper.fromXML(Presistance.class, xmlfile);
			
			Logger.info("loaded session successfully");
		    
		   		     
		}
		catch(JAXBException e) {
			
		} catch (IOException | IllegalArgumentException e) {
			  Logger.info("save file not found");
			  create_empty_file();
			  Session.session = new Presistance();
			  Session.session.setGames(new ArrayList<Game_result>());
			  }
	}

}
