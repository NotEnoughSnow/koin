package notenoughsnow.presistance;


import java.time.Year;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Game_result {
	
	   @XmlAttribute
	    private int id; 
	   
	   
	    private String dateTime;
	    private int moves;
	    
	    @XmlElementWrapper(name = "players")
	    @XmlElement(name = "player")
	    private List<String> players;
	    private String winner;


}
