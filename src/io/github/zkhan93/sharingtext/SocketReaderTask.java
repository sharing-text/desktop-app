package io.github.zkhan93.sharingtext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javafx.concurrent.Task;
import util.Util;
/**
 * 
 * @author Zeeshan Khan
 *
 */
public class SocketReaderTask extends Task<String>{
	BufferedReader socket_in;

	public SocketReaderTask(Socket socket) {
		try {
			socket_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Util.Log("Socket reader ready");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected String call() throws Exception {
		String line;
		try {
			Util.Log("waiting for msg");
			while ((line = socket_in.readLine()) != null) {
				updateValue(line);
			}
		} catch (Exception ex) {
			Util.Log("a SocketReader is dead");
		}
		return null;
	}
}
