package bai5_hibernate.MPS_AE;

import com.rabbitmq.client.*;

import javax.json.Json;
import java.io.IOException;
import java.io.StringReader;
import java.util.Observable;

public class HapsaaListener extends Observable {
	private final static String QUEUE_NAME = "hapsar";
	private boolean run = true;

	public HapsaaListener() throws IOException {
		try {
			System.out.println("HapsaaListener is booting");
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();

			try {
				channel.queueDeclare(QUEUE_NAME, false, false, false, null);
				waitForMessages(channel);
			} finally {
				if (channel != null)
					channel.close();
				if (connection != null)
					connection.close();
			}
		} finally {
			System.out.println("HapsaaListener is shutting Down");
		}
	}

	private void waitForMessages(Channel channel) throws IOException {
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
}
