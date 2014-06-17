package bai5_hibernate.MPS_AE;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class TransportAdapter implements Transport {

	public TransportAdapter() {

	}

	public void ship(int id) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(
					"http://localhost:8080/ship/" + id).openConnection();
			connection.setRequestMethod("PUT");
			int responseCode = connection.getResponseCode();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
