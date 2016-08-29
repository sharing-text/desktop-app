package io.github.zkhan93.sharingtext.models;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	private String name;
	private Socket socket;

	private PrintWriter writer;
//	private BufferedReader reader;

	public Client(String name) {
		this.name = name;
	}

	public Client(String name, Socket socket) throws IOException {
		this.name = name;
		this.socket = socket;
		writer = new PrintWriter(socket.getOutputStream(), true);
//		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Client() {
		name = "nothig";
	}

	public void sendText(String msg) {
		if (writer != null && !msg.isEmpty())
			writer.println(msg);
	}

	/*public String readText() throws IOException {
		String msg = null;
		if (reader != null) {
			msg = reader.readLine();
		}
		return msg;
	}*/
	
	
	@Override
	public String toString() {
		return name;
	}
}
