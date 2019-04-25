package controller;

import localDataStore.DataStore;
import model.*;
import view.*;

public class Router {
	public static Osoba trenutniKorisnik = null;
	
	public static void userRoute(String username, String password) {
		
		trenutniKorisnik = login(username, password);
		if(trenutniKorisnik != null) {
			switch(trenutniKorisnik.getUloga()) {
			case pacijent: new PacijentMain();break;
			case lekar: new LekarMain();break;
			case medicinskaSestra: new MedicinskaSestraMain();break;
			default: System.exit(1);
			}
		}
		else {
			new Login("Pogresna Sifra ili pwd");
		}
	}
	
public static void userRoute() {
		
		if(trenutniKorisnik != null) {
			switch(trenutniKorisnik.getUloga()) {
			case pacijent: new PacijentMain();break;
			case lekar: new LekarMain();break;
			case medicinskaSestra: new MedicinskaSestraMain();break;
			default: System.exit(1);
			}
		}
		else {
			new Login("Molimo vas unesite username i sifru");
		}
	}

	public static Osoba login(String username, String password) {
		Osoba o = null;
		try {
		if((o = DataStore.pacijenti.entrySet().stream().filter(i->((Osoba)i.getValue()).getUsername().equals(password) && ((Osoba)i.getValue()).getPassword().equals(password)).map(i->((Osoba)i.getValue())).findFirst().get())!=null) {
			return o;
		}
		else if((o = DataStore.lekari.entrySet().stream().filter(i->((Osoba)i.getValue()).getUsername().equals(password) && ((Osoba)i.getValue()).getPassword().equals(password)).map(i->((Osoba)i.getValue())).findFirst().get())!=null) {
			return o;
		}
		else if((o = DataStore.medicinskeSestre.entrySet().stream().filter(i->((Osoba)i.getValue()).getUsername().equals(password) && ((Osoba)i.getValue()).getPassword().equals(password)).map(i->((Osoba)i.getValue())).findFirst().get())!=null) {
			return o;
		}
		}
		catch(Exception e) {
			return null;
		}
		return null; 
		
	}
	
}
