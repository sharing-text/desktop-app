package io.github.zkhan93.sharingtext;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import io.github.zkhan93.sharingtext.models.Client;
import javafx.concurrent.Task;

public class ClientConnectionTask extends Task<Client> {
	private ServerSocket serverSocket;
	private static final int PORT = 12345;
	private MainController mainController;

	public ClientConnectionTask(MainController mainController) {
		this.mainController = mainController;
		try {
			serverSocket = new ServerSocket(ClientConnectionTask.PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Client call() throws Exception {
		while (true) {
			Socket socket = serverSocket.accept();
			mainController.addClient(new Client(socket.getInetAddress().getHostName(), socket));
		}
	}

}
