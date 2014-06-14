package bai5_hibernate.MPS_AE;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {
	private final DataOutputStream outStream;
	private final Socket socket;

	Client(Socket socket, DataOutputStream outStream) {
		this.socket = socket;
		this.outStream = outStream;
	}

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 1337);
		DataOutputStream outStream = new DataOutputStream(
				socket.getOutputStream());

		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
				new Client(socket, outStream), 0, 1, TimeUnit.SECONDS);
	}

	public void run() {
		try {
			outStream.writeBytes("new_auftrag\n");
		} catch (IOException e) {
			// dispatcher off
		}
	}
}
