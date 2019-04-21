package dao;

import java.util.ArrayList;

import model.CreateFromStringInterface;
import model.Identifiable;
import model.WriteToStringInterface;

public interface DAOInterface {
	public static boolean dodaj(Identifiable object, String path) {
		return false;
		
	}
	public static boolean izmeni(Identifiable object, String path) {
		return false;
	}
	public static boolean obrisi(Identifiable object, String path) {
		return false;
	}
	
	public static ArrayList<Identifiable> ucitajSve(CreateFromStringInterface createFromString, String path) {
		return null;
	}

	public static Identifiable ucitaj(int id, CreateFromStringInterface createFromString, String path) {
		return null;
	}
	
}
