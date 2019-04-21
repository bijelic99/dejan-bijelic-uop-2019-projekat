package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringJoiner;

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

public class ZdravstvenaKnjizica extends Identifiable{
	private int idKorisnika;
	private LocalDate datumIsteka;
	private KategorijaOsiguranja kategorija;
	public ZdravstvenaKnjizica(int id, int idKorisnika, LocalDate datumIsteka, KategorijaOsiguranja kategorija) {
		super();
		this.id = id;
		this.idKorisnika = idKorisnika;
		this.datumIsteka = datumIsteka;
		this.kategorija = kategorija;
	}
	public ZdravstvenaKnjizica() {
		this(-5,-5, null, KategorijaOsiguranja.nema);
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
	public LocalDate getDatumIsteka() {
		return datumIsteka;
	}
	public void setDatumIsteka(LocalDate datumIsteka) {
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
	@Override
	public Identifiable CreateFromString(String text) {
		Scanner sc = new Scanner(text);
		sc.useDelimiter("\\|");
		var zdravstvenaKnjizica = new ZdravstvenaKnjizica();
		zdravstvenaKnjizica.setId(sc.nextInt());
		zdravstvenaKnjizica.setIdKorisnika(sc.nextInt());
		zdravstvenaKnjizica.setDatumIsteka(LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		switch(sc.nextInt()) {
		case 0: zdravstvenaKnjizica.setKategorija(KategorijaOsiguranja.I);break;
		case 1: zdravstvenaKnjizica.setKategorija(KategorijaOsiguranja.II);break;
		case 2: zdravstvenaKnjizica.setKategorija(KategorijaOsiguranja.III);break;
		case 3: zdravstvenaKnjizica.setKategorija(KategorijaOsiguranja.nema);break;
		}
		sc.close();
		
		return zdravstvenaKnjizica;
	}
	@Override
	public String WriteToString(Identifiable object) {
		var line = new StringJoiner("|");
		line.add(((ZdravstvenaKnjizica)object).getId()+"").add(((ZdravstvenaKnjizica)object).getIdKorisnika()+"");
		line.add(((ZdravstvenaKnjizica)object).getDatumIsteka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		line.add(((ZdravstvenaKnjizica)object).getKategorija().ordinal()+"");
		
		return line.toString();
	}
	
	
	
	
}
