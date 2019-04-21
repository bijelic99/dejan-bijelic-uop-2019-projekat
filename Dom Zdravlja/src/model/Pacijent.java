package model;

public class Pacijent extends Osoba {
	private Lekar izabraniLekar;
	private ZdravstvenaKnjizica zdravstvenaKnjizica;
	public Pacijent(int id, String ime, String prezime, String jmbg, boolean pol, String adresa, String brojTelefona,
			String username, String password, TipKorisnika uloga, Lekar izabraniLekar,
			ZdravstvenaKnjizica zdravstvenaKnjizica) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, username, password, uloga);
		this.izabraniLekar = izabraniLekar;
		this.zdravstvenaKnjizica = zdravstvenaKnjizica;
	}
	public Pacijent() {
		this(-5,"","","",true,"","","","", TipKorisnika.pacijent, null, null);
		// TODO Auto-generated constructor stub
	}
	public Lekar getIzabraniLekar() {
		return izabraniLekar;
	}
	public void setIzabraniLekar(Lekar izabraniLekar) {
		this.izabraniLekar = izabraniLekar;
	}
	public ZdravstvenaKnjizica getZdravstvenaKnjizica() {
		return zdravstvenaKnjizica;
	}
	public void setZdravstvenaKnjizica(ZdravstvenaKnjizica zdravstvenaKnjizica) {
		this.zdravstvenaKnjizica = zdravstvenaKnjizica;
	}
	@Override
	public String toString() {
		return this.getIme()+" "+this.getPrezime();
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
