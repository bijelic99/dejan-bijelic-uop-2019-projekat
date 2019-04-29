package model;

import java.util.Scanner;

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

	
	public static Identifiable CreateFromString(String text) {
		var sc = new Scanner(text);
		var sestra = new MedicinskaSestra();
		sc.useDelimiter("\\|");
		
		sestra.setId(sc.nextInt());
		sestra.setIme(sc.next());
		sestra.setPrezime(sc.next());
		sestra.setJmbg(sc.next());
		sestra.setPol(sc.nextBoolean());
		sestra.setAdresa(sc.next());
		sestra.setBrojTelefona(sc.next());
		sestra.setUsername(sc.next());
		sestra.setPassword(sc.next());
		sc.nextInt();
		sestra.setPlata(sc.nextDouble());
		sestra.setSluzba(Sluzba.getSluzba(sc.nextInt()));
		sestra.setDomZdravljaId(sc.nextInt());
		
		sc.close();
		return sestra;
	}

	@Override
	public String WriteToString() {
		return super.WriteToString();
	}
	

}
