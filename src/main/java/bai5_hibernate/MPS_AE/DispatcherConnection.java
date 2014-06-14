package bai5_hibernate.MPS_AE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DispatcherConnection implements Runnable {
	private final Socket socket;
	private final App app;
	private BufferedReader inStream;

	DispatcherConnection(App app, Socket socket) {
		this.app = app;
		this.socket = socket;
	}

	public void run() {
		try {
			inStream = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			while (true) {
				String request = getRequest();
				if (request.equals("new_auftrag")) {
					app.appTest.test1();
				}
			}
		} catch (IOException e) {
			// dispatcher off
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getRequest() throws IOException {
		String request = inStream.readLine();
		if (request == null) {
			throw new IOException();
		}
		return request;
	}
}
