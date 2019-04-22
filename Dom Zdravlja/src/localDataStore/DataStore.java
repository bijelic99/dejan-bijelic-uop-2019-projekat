package localDataStore;

import java.util.ArrayList;

import dao.DAOInterface;
import model.*;

public class DataStore {
	public static ArrayList<Identifiable> sobe;
	public static ArrayList<Identifiable> domoviZdravljaSluzbe;
	public static ArrayList<Identifiable> domoviZdravlja;
	public static ArrayList<Identifiable> zdravstveneKnjizice;
	public static ArrayList<Identifiable> medicinskeSestre;
	public static ArrayList<Identifiable> lekari;
	public static ArrayList<Identifiable> pacijenti;
	public static ArrayList<Identifiable> pregledi;
	public static ArrayList<Identifiable> racuni;
	
	
	
	public static void main(String[] args) {
		sobe = DAOInterface.ucitajSve((new Soba())::CreateFromString, DAOInterface.sobaPath);
		domoviZdravljaSluzbe = DAOInterface.ucitajSve((new DomZdravljaSluzba())::CreateFromString, DAOInterface.domZdravljaSluzbaPath);
		domoviZdravlja = DAOInterface.ucitajSve((new DomZdravlja())::CreateFromString, DAOInterface.domZdravljaPath);
		zdravstveneKnjizice = DAOInterface.ucitajSve((new ZdravstvenaKnjizica())::CreateFromString, DAOInterface.zdravstvenaKnjizicaPath);
		medicinskeSestre = DAOInterface.ucitajSve((new MedicinskaSestra())::CreateFromString, DAOInterface.medicinskaSestraPath);
		lekari = DAOInterface.ucitajSve((new Lekar())::CreateFromString, DAOInterface.lekarPath);
		pacijenti = DAOInterface.ucitajSve((new Pacijent())::CreateFromString, DAOInterface.pacijentPath);
		pregledi = DAOInterface.ucitajSve((new Pregled())::CreateFromString, DAOInterface.pregledPath);
		racuni = DAOInterface.ucitajSve((new Racun())::CreateFromString, DAOInterface.pregledPath);
		
		

	}

}
