package model;

public class Soba {
	private int id;
	private String naziv;
	public Soba(int id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	public Soba() {
		this(-5,"");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	@Override
	public String toString() {
		return this.getNaziv();
	}
	
	
}
