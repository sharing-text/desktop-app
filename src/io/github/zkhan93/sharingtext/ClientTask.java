package io.github.zkhan93.sharingtext;

import java.net.Socket;

import javafx.concurrent.Task;
import util.Util;

public class ClientTask extends Task<Socket> {
	private static final int PORT = 12345;

	@Override
	protected Socket call() throws Exception {
		Socket socket = null;
		try {
			Util.Log("listening");
			socket = new Socket("127.0.0.1", PORT);
			Util.Log("connected with server");
		} catch (Exception ex) {
			Util.Log("ClientTask dead");
			socket = null;
		}
		return socket;
	}
}
