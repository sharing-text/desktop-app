package io.github.zkhan93.sharingtext.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainStub {
	public static BufferedReader user_in;
	public static PrintWriter socket_out;
	static {
		user_in = new BufferedReader(new InputStreamReader(System.in));
	}

	public static void main(String args[]) {
		try {
			Socket socket = new Socket("127.0.0.1", 12345);
			System.out.println("connected with server");
			ServerReader serverReader = new ServerReader(socket);
			serverReader.start();
			String line;
			socket_out = new PrintWriter(socket.getOutputStream());
			while ((line = user_in.readLine()) != null) {
				socket_out.write(line);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static class ServerReader extends Thread {
		BufferedReader socket_in;

		@Override
		public void run() {
			String line;
			try {
				while ((line = socket_in.readLine()) != null) {
					System.out.print("Server:");
					System.out.println(line);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		public ServerReader(Socket socket) {
			try {
				socket_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
