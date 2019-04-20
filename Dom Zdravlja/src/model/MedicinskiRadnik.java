package model;

public abstract class MedicinskiRadnik extends Osoba {
	protected double plata;
	protected Sluzba sluzba;
	protected DomZdravlja domZdravlja;
	
	public MedicinskiRadnik(int id, String ime, String prezime, String jmbg, boolean pol, String adresa,
			String brojTelefona, String username, String password, TipKorisnika uloga, double plata, Sluzba sluzba,
			DomZdravlja domZdravlja) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, username, password, uloga);
		this.plata = plata;
		this.sluzba = sluzba;
		this.domZdravlja = domZdravlja;
	}

	public MedicinskiRadnik() {
		super();
		this.plata = -5.00;
		this.sluzba = Sluzba.neodredjena;
		this.domZdravlja = null;
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

	public DomZdravlja getDomZdravlja() {
		return domZdravlja;
	}

	public void setDomZdravlja(DomZdravlja domZdravlja) {
		this.domZdravlja = domZdravlja;
	}
	
	

}
