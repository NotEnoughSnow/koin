package notenoughsnow.presistance;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "data")
@Data
public class Presistance {
	
	
	@XmlElementWrapper(name = "games")
    @XmlElement(name = "game")
    private List<Game_result> games;
    
    
    
 

}
