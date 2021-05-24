package notenoughsnow.persistence;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;


/**
 * 
 * Provides storage to data used in {@link notenoughsnow.controller.Persistence_controller}.
 * 
 * @author notenoughsnow
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "data")
@Data
public class Persistence {
	
	
	@XmlElementWrapper(name = "games")
    @XmlElement(name = "game")
    private List<Game_result> games;
    
    
    
 

}
