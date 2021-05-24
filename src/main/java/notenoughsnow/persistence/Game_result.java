package notenoughsnow.persistence;


import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import lombok.Data;

/**
 * 
 * Defines data for finished games.
 * Is stored in a list in the {@link Session} variable.
 * 
 * @author notenoughsnow
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Game_result {
	
	 
	    private String dateTime;
	    private int moves;
	    
	    @XmlElementWrapper(name = "players")
	    @XmlElement(name = "player")
	    private List<String> players;
	    private String winner;


}
