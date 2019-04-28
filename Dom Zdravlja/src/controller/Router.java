package controller;

import model.*;
import view.*;

public class Router {
	public static Osoba trenutniKorisnik = null;

	public static void userRoute(String username, String password) {

		trenutniKorisnik = login(username, password);
		if (trenutniKorisnik != null) {
			switch (trenutniKorisnik.getUloga()) {
			case pacijent:
				new PacijentMain();
				break;
			case lekar:
				new LekarMain();
				break;
			case medicinskaSestra:
				new MedicinskaSestraMain();
				break;
			default:
				System.exit(1);
			}
		} else {
			new Login("Pogresna Sifra ili pwd");
		}
	}

	public static void userRoute() {

		if (trenutniKorisnik != null) {
			switch (trenutniKorisnik.getUloga()) {
			case pacijent:
				new PacijentMain();
				break;
			case lekar:
				new LekarMain();
				break;
			case medicinskaSestra:
				new MedicinskaSestraMain();
				break;
			default:
				System.exit(1);
			}
		} else {
			new Login("Molimo vas unesite username i sifru");
		}
	}

	public static Osoba login(String username, String password) {
		Osoba o = null;
		try {
			o = DataStore.pacijenti.entrySet().stream()
					.filter(e -> ((Osoba) e.getValue()).getUsername().equals(username) && ((Osoba) e.getValue()).getPassword().equals(password)).map(e -> ((Osoba) e.getValue()))
					.findFirst().get();
			
		} catch (Exception e) {
			
			try {
				o = DataStore.lekari.entrySet().stream()
						.filter(f -> ((Osoba) f.getValue()).getUsername().equals(username) && ((Osoba) f.getValue()).getPassword().equals(password)).map(f -> ((Osoba) f.getValue()))
						.findFirst().get();
				
			} catch (Exception f) {
				
				try {
					o = DataStore.medicinskeSestre.entrySet().stream()
							.filter(m -> ((Osoba) m.getValue()).getUsername().equals(username) && ((Osoba) m.getValue()).getPassword().equals(password)).map(m -> ((Osoba) m.getValue()))
							.findFirst().get();
					
				} catch (Exception g) {
					return null;
				}
			}
		}
		return o;
	}

}
