package model;

public class MedicinskaSestra extends MedicinskiRadnik {

	public MedicinskaSestra() {
		this(-5, "", "", "", false, "", "", "", "", 0.00, Sluzba.neodredjena, -5);
		
	}

	public MedicinskaSestra(int id, String ime, String prezime, String jmbg, boolean pol, String adresa,
			String brojTelefona, String username, String password, double plata, Sluzba sluzba,
			int domZdravlja) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, username, password, TipKorisnika.medicinskaSestra,
				plata, sluzba, domZdravlja);
		
	}

	@Override
	public String toString() {
		return "Medicinska Sestra "+this.getIme()+" "+this.getPrezime();
	}

	@Override
	public Identifiable CreateFromString(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String WriteToString() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
