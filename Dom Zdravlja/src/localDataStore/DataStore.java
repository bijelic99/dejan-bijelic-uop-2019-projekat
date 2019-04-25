package localDataStore;

import java.util.ArrayList;
import java.util.HashMap;
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
	public static HashMap<Integer, Identifiable> sobe = null;
	public static HashMap<Integer, Identifiable> domoviZdravljaSluzbe = null;
	public static HashMap<Integer, Identifiable> domoviZdravlja = null;
	public static HashMap<Integer, Identifiable> zdravstveneKnjizice = null;
	public static HashMap<Integer, Identifiable> medicinskeSestre = null;
	public static HashMap<Integer, Identifiable> lekari = null;
	public static HashMap<Integer, Identifiable> pacijenti = null;
	public static HashMap<Integer, Identifiable> pregledi = null;
	public static HashMap<Integer, Identifiable> racuni = null;

	public static void initialLoad() {
		sobe = DAOInterface.ucitajSve((new Soba())::CreateFromString, DAOInterface.sobaPath);
		domoviZdravljaSluzbe = DAOInterface.ucitajSve((new DomZdravljaSluzba())::CreateFromString,
				DAOInterface.domZdravljaSluzbaPath);
		domoviZdravlja = DAOInterface.ucitajSve((new DomZdravlja())::CreateFromString, DAOInterface.domZdravljaPath);
		zdravstveneKnjizice = DAOInterface.ucitajSve((new ZdravstvenaKnjizica())::CreateFromString,
				DAOInterface.zdravstvenaKnjizicaPath);
		medicinskeSestre = DAOInterface.ucitajSve((new MedicinskaSestra())::CreateFromString,
				DAOInterface.medicinskaSestraPath);
		lekari = DAOInterface.ucitajSve((new Lekar())::CreateFromString, DAOInterface.lekarPath);
		pacijenti = DAOInterface.ucitajSve((new Pacijent())::CreateFromString, DAOInterface.pacijentPath);
		pregledi = DAOInterface.ucitajSve((new Pregled())::CreateFromString, DAOInterface.pregledPath);
		racuni = DAOInterface.ucitajSve((new Racun())::CreateFromString, DAOInterface.pregledPath);

	}

	public static HashSet<Sluzba> ucitajSluzbeDomaZdravlja(int id) {
		return new HashSet<Sluzba>(domoviZdravljaSluzbe.entrySet().stream()
				.filter(i -> ((DomZdravljaSluzba) i.getValue()).getIdDomaZdravlja() == id)
				.map(i -> Sluzba.getSluzba(((DomZdravljaSluzba) i.getValue()).getSluzbaOrd()))
				.collect(Collectors.toSet()));

	}

	public static ArrayList<Soba> ucitajSobeUDomuZdravlja(int id) {
		return new ArrayList<Soba>(sobe.entrySet().stream().filter(i -> ((Soba) i.getValue()).getIdDomaZdravlja() == id)
				.map(i -> ((Soba) i.getValue())).collect(Collectors.toList()));
	}

	public static int generateId(HashMap<Integer, Identifiable> list) {

		return (int) (list.entrySet().stream().map(i -> i.getValue().getId()).max((v1, v2) -> (v1 > v2) ? v1 : v2)
				.get()) + 1;
	}

	// Nisam fan ovih f-ja
	public static void dodaj(Identifiable object) throws Exception {
		if (object instanceof Soba) {
			object.setId(generateId(sobe));
			sobe.put(object.getId(), object);
			DAOInterface.dodaj(object, DAOInterface.sobaPath);
		} else if (object instanceof DomZdravljaSluzba) {
			object.setId(generateId(domoviZdravljaSluzbe));
			domoviZdravljaSluzbe.put(object.getId(), object);
			DAOInterface.dodaj(object, DAOInterface.domZdravljaSluzbaPath);
		} else if (object instanceof DomZdravlja) {
			object.setId(generateId(domoviZdravlja));
			domoviZdravlja.put(object.getId(), object);
			DAOInterface.dodaj(object, DAOInterface.domZdravljaPath);
		} else if (object instanceof ZdravstvenaKnjizica) {
			object.setId(generateId(zdravstveneKnjizice));
			zdravstveneKnjizice.put(object.getId(), object);
			DAOInterface.dodaj(object, DAOInterface.zdravstvenaKnjizicaPath);
		} else if (object instanceof MedicinskaSestra) {
			object.setId(generateId(medicinskeSestre));
			medicinskeSestre.put(object.getId(), object);
			DAOInterface.dodaj(object, DAOInterface.medicinskaSestraPath);
		} else if (object instanceof Lekar) {
			object.setId(generateId(lekari));
			lekari.put(object.getId(), object);
			DAOInterface.dodaj(object, DAOInterface.lekarPath);
		} else if (object instanceof Pacijent) {
			object.setId(generateId(pacijenti));
			pacijenti.put(object.getId(), object);
			DAOInterface.dodaj(object, DAOInterface.pacijentPath);
		} else if (object instanceof Pregled) {
			object.setId(generateId(pregledi));
			pregledi.put(object.getId(), object);
			DAOInterface.dodaj(object, DAOInterface.pregledPath);
		} else if (object instanceof Racun) {
			object.setId(generateId(racuni));
			racuni.put(object.getId(), object);
			DAOInterface.dodaj(object, DAOInterface.racunPath);
		} else {
			throw new Exception("Object not supported");
		}
	}
	
	public static void izmeni(Identifiable object) throws Exception {
		if (object instanceof Soba) {
			sobe.replace(object.getId(), object);
			DAOInterface.izmeni(object, DAOInterface.sobaPath);
		} else if (object instanceof DomZdravljaSluzba) {
			domoviZdravljaSluzbe.replace(object.getId(), object);
			DAOInterface.izmeni(object, DAOInterface.domZdravljaSluzbaPath);
		} else if (object instanceof DomZdravlja) {
			domoviZdravlja.replace(object.getId(), object);
			DAOInterface.izmeni(object, DAOInterface.domZdravljaPath);
		} else if (object instanceof ZdravstvenaKnjizica) {
			zdravstveneKnjizice.replace(object.getId(), object);
			DAOInterface.izmeni(object, DAOInterface.zdravstvenaKnjizicaPath);
		} else if (object instanceof MedicinskaSestra) {
			medicinskeSestre.replace(object.getId(), object);
			DAOInterface.izmeni(object, DAOInterface.medicinskaSestraPath);
		} else if (object instanceof Lekar) {
			lekari.replace(object.getId(), object);
			DAOInterface.izmeni(object, DAOInterface.lekarPath);
		} else if (object instanceof Pacijent) {
			pacijenti.replace(object.getId(), object);
			DAOInterface.izmeni(object, DAOInterface.pacijentPath);
		} else if (object instanceof Pregled) {
			pregledi.replace(object.getId(), object);
			DAOInterface.izmeni(object, DAOInterface.pregledPath);
		} else if (object instanceof Racun) {
			racuni.replace(object.getId(), object);
			DAOInterface.izmeni(object, DAOInterface.racunPath);
		} else {
			throw new Exception("Object not supported");
		}
	}
	
	public static void obrisi(Identifiable object) throws Exception {
		if (object instanceof Soba) {
			sobe.remove(object.getId());
			DAOInterface.obrisi(object, DAOInterface.sobaPath);
		} else if (object instanceof DomZdravljaSluzba) {
			domoviZdravljaSluzbe.remove(object.getId());
			DAOInterface.obrisi(object, DAOInterface.domZdravljaSluzbaPath);
		} else if (object instanceof DomZdravlja) {
			domoviZdravlja.remove(object.getId());
			DAOInterface.obrisi(object, DAOInterface.domZdravljaPath);
		} else if (object instanceof ZdravstvenaKnjizica) {
			zdravstveneKnjizice.remove(object.getId());
			DAOInterface.obrisi(object, DAOInterface.zdravstvenaKnjizicaPath);
		} else if (object instanceof MedicinskaSestra) {
			medicinskeSestre.remove(object.getId());
			DAOInterface.obrisi(object, DAOInterface.medicinskaSestraPath);
		} else if (object instanceof Lekar) {
			lekari.remove(object.getId());
			DAOInterface.obrisi(object, DAOInterface.lekarPath);
		} else if (object instanceof Pacijent) {
			pacijenti.remove(object.getId());
			DAOInterface.obrisi(object, DAOInterface.pacijentPath);
		} else if (object instanceof Pregled) {
			pregledi.remove(object.getId());
			DAOInterface.obrisi(object, DAOInterface.pregledPath);
		} else if (object instanceof Racun) {
			racuni.remove(object.getId());
			DAOInterface.obrisi(object, DAOInterface.racunPath);
		} else {
			throw new Exception("Object not supported");
		}
	}

}
