package bai5_hibernate.MPS_AE;

import com.rabbitmq.client.*;

import javax.json.Json;
import java.io.IOException;
import java.io.StringReader;
import java.util.Observable;

public class HapsaaListener extends Observable implements Runnable {
	private final static String QUEUE_NAME = "hapsar";
	private boolean run = true;
	private Channel channel;

	public HapsaaListener() throws IOException {
		try {
			System.out.println("HapsaaListener is booting");
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection = factory.newConnection();
			channel = connection.createChannel();
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		} finally {
			System.out.println("HapsaaListener is shutting Down");
		}
	}

	private void waitForMessages() throws IOException {
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true, consumer);

		System.out.println("HapsaaListener is ready and waiting for Messages...");
		while (isRunning()) {
			QueueingConsumer.Delivery delivery = null;
			try {
				delivery = consumer.nextDelivery();
				String message = new String(delivery.getBody());
				System.out.println("[x] Received " + message);
				setChanged();
				notifyObservers(Json.createReader(new StringReader(message)).readObject());
			} catch (ShutdownSignalException e) {
				cancel();
				System.out.println(e);
			} catch (ConsumerCancelledException e) {
				cancel();
				System.out.println(e);
			} catch (InterruptedException e) {
				cancel();
				System.out.println(e);
			}
		}
	}

	public boolean isRunning() {
		return run;
	}

	public void cancel() {
		this.run = false;
	}

	@Override
	public void run() {
		try {
			waitForMessages();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
