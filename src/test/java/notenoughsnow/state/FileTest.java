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

import org.junit.jupiter.api.BeforeAll;

class FileTest {
 
	
	 @Test
	    void excpetion_test() {
		 
	    	
	    	assertThrows(JAXBException.class, () ->JAXBHelper.fromXML(getClass(), new FileInputStream("save.xml")));
	    	assertThrows(IOException.class, () ->JAXBHelper.fromXML(Persistence.class, new FileInputStream("sample.xml")));


		    Persistence_controller p = new Persistence_controller();
	    	p.load();
	    	
	    	assertNotNull(Session.session);
	    	
	    }


}