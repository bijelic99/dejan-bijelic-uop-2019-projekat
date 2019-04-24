package localDataStore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

import dao.DAOInterface;
import model.DomZdravlja;
import model.DomZdravljaSluzba;
import model.Identifiable;
import model.Lekar;
import model.MedicinskaSestra;
import model.Pacijent;
import model.Pregled;
import model.Racun;
import model.Sluzba;
import model.Soba;
import model.ZdravstvenaKnjizica;

public class DataStore {
	public static ArrayList<Identifiable> sobe=null;
	public static ArrayList<Identifiable> domoviZdravljaSluzbe=null;
	public static ArrayList<Identifiable> domoviZdravlja=null;
	public static ArrayList<Identifiable> zdravstveneKnjizice=null;
	public static ArrayList<Identifiable> medicinskeSestre=null;
	public static ArrayList<Identifiable> lekari=null;
	public static ArrayList<Identifiable> pacijenti=null;
	public static ArrayList<Identifiable> pregledi=null;
	public static ArrayList<Identifiable> racuni=null;
	
	
	
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



	public static HashSet<Sluzba> ucitajSluzbeDomaZdravlja(int id) {
		return new HashSet<Sluzba>(domoviZdravljaSluzbe.stream().filter(i->((DomZdravljaSluzba)i).getIdDomaZdravlja()==id).map(i->Sluzba.getSluzba(((DomZdravljaSluzba)i).getSluzbaOrd())).collect(Collectors.toSet()));
		
	}



	public static ArrayList<Soba> ucitajSobeUDomuZdravlja(int id) { 
		return new ArrayList<Soba>(sobe.stream().filter(i->((Soba)i).getIdDomaZdravlja()==id).map(i->((Soba)i)).collect(Collectors.toList()));
	}
	
	public static int generateId(ArrayList<Identifiable> list) {
		
		return (int)(list.stream().map(i->i.getId()).max((v1, v2)->(v1>v2)?v1:v2).get())+1;
	}
	
	//napisati fje za dodavanje brisanje itd koje persistuju pomocu dao u fajl

}
