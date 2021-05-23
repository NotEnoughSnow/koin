package notenoughsnow.state;

 import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coin implements Comparable<Coin>{
	
       public Image heads_img ;
       public Image tails_img ;
       public Image selected_img ;
       
       public ImageView img;

       public boolean tails;
       public boolean selected;
       
       public int position;

	
       public Coin(int i) {
    	  heads_img =  new Image("assets/coin1.png");
    	  tails_img =  new Image("assets/coin2.png");
    	  selected_img =  new Image("assets/coin3.png");

    	    img = new ImageView(heads_img); 

    	  
 	      tails = false;
 	      selected = false;
       }
 

	@Override
	public int compareTo(Coin o) {
		
		if(this.position>o.position)
			return 1;
		if(this.position<o.position)
			return -1;
 		return 0;
	}
       
      

}
