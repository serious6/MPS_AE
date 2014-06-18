package bai5_hibernate.MPS_AE;

import java.io.IOException;
import java.io.StringReader;
import java.util.Observable;

import javax.json.Json;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

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

		System.out
				.println("HapsaaListener is ready and waiting for Messages...");
		while (isRunning()) {
			QueueingConsumer.Delivery delivery = null;
			try {
				delivery = consumer.nextDelivery();
				String message = new String(delivery.getBody());
				System.out.println("[x] Received " + message);
				setChanged();
				notifyObservers(Json.createReader(new StringReader(message))
						.readObject());
			} catch (ShutdownSignalException e) {
				cancel();
				System.out.println(e);
			} catch (ConsumerCancelledException e) {
				cancel();
				System.out.println(e);
			} catch (InterruptedException e) {
				cancel();
				System.out.println(e);
			} catch (Exception e) {
				cancel();
				e.printStackTrace();
			}
		}
	}

	public boolean isRunning() {
		return run;
	}

	public void cancel() {
		this.run = false;
	}

	public void run() {
		try {
			waitForMessages();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
