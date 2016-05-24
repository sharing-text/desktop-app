package io.github.zkhan93.sharingtext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
	MainController mainController;
	@Override
	public void init() throws Exception {
		super.init();
		
	}
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader;
		
		try {
			fxmlLoader = new FXMLLoader(getClass().getResource("views/MainView.fxml"));
			
			mainController = fxmlLoader.getController();
			//mainController.setMainApp(this);
			
			startClientConnectionService();
			
			Parent root = (Parent) fxmlLoader.load();
			Scene scene = new Scene(root);
			stage.setTitle("Sharing Text");
			stage.setScene(scene);
			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	private void startClientConnectionService(){
		ClientConnectionTask service=new ClientConnectionTask(mainController);
		service.valueProperty();
		
	}
}
