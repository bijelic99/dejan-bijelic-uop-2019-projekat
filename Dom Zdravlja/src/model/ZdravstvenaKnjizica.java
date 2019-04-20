package model;

import java.util.Date;

enum KategorijaOsiguranja{
	I,II,III,nema;
	private String text;
	private double cenaPregleda;
	static {
		I.text="I(Prva)";
		I.cenaPregleda = 300;
		II.text="II(Druga)";
		II.cenaPregleda = 50;
		III.text="III(Treca)";
		III.cenaPregleda=0;
		nema.text="Nije Iskazana";
		nema.cenaPregleda=0;
	}
	public String getText() {
		return text;
	}
	public double getCenaPregleda() {
		return cenaPregleda;
	}
	
}

public class ZdravstvenaKnjizica {
	private int id;
	private int idKorisnika;
	private Date datumIsteka;
	private KategorijaOsiguranja kategorija;
	public ZdravstvenaKnjizica(int id, int idKorisnika, Date datumIsteka, KategorijaOsiguranja kategorija) {
		super();
		this.id = id;
		this.idKorisnika = idKorisnika;
		this.datumIsteka = datumIsteka;
		this.kategorija = kategorija;
	}
	public ZdravstvenaKnjizica() {
		this(-5,-5,new Date(), KategorijaOsiguranja.nema);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdKorisnika() {
		return idKorisnika;
	}
	public void setIdKorisnika(int idKorisnika) {
		this.idKorisnika = idKorisnika;
	}
	public Date getDatumIsteka() {
		return datumIsteka;
	}
	public void setDatumIsteka(Date datumIsteka) {
		this.datumIsteka = datumIsteka;
	}
	public KategorijaOsiguranja getKategorija() {
		return kategorija;
	}
	public void setKategorija(KategorijaOsiguranja kategorija) {
		this.kategorija = kategorija;
	}
	@Override
	public String toString() {
		return "ZdravstvenaKnjizica br.: "+this.getId()+", Datum Isteka: "+this.getDatumIsteka()+", Kategorija: "+this.getKategorija().getText();
	}
	
	
	
	
}
