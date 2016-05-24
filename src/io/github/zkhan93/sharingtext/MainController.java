package io.github.zkhan93.sharingtext;

import io.github.zkhan93.sharingtext.models.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class MainController {
	@FXML
	private Button btnSend;
	@FXML
	private Button btnClear;
	@FXML
	private TextArea textAreaSource;
	@FXML
	private ListView<Client> listViewClientList;

	private ObservableList<Client> clientList;
	private MainApplication mainApp;

	@FXML
	public void clearText(ActionEvent event) {
		if (textAreaSource != null)
			textAreaSource.clear();
		else
			log("textAreaSource is null, cannot clear!");
	}

	@FXML
	public void sendText(ActionEvent event) {
		
	}

	public void log(String msg) {
		if (msg != null)
			System.out.println(msg);
	}

	public boolean addClient(Client client) {
		return clientList.add(client);
	}

	@FXML
	public void initialize() {
		clientList = FXCollections.observableArrayList();
		listViewClientList.setItems(clientList);
	}

	public void setMainApp(MainApplication mainApp) {
		this.mainApp = mainApp;
	}
}
