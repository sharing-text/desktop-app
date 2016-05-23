package io.github.zkhan93.sharingtext;

import io.github.zkhan93.sharingtext.models.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
	
	@Override
	public void init() throws Exception {
		super.init();
		
	}
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader;
		MainController mainController;
		try {
			fxmlLoader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			mainController = fxmlLoader.getController();
			mainController.addClient(new Client("Zeeshan Khan client"));
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
}
