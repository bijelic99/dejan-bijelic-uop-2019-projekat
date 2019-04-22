package model;

public class Lekar extends MedicinskiRadnik {
	private String specijalizacija;
	public Lekar() {
		this(-5, "", "", "", false, "", "", "", "", 0.00, Sluzba.neodredjena, -5,"nema");
		
	}

	public Lekar(int id, String ime, String prezime, String jmbg, boolean pol, String adresa,
			String brojTelefona, String username, String password, double plata, Sluzba sluzba,
			int domZdravlja, String specijalizacija) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, username, password, TipKorisnika.lekar,
				plata, sluzba, domZdravlja);
		this.specijalizacija = specijalizacija;
	}

	public String getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(String specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

	@Override
	public String toString() {
		return "Dr. "+this.getIme()+" "+this.getPrezime();
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
