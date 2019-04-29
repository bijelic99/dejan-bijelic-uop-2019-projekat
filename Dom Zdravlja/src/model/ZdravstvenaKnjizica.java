package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringJoiner;


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
		return "ZdravstvenaKnjizica br.: "+this.getId()+", Datum Isteka: "+this.getDatumIsteka()+", Kategorija: "+this.getKategorija().toString();
	}
	
	public static Identifiable CreateFromString(String text) {
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
	public String WriteToString() {
		var line = new StringJoiner("|");
		line.add(this.getId()+"").add(this.getIdKorisnika()+"");
		line.add(this.getDatumIsteka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		line.add(this.getKategorija().ordinal()+"");
		
		return line.toString();
	}
	
	
	
	
}
