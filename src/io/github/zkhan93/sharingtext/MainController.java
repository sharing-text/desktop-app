package io.github.zkhan93.sharingtext;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainController {
	@FXML
	private Button btnSend;
	@FXML
	private Button btnClear;
	@FXML
	private TextArea textAreaSource;

	@FXML
	public void clearText(ActionEvent event) {
		if(textAreaSource!=null)
			textAreaSource.clear();
		else
			log("textAreaSource is null, cannot clear!");
	}

	public void log(String msg) {
		if (msg != null)
			System.out.println(msg);
	}
}
