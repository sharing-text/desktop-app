package io.github.zkhan93.sharingtext.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import io.github.zkhan93.sharingtext.SocketReader;
import util.Util;

public class MainStub {
	public static BufferedReader user_in;
	public static PrintWriter socket_out;
	
	static {
		user_in = new BufferedReader(new InputStreamReader(System.in));
	}

	public static void main(String args[]) {
		while (true) {
			try {
				Socket socket = new Socket("127.0.0.1", 12345);
				Util.Log("connected with server");
				SocketReader serverReader = new SocketReader(socket);
				serverReader.start();
				String line;
				socket_out = new PrintWriter(socket.getOutputStream(),true);
				Util.Log("Write something");
				while (!socket_out.checkError() && (line = user_in.readLine()) != null) {
					socket_out.write(line);
					Util.Log("Wrote :"+line);
//					socket_out.flush();
				}
			} catch (Exception ex) {
				Util.Log("Connection closed");
				try {
					Util.Log("sleeping for 1 sec");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Util.Log("cannot sleep");
				}
			}
		}
	}
}
