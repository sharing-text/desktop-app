package io.github.zkhan93.sharingtext;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import io.github.zkhan93.sharingtext.models.Client;
import javafx.concurrent.Task;
import util.Util;

public class ServerTask extends Task<Client> {
	private ServerSocket serverSocket;
	private static final int PORT = 12345;

	public ServerTask() {
		try {
			serverSocket = new ServerSocket(ServerTask.PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Client call() throws Exception {
		Socket socket;
		try {
			while (true) {
				Util.Log("listening");
				socket = serverSocket.accept();
				Util.Log("got a connection");
				updateValue(new Client(socket.getInetAddress().getHostName(), socket));
			}
		} catch (Exception ex) {
			Util.Log("ServerTask dead");
		}
		return null;
	}
}
