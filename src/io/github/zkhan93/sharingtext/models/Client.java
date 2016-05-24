package io.github.zkhan93.sharingtext.models;

import java.net.Socket;

public class Client {
	private String name;
	private Socket socket;

	public Client(String name) {
		this.name = name;
	}

	public Client(String name, Socket socket) {
		this.name = name;
		this.socket = socket;
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

	@Override
	public String toString() {
		return name;
	}
}
