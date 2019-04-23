package model;

public enum TipKorisnika {
	medicinskaSestra,
	pacijent,
	lekar;
	
	private String text;
	
	static {
		medicinskaSestra.text = "Medicinska Sestra";
		pacijent.text = "Pacijent";
		lekar.text = "Lekar";
	}

	public String getText() {
		return text;
	}
	
	public static TipKorisnika getRole(int ord) {
		switch(ord) {
		case 0: return TipKorisnika.medicinskaSestra;
		case 1: return TipKorisnika.pacijent;
		case 2: return TipKorisnika.lekar;
		default: return TipKorisnika.pacijent;
		}
	}
	
}
