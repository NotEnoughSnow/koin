package notenoughsnow.util;

import javafx.scene.Group;

/**
 * 
 * Provides abstract methods for Screens.
 * 
 * @author notenoughsnow
 *
 */
public interface Screen {
	
	/**
	 *Requests the root of a created Screen to be used in application scene.
	 *provides a way to switch screens.
	 *
	 * @return The root for the current Screen.
	 */
	Group getRoot();
	
	/**
	 * 
	 * Disposes of unused components in the Screen.
	 * Should be called after switching screens.
	 * 
	 */
	void dispose();
	

}
