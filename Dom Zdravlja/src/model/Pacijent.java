package model;

import java.util.Scanner;
import java.util.StringJoiner;

public class Pacijent extends Osoba {
	private int izabraniLekarId;
	private int zdravstvenaKnjizicaId;
	public Pacijent(int id, String ime, String prezime, String jmbg, boolean pol, String adresa, String brojTelefona,
			String username, String password, TipKorisnika uloga, int izabraniLekar,
			int zdravstvenaKnjizica) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, username, password, uloga);
		this.izabraniLekarId = izabraniLekar;
		this.zdravstvenaKnjizicaId = zdravstvenaKnjizica;
	}
	public Pacijent() {
		this(-5,"","","",true,"","","","", TipKorisnika.pacijent, -5, -5);
		// TODO Auto-generated constructor stub
	}
	public int getIzabraniLekarId() {
		return izabraniLekarId;
	}
	public void setIzabraniLekarId(int izabraniLekar) {
		this.izabraniLekarId = izabraniLekar;
	}
	public int getZdravstvenaKnjizicaId() {
		return zdravstvenaKnjizicaId;
	}
	public void setZdravstvenaKnjizicaId(int zdravstvenaKnjizica) {
		this.zdravstvenaKnjizicaId = zdravstvenaKnjizica;
	}
	@Override
	public String toString() {
		return this.getIme()+" "+this.getPrezime();
	}
	@Override
	public Identifiable CreateFromString(String text) {
		
		var sc = new Scanner(text);
		var pacijent = new Pacijent();
		sc.useDelimiter("\\|");
		
		pacijent.setId(sc.nextInt());
		pacijent.setIme(sc.next());
		pacijent.setPrezime(sc.next());
		pacijent.setJmbg(sc.next());
		pacijent.setPol(sc.nextBoolean());
		pacijent.setAdresa(sc.next());
		pacijent.setBrojTelefona(sc.next());
		pacijent.setUsername(sc.next());
		pacijent.setPassword(sc.next());
		sc.nextInt();
		pacijent.setIzabraniLekarId(sc.nextInt());
		pacijent.setZdravstvenaKnjizicaId(sc.nextInt());
		
		sc.close();
		return pacijent;
	}
	@Override
	public String WriteToString() {
		var line = new StringJoiner("|");
		line.add(super.WriteToString()).add(this.getIzabraniLekarId()+"").add(this.getZdravstvenaKnjizicaId()+"");
		return line.toString();
	}
	
	

}
