package notenoughsnow.persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import jakarta.xml.bind.JAXBException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import notenoughsnow.application.App;
import notenoughsnow.controller.Coin_controller;
import notenoughsnow.controller.Persistence_controller;
import notenoughsnow.controller.Turn_controller;
import notenoughsnow.model.Model;
import notenoughsnow.persistence.Persistence;
import notenoughsnow.persistence.Session;
import notenoughsnow.screen.Menu_screen;
import notenoughsnow.util.JAXBHelper;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;

class ResultTest {
 
	
	 @Test
	    void result_test() {
		 
		 Game_result r = new Game_result();
		 Game_result r2 = new Game_result();
		 
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			
		 ArrayList<String> players = new ArrayList<String>(); 
		 players.add("John");
		 players.add("Ron");

		 r.setMoves(5);
		 r.setPlayers(players);
		 r.setWinner("John");
		 r.setDateTime(dtf.format(now));
		 
		 r2.setMoves(5);
		 r2.setPlayers(players);
		 r2.setWinner("John");
		 r2.setDateTime(dtf.format(now));

		 
		 
		 assertEquals(r.getMoves(), 5);
		 assertEquals(r.getWinner(), "John");
		 assertEquals(r.getPlayers(), players);
		 assertEquals(r.getDateTime(), dtf.format(now));
		 assertEquals(r, r2);
		 
		 
		 Persistence per = new Persistence();
		 ArrayList<Game_result> gr = new ArrayList<Game_result>(); 
		 per.setGames(gr);
		 gr.add(r);
		 gr.add(r2);
		 
		 assertEquals(per.getGames().size(), 2);
		  

	    	
	    }


}