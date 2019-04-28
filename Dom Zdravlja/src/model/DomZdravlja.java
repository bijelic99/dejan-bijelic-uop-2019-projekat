package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringJoiner;

public class DomZdravlja extends Identifiable{
	
	private String naziv;
	private HashSet<Sluzba> sluzbe;
	private ArrayList<Soba> sobe;
	public DomZdravlja(int id, String naziv, HashSet<Sluzba> sluzbe, ArrayList<Soba> sobe) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.sluzbe = sluzbe;
		this.sobe = sobe;
	}
	public DomZdravlja() {
		this(-5,"",new HashSet<Sluzba>(), new ArrayList<Soba>());
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
	public HashSet<Sluzba> getSluzbe() {
		return sluzbe;
	}
	public void setSluzbe(HashSet<Sluzba> sluzbe) {
		this.sluzbe = sluzbe;
	}
	public ArrayList<Soba> getSobe() {
		return sobe;
	}
	public void setSobe(ArrayList<Soba> sobe) {
		this.sobe = sobe;
	}
	
	@Override
	public String toString() {
		return this.getNaziv();
	}
	@Override
	public Identifiable CreateFromString(String text) {
		var dom = new DomZdravlja();
		var sc = new Scanner(text);
		sc.useDelimiter("\\|");
		
		dom.setId(sc.nextInt());
		dom.setNaziv(sc.next());
		dom.setSluzbe(controller.DataStore.ucitajSluzbeDomaZdravlja(dom.getId()));
		dom.setSobe(controller.DataStore.ucitajSobeUDomuZdravlja(dom.getId()));
		
		
		sc.close();
		return dom;
	}
	@Override
	public String WriteToString() {
		var line = new StringJoiner("|");
		line.add(this.getId()+"").add(this.getNaziv());
		controller.DataStore.srediSluzbe(this.getId(), this.getSluzbe());
		controller.DataStore.srediSobe(this.getId(), this.getSobe());
		return line.toString();
	}
	
	
	
}
