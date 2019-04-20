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
	
}
