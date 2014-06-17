package bai5_hibernate.MPS_AE;

import bai5_hibernate.MPS_AE.hibernate.dao.AuftragDao;
import bai5_hibernate.MPS_AE.hibernate.dao.RechnungDao;
import bai5_hibernate.MPS_AE.hibernate.tables.Auftrag;
import bai5_hibernate.MPS_AE.hibernate.tables.Rechnung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

public class DispatcherConnection implements Runnable {
	private final Socket socket;
	private final App app;
	private BufferedReader inStream;

	private AuftragDao auftragDao;
	private RechnungDao rechnungDao;

	DispatcherConnection(App app, Socket socket) {
		this.app = app;
		this.socket = socket;

		auftragDao = new AuftragDao();
		rechnungDao = new RechnungDao();
	}

	public void run() {
		try {
			inStream = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			while (true) {
				String request = getRequest();
				if (request.equals("new_auftrag")) {
					Rechnung rechnung = new Rechnung();
					rechnung.setPaid(0);
					rechnung.setValue(100);
					rechnungDao.add(rechnung);

					Auftrag auftrag = new Auftrag();
					auftrag.setBeauftragtAm(new Date());
					auftrag.setIstAbgeschlossen(false);
					auftrag.setRechnung(rechnung);
					auftragDao.add(auftrag);

					System.out.println("Auftrag erstellt. Rechnungsnr.: " + rechnung.getNummer() + ", Betrag: " + rechnung.getValue());
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
