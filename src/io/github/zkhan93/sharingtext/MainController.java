package io.github.zkhan93.sharingtext;

import io.github.zkhan93.sharingtext.models.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;

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
	public void clearText(ActionEvent event) {
		if (textAreaSource != null)
			textAreaSource.clear();
		else
			log("textAreaSource is null, cannot clear!");
	}

	@FXML
	public void sendText(ActionEvent event) {
		System.out.println("msg send.");
	}

	public void log(String msg) {
		if (msg != null)
			System.out.println(msg);
	}

	public boolean addClient(Client client) {
		
		
		return false;
		
	}

	@FXML
	public void initialize() {
		ObservableList<Client> listdata = FXCollections.<Client>emptyObservableList();
		listViewClientList.setItems(listdata);
		listViewClientList.setCellFactory(new Callback<ListView<Client>, ListCell<Client>>() {

			@Override
			public ListCell<Client> call(ListView<Client> param) {
				ListCell<Client> cell = new ListCell<Client>() {
					@Override
					protected void updateItem(Client item, boolean empty) {
						super.updateItem(item, empty);
						setText(item.toString());
					}
				};
				return cell;
			}
		});
	}
}
