package io.github.zkhan93.sharingtext;

import java.io.IOException;
import java.net.Socket;

import io.github.zkhan93.sharingtext.models.Client;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.Util;

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

			Parent root = (Parent) fxmlLoader.load();
			Scene scene = new Scene(root);
			stage.setTitle("Sharing Text");
			stage.setScene(scene);
			stage.show();

			mainController = (MainController) fxmlLoader.getController();
//			startServerService();
			startClientService();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void startClientService() {
		ClientTask service = new ClientTask();
		service.valueProperty().addListener(new ChangeListener<Socket>() {
			public void changed(javafx.beans.value.ObservableValue<? extends Socket> observable, Socket oldValue,
					Socket newValue) {
				// newValue is me connected to a server
				addSocketReader(newValue);
				try {
					mainController.addClient(new Client("server", newValue));
				} catch (IOException e) {
					Util.Log(e.getLocalizedMessage());
				}
			};
		});
		Thread th = new Thread(service);
		th.setDaemon(true);
		th.start();
	}

	private void startServerService() {
		ServerTask service = new ServerTask();
		service.valueProperty().addListener(new ChangeListener<Client>() {
			public void changed(javafx.beans.value.ObservableValue<? extends Client> observable, Client oldValue,
					Client newValue) {
				addSocketReader(newValue.getSocket());
				mainController.addClient(newValue);
			};
		});
		Thread th = new Thread(service);
		th.setDaemon(true);
		th.start();
	}

	private void addSocketReader(Socket socket) {
		SocketReaderTask socketReader = new SocketReaderTask(socket);
		socketReader.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				mainController.addMessage(newValue);
				Util.Log("read: " + newValue);
			}
		});
		Thread t = new Thread(socketReader);
		t.setDaemon(true);
		t.start();
	}
}
