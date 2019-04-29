package model;

import java.util.Scanner;
import java.util.StringJoiner;

public class Soba extends Identifiable{
	private int idDomaZdravlja;
	private String naziv;
	public Soba(int id,int idDomaZdravlja, String naziv) {
		super();
		this.id = id;
		this.idDomaZdravlja = idDomaZdravlja;
		this.naziv = naziv;
	}
	public Soba() {
		this(-5,-5,"");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdDomaZdravlja() {
		return idDomaZdravlja;
	}
	public void setIdDomaZdravlja(int idDomaZdravlja) {
		this.idDomaZdravlja = idDomaZdravlja;
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
	
	public static Identifiable CreateFromString(String text) {
		
		var soba = new Soba();
		var sc = new Scanner(text);
		sc.useDelimiter("\\|");
		
		soba.setId(sc.nextInt());
		soba.setIdDomaZdravlja(sc.nextInt());
		soba.setNaziv(sc.next());
		
		sc.close();
		return soba;
	}
	@Override
	public String WriteToString() {
		var line = new StringJoiner("|");
		line.add(this.getId()+"").add(this.getIdDomaZdravlja()+"").add(this.getNaziv());
		return line.toString();
	}
	
	
}
