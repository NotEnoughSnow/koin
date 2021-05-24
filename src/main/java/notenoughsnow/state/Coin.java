package notenoughsnow.state;

 import javafx.scene.image.ImageView;

 /**
	 * Updates the graphical part of the coin flip.
	 * 
	 * @param coin the selected coin
	 */
public class Coin implements Comparable<Coin>{

       public ImageView img;

       public boolean tails;
       public boolean selected;
       
       public int position;

	
       public Coin(int i) {
  
    	  position = i;
 	      tails = false;
 	      selected = false;
       }
       
       public void init_view() {
    	   img = new ImageView(Coin_view.heads_img);
       }
        
	@Override
	public int compareTo(Coin o) {
		
		if(this.position>o.position)
			return 1;
		if(this.position<o.position)
			return -1;
 		return 0;
	}

	
	public void flip() {
		if(tails)
      	    img.setImage(Coin_view.heads_img);
  		  else
          	img.setImage(Coin_view.tails_img);		
	}
       
	public void restore() {
		if(tails)
      	    img.setImage(Coin_view.tails_img);
  		  else
          	img.setImage(Coin_view.heads_img);		
	}
      

}
