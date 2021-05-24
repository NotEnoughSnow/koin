package notenoughsnow.state;

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
import notenoughsnow.controller.Presistance_controller;
import notenoughsnow.controller.Turn_controller;
import notenoughsnow.model.Model;
import notenoughsnow.presistance.Presistance;
import notenoughsnow.presistance.Session;
import notenoughsnow.screen.Menu_screen;
import notenoughsnow.util.JAXBHelper;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.jupiter.api.BeforeAll;

class FileTest {
 
	
	 @Test
	    void excpetion_test() {
		 
	    	
	    	assertThrows(JAXBException.class, () ->JAXBHelper.fromXML(getClass(), new FileInputStream("save.xml")));
	    	assertThrows(IOException.class, () ->JAXBHelper.fromXML(Presistance.class, new FileInputStream("sample.xml")));


		    Presistance_controller p = new Presistance_controller();
	    	p.load();
	    	
	    	assertNotNull(Session.loaded_session);
	    	
	    }


}