package bai5_hibernate.MPS_AE;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.json.Json;
import javax.json.JsonObject;

public class App {

	protected final AppTest appTest;

	private ServerSocket socket;

	public App(String[] args) {
		this.appTest = new AppTest();
		listen(args);
	}

	public void listen(String[] args) {
		final String monitorHost = "localhost";
		final int monitorPort = 1339;

		final int port = Integer.parseInt(args[0]);

		try {
			final ServerSocket socket = new ServerSocket(port);
			System.out.println("MPS Instance listening on port: " + port);

			while (true) {
				Socket connection = socket.accept();
				System.out.println("Dispatcher connected from: " + connection.getRemoteSocketAddress().toString());

				new MonitorConnection(monitorHost, monitorPort, "localhost", port);
				new Thread(new DispatcherConnection(this, connection)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new App(args);
	}
}
