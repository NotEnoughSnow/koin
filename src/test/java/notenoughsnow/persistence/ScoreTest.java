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
import notenoughsnow.model.Player;
import notenoughsnow.persistence.Persistence;
import notenoughsnow.persistence.Session;
import notenoughsnow.screen.Menu_screen;
import notenoughsnow.util.JAXBHelper;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.jupiter.api.BeforeAll;

class ScoreTest {
 
	
	 @Test
	    void playerScore_test() {
		 
		 
		 Player p = new Player("John");
		 Player p2 = new Player("Rone");
		 
		 Player_score ps = new Player_score(p);
		 Player_score ps2 = new Player_score(p);
		 
		 ps2.score++;
		 
		 assertEquals(ps2.score,2);
		 assertNotEquals(p,p2);
		 assertEquals(ps.compareTo(ps2),1);
		 assertEquals(ps.toString(),"John( 1 )");
		 
		 assertEquals(ps,new Player_score(new Player("John")));

	    	
	    }


}