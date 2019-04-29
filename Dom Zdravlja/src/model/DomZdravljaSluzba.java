package model;

import java.util.Scanner;
import java.util.StringJoiner;

public class DomZdravljaSluzba extends Identifiable {
	private int idDomaZdravlja;
	private int sluzbaOrd;

	public DomZdravljaSluzba() {
		this(-5,-5,-5);
	}

	public DomZdravljaSluzba(int id, int idDomaZdravlja, int sluzbaOrd) {
		super(id);
		this.idDomaZdravlja = idDomaZdravlja;
		this.sluzbaOrd = sluzbaOrd;
	}

	public int getIdDomaZdravlja() {
		return idDomaZdravlja;
	}

	public void setIdDomaZdravlja(int idDomaZdravlja) {
		this.idDomaZdravlja = idDomaZdravlja;
	}

	public int getSluzbaOrd() {
		return sluzbaOrd;
	}

	public void setSluzbaOrd(int sluzbaOrd) {
		this.sluzbaOrd = sluzbaOrd;
	}

	
	public static Identifiable CreateFromString(String text) {
		var dzs = new DomZdravljaSluzba();
		var sc = new Scanner(text);
		sc.useDelimiter("\\|");
		dzs.setId(sc.nextInt());
		dzs.setIdDomaZdravlja(sc.nextInt());
		dzs.setSluzbaOrd(sc.nextInt());
		sc.close();
		return dzs;
	}

	@Override
	public String WriteToString() {
		var line = new StringJoiner("|");
		line.add(this.getId()+"").add(this.getIdDomaZdravlja()+"").add(this.getSluzbaOrd()+"");
		return line.toString();
	}

}
