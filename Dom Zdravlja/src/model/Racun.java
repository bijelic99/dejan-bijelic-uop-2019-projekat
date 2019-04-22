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


	public Racun() {
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
		var pregled = new Pregled();
		pregled = ((Pregled)DAOInterface.ucitaj(this.getPregledId(),(pregled)::CreateFromString, DAOInterface.pregledPath));
		var pacijent = new Pacijent();
		pacijent = ((Pacijent)DAOInterface.ucitaj(pregled.getPacijentId(), pacijent::CreateFromString, DAOInterface.pacijentPath));
		var knjizica = new ZdravstvenaKnjizica();
		knjizica = ((ZdravstvenaKnjizica)DAOInterface.ucitaj(pacijent.getZdravstvenaKnjizicaId(), knjizica::CreateFromString, DAOInterface.zdravstvenaKnjizicaPath));
		cena = knjizica.getKategorija().getCenaPregleda();
		return cena;
	}

	@Override
	public Identifiable CreateFromString(String text) {
		
		var sc = new Scanner(text);
		var racun = new Racun();
		sc.useDelimiter("\\|");
		racun.setId(sc.nextInt());
		racun.setPregledId(sc.nextInt());
		racun.setCena(sc.nextDouble());
		racun.setPlacen(sc.nextBoolean());
		sc.close();
		return racun;
	}

	@Override
	public String WriteToString() {
		var line = new StringJoiner("|");
		line.add(this.getId()+"").add(this.getPregledId()+"").add(this.getCena()+"").add(this.isPlacen()+"");
		return line.toString();
	}
	
	
}
