package io.github.zkhan93.sharingtext;

import io.github.zkhan93.sharingtext.models.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import util.Util;

public class MainController {
	@FXML
	private Button btnSend;
	@FXML
	private Button btnClear;
	@FXML
	private TextArea textAreaSource;
	@FXML
	private ListView<Client> listViewClientList;
	@FXML
	private ListView<String> listViewMessages;
	@FXML
	private Label ip;
	@FXML
	private ImageView barCode;

	private ObservableList<Client> clientList;
	private ObservableList<String> messagesList;

	@FXML
	public void clearText(ActionEvent event) {
		if (textAreaSource != null)
			textAreaSource.clear();
		else
			log("textAreaSource is null, cannot clear!");
	}

	@FXML
	public void sendText(ActionEvent event) {
		clientList.forEach(client -> client.sendText(textAreaSource.getText()));
		Util.Log("write: "+textAreaSource.getText());
		textAreaSource.clear();
	}

	public void log(String msg) {
		if (msg != null)
			System.out.println(msg);
	}

	public boolean addClient(Client client) {
		Util.Log("adding client: " + client.toString());
		return clientList.add(client);
	}

	public void addMessage(String msg) {
		if (msg != null) {
			Util.Log("adding msg: " + msg);
			messagesList.add(msg);
		}
	}

	@FXML
	public void initialize() {
		clientList = FXCollections.observableArrayList();
		listViewClientList.setItems(clientList);
		messagesList = FXCollections.observableArrayList();
		listViewMessages.setItems(messagesList);
	}
}
