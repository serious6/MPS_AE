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

	private final AppTest appTest;

	private final ExecutorService executorService = Executors
			.newFixedThreadPool(3);

	private final ScheduledExecutorService scheduledExecutor = Executors
			.newScheduledThreadPool(3);

	private boolean shutdown = false;
	private ServerSocket socket;

	public App() {
		this.appTest = new AppTest();
		listen();
	}

	public void listen() {
		try {
			socket = new ServerSocket(0);
			while (!shutdown) {
				// Incoming client requests
				System.out.println(String.format(
						"MPS Instance listening @ Port:%s",
						socket.getLocalPort()));
				final Socket connection = socket.accept();
				executorService.execute(new Runnable() {

					private BufferedReader inStream;

					public void run() {
						try {
							inStream = new BufferedReader(
									new InputStreamReader(connection
											.getInputStream()));
							JsonObject request = Json.createReader(
									new StringReader(inStream.readLine()))
									.readObject();
							String plainRequest = request.getString("request");
							if (plainRequest.contains("doSo")) {
								appTest.test1();
							} else if (plainRequest.contains("shutdown")) {
								shutdown = true;
								executorService.shutdown();
								scheduledExecutor.shutdown();
							} else {
								System.err.println(plainRequest);
							}
						} catch (IOException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				});
				scheduledExecutor.schedule(new Runnable() {

					private final DataOutputStream outStream = new DataOutputStream(
							connection.getOutputStream());

					public void run() {
						try {
							JsonObject theObject = Json
									.createObjectBuilder()
									.add("response", "add")
									.add("key",
											connection.getInetAddress()
													.getHostName())
									.add("data",
											Json.createObjectBuilder()
													.add("status", "on")
													.add("uptime", "100")
													.add("requests", "0")
													.add("systemLoad", "0"))
									.build();

							outStream.writeBytes(theObject.toString() + "\n");
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}, 5, TimeUnit.SECONDS);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new App();
	}
}
