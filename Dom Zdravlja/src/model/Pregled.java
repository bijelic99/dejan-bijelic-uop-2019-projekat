package model;

import java.time.LocalDateTime;

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
	private Pacijent pacijent;
	private Lekar lekar;
	private LocalDateTime vremePocetka;
	private LocalDateTime vremeKraja;
	private Soba soba;
	private String opis;
	private StatusPregleda status;
	public Pregled(int id, Pacijent pacijent, Lekar lekar, LocalDateTime vremePocetka, LocalDateTime vremeKraja,
			Soba soba, String opis, StatusPregleda status) {
		super();
		this.id = id;
		this.pacijent = pacijent;
		this.lekar = lekar;
		this.vremePocetka = vremePocetka;
		this.vremeKraja = vremeKraja;
		this.soba = soba;
		this.opis = opis;
		this.status = status;
	}
	public Pregled(int id, Pacijent pacijent, Lekar lekar, LocalDateTime vremePocetka,
			Soba soba, String opis, StatusPregleda status) {
		super();
		this.id = id;
		this.pacijent = pacijent;
		this.lekar = lekar;
		this.vremePocetka = vremePocetka;
		this.vremeKraja = izracunajVremeKrajaPregleda(this.vremePocetka);
		this.soba = soba;
		this.opis = opis;
		this.status = status;
	}
	public Pregled() {
		this(-5,null,null,null,null,"",StatusPregleda.zatrazen);
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pacijent getPacijent() {
		return pacijent;
	}
	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}
	public Lekar getLekar() {
		return lekar;
	}
	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
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
	public Soba getSoba() {
		return soba;
	}
	public void setSoba(Soba soba) {
		this.soba = soba;
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String WriteToString(Identifiable object) {
		// TODO Auto-generated method stub
		return null;
	}
}
