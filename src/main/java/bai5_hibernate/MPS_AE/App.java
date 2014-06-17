package bai5_hibernate.MPS_AE;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import javax.json.JsonObject;

import bai5_hibernate.MPS_AE.hibernate.dao.RechnungDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Rechnung;

public class App implements Observer {

	protected final HapsaaListener hapsaaListener;
	protected final TransportAdapter transportAdapter;

	private ServerSocket socket;

	private RechnungDao rechnungDao;

	public App(String[] args) throws IOException {
		transportAdapter = new TransportAdapter();

		hapsaaListener = new HapsaaListener();
		hapsaaListener.addObserver(this);
		new Thread(hapsaaListener).start();

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
				System.out.println("Dispatcher connected from: "
						+ connection.getRemoteSocketAddress().toString());

				new MonitorConnection(monitorHost, monitorPort, "localhost",
						port);
				new Thread(new DispatcherConnection(this, connection)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new App(args);
	}

	public void update(Observable o, Object arg) {
		JsonObject message = (JsonObject) arg;
		int id = message.getInt("id");
		double value = message.getJsonNumber("value").doubleValue();

		try {
			Rechnung rechnung = rechnungDao.findById(id);
			rechnung.setPaid(rechnung.getPaid() + value);
			if (rechnung.getPaid() > rechnung.getValue()) {
				transportAdapter.ship(id);
			}
		} catch (Exception e) {
			System.out.println("id: " + id + " not found");
		}
	}
}
