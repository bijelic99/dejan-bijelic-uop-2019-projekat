package model;

public class MedicinskaSestra extends MedicinskiRadnik {

	public MedicinskaSestra() {
		this(-5, "", "", "", false, "", "", "", "", 0.00, null, null);
		
	}

	public MedicinskaSestra(int id, String ime, String prezime, String jmbg, boolean pol, String adresa,
			String brojTelefona, String username, String password, double plata, Sluzba sluzba,
			DomZdravlja domZdravlja) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, username, password, TipKorisnika.medicinskaSestra,
				plata, sluzba, domZdravlja);
		
	}

	@Override
	public String toString() {
		return "Medicinska Sestra "+this.getIme()+" "+this.getPrezime();
	}
	

}
