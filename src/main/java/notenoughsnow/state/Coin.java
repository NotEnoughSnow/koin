package notenoughsnow.state;

 import javafx.scene.image.ImageView;


 /**
  * 
  * The coin state.
  * Holds logical and graphical data.
  * {@link #init_view()} must be called explicitly after object creation 
  * to avoid NullPointerException.
  * 
  * @author notenoughsnow
  *
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
       
    /**
     * Used to initialize the graphical part of the coin.
     */
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

	/**
	 * Flips the imageViews of the given coin to the opposite state.
	 */
	public void flip() {
		if(tails)
      	    img.setImage(Coin_view.heads_img);
  		  else
          	img.setImage(Coin_view.tails_img);		
	}
	
	
	/**
	 * Restores imageViews of given coin after un-selecting it.
	 */
	public void restore() {
		if(tails)
      	    img.setImage(Coin_view.tails_img);
  		  else
          	img.setImage(Coin_view.heads_img);		
	}
      

}
