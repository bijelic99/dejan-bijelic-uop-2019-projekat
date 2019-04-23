package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringJoiner;

enum StatusPregleda{
	zatrazen,
	zakazan,
	otkazan,
	zavrsen;
	
	private String text;
	static {
		zatrazen.text="zatrazen";
		zakazan.text="zakazan";
		otkazan.text="otkazan";
		zavrsen.text="zavrsen";
	}
	public String getText() {
		return text;
	}
	
}

public class Pregled extends Identifiable{
	private int pacijentId;
	private int lekarId;
	private LocalDateTime vremePocetka;
	private LocalDateTime vremeKraja;
	private int sobaId;
	private String opis;
	private StatusPregleda status;
	public Pregled(int id, int pacijent, int lekar, LocalDateTime vremePocetka, LocalDateTime vremeKraja,
			int soba, String opis, StatusPregleda status) {
		super();
		this.id = id;
		this.pacijentId = pacijent;
		this.lekarId = lekar;
		this.vremePocetka = vremePocetka;
		this.vremeKraja = vremeKraja;
		this.sobaId = soba;
		this.opis = opis;
		this.status = status;
	}
	public Pregled(int id, int pacijent, int lekar, LocalDateTime vremePocetka,
			int soba, String opis, StatusPregleda status) {
		super();
		this.id = id;
		this.pacijentId = pacijent;
		this.lekarId = lekar;
		this.vremePocetka = vremePocetka;
		this.vremeKraja = izracunajVremeKrajaPregleda(this.vremePocetka);
		this.sobaId = soba;
		this.opis = opis;
		this.status = status;
	}
	public Pregled() {
		this(-5,-5,-5,null,-5,"",StatusPregleda.zatrazen);
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPacijentId() {
		return pacijentId;
	}
	public void setPacijentId(int pacijentId) {
		this.pacijentId = pacijentId;
	}
	public int getLekarId() {
		return lekarId;
	}
	public void setLekarId(int lekarId) {
		this.lekarId = lekarId;
	}
	public LocalDateTime getVremePocetka() {
		return vremePocetka;
	}
	public void setVremePocetka(LocalDateTime vremePocetka) {
		this.vremePocetka = vremePocetka;
	}
	public LocalDateTime getVremeKraja() {
		return vremeKraja;
	}
	public void setVremeKraja(LocalDateTime vremeKraja) {
		this.vremeKraja = vremeKraja;
	}
	public int getSobaId() {
		return sobaId;
	}
	public void setSobaId(int sobaId) {
		this.sobaId = sobaId;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public StatusPregleda getStatus() {
		return status;
	}
	public void setStatus(StatusPregleda status) {
		this.status = status;
	}
	private LocalDateTime izracunajVremeKrajaPregleda(LocalDateTime vremePocetka) {
		return vremePocetka.plusMinutes(15);
	}
	@Override
	public Identifiable CreateFromString(String text) {
		var pregled = new Pregled();
		var sc = new Scanner(text);
		sc.useDelimiter("\\|");
		
		pregled.setId(sc.nextInt());
		pregled.setPacijentId(sc.nextInt());
		pregled.setLekarId(sc.nextInt());
		pregled.setVremePocetka(LocalDateTime.parse(sc.next(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
		pregled.setVremeKraja(LocalDateTime.parse(sc.next(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
		pregled.setSobaId(sc.nextInt());
		pregled.setOpis(sc.next());
		switch(sc.nextInt()) {
		case 0: pregled.setStatus(StatusPregleda.zatrazen);break;
		case 1: pregled.setStatus(StatusPregleda.zakazan);break;
		case 2: pregled.setStatus(StatusPregleda.otkazan);break;
		case 3: pregled.setStatus(StatusPregleda.zavrsen);break;
		default: pregled.setStatus(StatusPregleda.zatrazen);break;
		}
		sc.close();
		return this;
	}
	@Override
	public String WriteToString() {
		var line = new StringJoiner("|");
		line.add(this.getId()+"").add(this.getPacijentId()+"").add(this.getLekarId()+"");
		line.add(this.getVremePocetka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
		line.add(this.getVremeKraja().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
		line.add(this.getSobaId()+"");
		line.add(this.getOpis());
		line.add(this.getStatus().ordinal()+"");
		return line.toString();
	}
}
