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
import notenoughsnow.persistence.Game_result;
import notenoughsnow.persistence.Persistence;
import notenoughsnow.persistence.Session;
import notenoughsnow.util.JAXBHelper;

/**
 * The Controller responsible for Input/output.
 * Uses JAXB to read/write session data in the for of an XML file.
 * Stores and loads games played.
 * 
 * 
 * @author notenoughsnow
 *
 */
public class Persistence_controller {
 
	/**
	 * 
	 * Saves current {@link Session} to directory as {@code save.xml}.
	 * Stores number of moves, player names and winner name.
	 *  
	 */
	public void save() {
		
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		var data = new Persistence();
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

			} catch (JAXBException | FileNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Creates a new file to the current directory with name {@code save.xml}.
	 * Initializes a new empty instance of {@link Persistence}
	 */
	private static void create_empty_file() {
		  
		Logger.info("creating new file");
	    
	var data = new Persistence();
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
	
	
	/**
	 * 
	 * Retrieve {@link Session} from directory.
	 * Creates a new file if needed.
	 * @see #create_empty_file()
	 *  
	 */
	public void load() { 
		//ClassLoader classLoader = Controller.class.getClassLoader();
		
		try 
		//(InputStream xmlfile = classLoader.getResourceAsStream("save.xml"))
		{
			InputStream xmlfile = new FileInputStream("save.xml");

			Session.session = JAXBHelper.fromXML(Persistence.class, xmlfile);
			
			Logger.info("loaded session successfully");
		    
		   		     
		}
		catch(JAXBException e) {
			
		} catch (IOException | IllegalArgumentException e) {
			  Logger.info("save file not found");
			  create_empty_file();
			  Session.session = new Persistence();
			  Session.session.setGames(new ArrayList<Game_result>());
			  }
	}

}
