package model;

import dao.WriteToStringInterface;

public abstract class Identifiable implements WriteToStringInterface{
	protected int id;

	public Identifiable(int id) {
		super();
		this.id = id;
	}
	public Identifiable() {
		this(-5);
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
