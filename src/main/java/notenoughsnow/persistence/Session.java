package notenoughsnow.persistence;

/**
 * 
 * Wrapper class for the Persistence instance in the application.
 * Provides global access to the session but is only used if necessary.
 * 
 * @see notenoughsnow.controller.Persistence_controller
 * @see Persistence
 * 
 * @author notenoughsnow
 *
 */
public class Session {
	
	/**
	 * Session variable to hold loaded and current game data.
	 */
    public static Persistence session;
    


}
