package model;

public enum KategorijaOsiguranja {
	I,II,III,nema;
	private String text;
	private double cenaPregleda;
	static {
		I.text="I(Prva)";
		I.cenaPregleda = 300;
		II.text="II(Druga)";
		II.cenaPregleda = 50;
		III.text="III(Treca)";
		III.cenaPregleda=0;
		nema.text="Nije Iskazana";
		nema.cenaPregleda=0;
	}
	public String getText() {
		return text;
	}
	public double getCenaPregleda() {
		return cenaPregleda;
	}
}
