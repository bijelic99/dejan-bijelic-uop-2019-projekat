package model;

import java.util.StringJoiner;

public abstract class MedicinskiRadnik extends Osoba {
	protected double plata;
	protected Sluzba sluzba;
	protected int domZdravljaId;
	
	public MedicinskiRadnik(int id, String ime, String prezime, String jmbg, boolean pol, String adresa,
			String brojTelefona, String username, String password, TipKorisnika uloga, double plata, Sluzba sluzba,
			int domZdravlja) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, username, password, uloga);
		this.plata = plata;
		this.sluzba = sluzba;
		this.domZdravljaId = domZdravlja;
	}

	public MedicinskiRadnik() {
		super();
		this.plata = -5.00;
		this.sluzba = Sluzba.neodredjena;
		this.domZdravljaId = -5;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public Sluzba getSluzba() {
		return sluzba;
	}

	public void setSluzba(Sluzba sluzba) {
		this.sluzba = sluzba;
	}

	public int getDomZdravljaId() {
		return domZdravljaId;
	}

	public void setDomZdravljaId(int domZdravlja) {
		this.domZdravljaId = domZdravlja;
	}
	
	@Override
	public String WriteToString() {
		var line = new StringJoiner("|");
		line.add(super.WriteToString()).add(this.getPlata()+"").add(this.getSluzba().ordinal()+"").add(this.getDomZdravljaId()+"");
		return line.toString();
	}

}
