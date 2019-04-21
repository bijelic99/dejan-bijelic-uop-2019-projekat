package model;

import java.util.Scanner;
import java.util.StringJoiner;

import dao.DAOInterface;

public class Racun extends Identifiable{
	private int pregledId;
	private double cena;
	private boolean placen;

	public Racun(int id, int pregledId, double cena, boolean placen) {
		super();
		this.id = id;
		this.pregledId = pregledId;
		this.cena = cena;
		this.placen = placen;
	}

	private Racun() {
		this(-5, -5, -5, false);

	}

	public Racun(int pregledId) {
		this.pregledId = pregledId;
		this.cena = this.izracunajCenu();
		this.placen = false;

	}

	public Racun(Pregled pregled) {
		this.pregledId = pregled.getId();
		this.cena = this.izracunajCenu();
		this.placen = false;

	}

	public int getPregledId() {
		return pregledId;
	}

	public void setPregledId(int pregledId) {
		this.pregledId = pregledId;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public boolean isPlacen() {
		return placen;
	}

	public void setPlacen(boolean placen) {
		this.placen = placen;
	}

	private double izracunajCenu() {
		//nije idealno da ucitava preglede direktno iz fajla, treba doraditi
		//u buducnosti odraditi da ucitava iz neke liste
		
		cena = ((Pregled)DAOInterface.ucitaj(this.getPregledId(),(new Pregled())::CreateFromString, "pregledi.txt")).getPacijent().getZdravstvenaKnjizica().getKategorija().getCenaPregleda();
		return cena;
	}

	@Override
	public Identifiable CreateFromString(String text) {
		var Racun = new Racun();
		var sc = new Scanner(text);
		sc.useDelimiter("\\|");
		Racun.setId(sc.nextInt());
		Racun.setPregledId(sc.nextInt());
		Racun.setCena(sc.nextDouble());
		Racun.setPlacen(sc.nextBoolean());
		sc.close();
		return Racun;
	}

	@Override
	public String WriteToString(Identifiable object) {
		var line = new StringJoiner("|");
		line.add(((Racun)object).getId()+"").add(((Racun)object).getPregledId()+"").add(((Racun)object).getCena()+"").add(((Racun)object).isPlacen()+"");
		return line.toString();
	}
	
	
}
