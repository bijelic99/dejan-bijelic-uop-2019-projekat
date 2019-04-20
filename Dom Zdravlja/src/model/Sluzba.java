package model;

public enum Sluzba {
	sluzbaOpsteMedicine, sluzbaZdravstveneZastiteDece, stomatoloskaSluzba, sluzbaZdravstveneZastiteRadnika,
	sluzbaZaPravneIEkonomskePoslove, sluzbaZaTehnickePoslove, neodredjena;

	private String text;
	private boolean dozvoljenoLekaru = true;

	static {
		sluzbaOpsteMedicine.text = "Sluzba Opste Medicine";
		sluzbaZdravstveneZastiteDece.text = "Sluzba Zdravstvene Zastite Dece";
		stomatoloskaSluzba.text = "Stomatoloska Sluzba";
		sluzbaZdravstveneZastiteRadnika.text = "Sluzba Zdravstvene Zastite Radnika";
		sluzbaZaPravneIEkonomskePoslove.text = "Sluzba Za Pravne i Ekonomske Poslove";
		sluzbaZaPravneIEkonomskePoslove.dozvoljenoLekaru = false;
		sluzbaZaTehnickePoslove.text = "Sluzba Za Tehnicke Poslove";
		sluzbaZaTehnickePoslove.dozvoljenoLekaru = false;
		neodredjena.text = "Neodredjena";

	}

	public String getText() {
		return text;
	}

	public boolean isDozvoljenoLekaru() {
		return dozvoljenoLekaru;
	}
}
