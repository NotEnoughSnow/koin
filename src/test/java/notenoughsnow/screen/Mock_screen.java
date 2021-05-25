package notenoughsnow.screen;

import javafx.scene.Group;
import javafx.scene.text.Text;
import notenoughsnow.util.Screen;

public class Mock_screen implements Screen {
	
	private Group root;
	
	public Mock_screen() {
		 
		root = new Group();
		
		Text mock_text = new Text("");
		root.getChildren().add(mock_text);
	}
	

	@Override
	public Group getRoot() {
		return root;
	}

	@Override
	public void dispose() {
		root.getChildren().clear();
	}

}
