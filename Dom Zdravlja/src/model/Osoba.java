package model;

import java.util.StringJoiner;

public abstract class Osoba extends Identifiable{
	
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected boolean pol;
	protected String adresa;
	protected String brojTelefona;
	protected String username;
	protected String password;
	protected TipKorisnika uloga;
	
	public Osoba(int id, String ime, String prezime, String jmbg, boolean pol, String adresa, String brojTelefona,
			String username, String password, TipKorisnika uloga) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.username = username;
		this.password = password;
		this.uloga = uloga;
	}
	
	public Osoba() {
		this(-5,"","","",false,"","","","",TipKorisnika.pacijent);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public boolean isPol() {
		return pol;
	}

	public void setPol(boolean pol) {
		this.pol = pol;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipKorisnika getUloga() {
		return uloga;
	}

	 
	@Override
	public String WriteToString() {
		var line = new StringJoiner("|");
		line.add(this.getId()+"").add(this.getIme()).add(this.getPrezime());
		line.add(this.getJmbg()).add(this.isPol()+"");
		line.add(this.getAdresa()).add(this.getBrojTelefona());
		line.add(this.getUsername()).add(this.getPassword()).add(this.getUloga().ordinal()+"");
		
		return line.toString();
	}
	
	
	
	
}
