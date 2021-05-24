package notenoughsnow.state;

 import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coin implements Comparable<Coin>{

       public ImageView img;

       public boolean tails;
       public boolean selected;
       
       public int position;

	
       public Coin(int i) {
 
    	   img = new ImageView(Coin_view.heads_img); 

    	  position = i;
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
