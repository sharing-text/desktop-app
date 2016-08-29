package io.github.zkhan93.sharingtext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import util.Util;

public class SocketReader extends Thread {
	BufferedReader socket_in;

	@Override
	public void run() {
		String line;
		try {
			Util.Log("waiting for msg");
			while ((line = socket_in.readLine()) != null) {
				System.out.print("read: ");
				System.out.println(line);
			}
		} catch (Exception ex) {
			Util.Log("a SocketReader is dead");
		}
	}

	public SocketReader(Socket socket) {
		try {
			socket_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Util.Log("Socket reader ready");
	}

}
