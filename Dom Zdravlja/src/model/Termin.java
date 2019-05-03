package model;

import java.time.LocalDateTime;

public class Termin {
	private LocalDateTime vremePocetka;
	private LocalDateTime vremeKraja;
	public Termin(LocalDateTime vremePocetka, LocalDateTime vremeKraja) {
		super();
		this.vremePocetka = vremePocetka;
		this.vremeKraja = vremeKraja;
	}
	public Termin() {
		this(LocalDateTime.now(), LocalDateTime.now().plusMinutes(15));
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
	
}
