package bai5_hibernate.MPS_AE;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MonitorConnection implements Runnable {
	private DataOutputStream outStream;
	private Socket socket;
	private final String name;

	MonitorConnection(String monitorHost, int monitorPort, String hostname,
			int port) {
		name = hostname + ":" + port;
		try {
			socket = new Socket(monitorHost, monitorPort);
			outStream = new DataOutputStream(socket.getOutputStream());

			Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
					this, 0, 1, TimeUnit.SECONDS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		write(name);
	}

	private void write(String response) {
		try {
			outStream.writeBytes(response + "\n");
		} catch (IOException e) {
			// monitor off
		}
	}
}
