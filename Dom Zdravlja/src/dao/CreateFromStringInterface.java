package dao;

import model.Identifiable;

@FunctionalInterface
public interface CreateFromStringInterface {
	public Identifiable CreateFromString(String text);
}
