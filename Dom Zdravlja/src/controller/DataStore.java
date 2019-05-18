package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

import dao.DAOInterface;
import model.*;

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
		sobe = DAOInterface.ucitajSve(Soba::CreateFromString, DAOInterface.sobaPath);
		domoviZdravljaSluzbe = DAOInterface.ucitajSve(DomZdravljaSluzba::CreateFromString,
				DAOInterface.domZdravljaSluzbaPath);
		domoviZdravlja = DAOInterface.ucitajSve(DomZdravlja::CreateFromString, DAOInterface.domZdravljaPath);
		zdravstveneKnjizice = DAOInterface.ucitajSve(ZdravstvenaKnjizica::CreateFromString,
				DAOInterface.zdravstvenaKnjizicaPath);
		medicinskeSestre = DAOInterface.ucitajSve(MedicinskaSestra::CreateFromString,
				DAOInterface.medicinskaSestraPath);
		lekari = DAOInterface.ucitajSve(Lekar::CreateFromString, DAOInterface.lekarPath);
		pacijenti = DAOInterface.ucitajSve(Pacijent::CreateFromString, DAOInterface.pacijentPath);
		pregledi = DAOInterface.ucitajSve(Pregled::CreateFromString, DAOInterface.pregledPath);
		racuni = DAOInterface.ucitajSve(Racun::CreateFromString, DAOInterface.racunPath);

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
		if (!list.isEmpty()) {
			return list.values().stream().map(i -> i.getId()).max(Integer::compare).get() + 1;
		} else
			return 0;
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

	public static void srediSluzbe(int idDomaZdravlja, HashSet<Sluzba> sluzbe) {
		sluzbe.stream().map(s -> new DomZdravljaSluzba(0, idDomaZdravlja, s.ordinal())).forEach(s -> {
			try {
				domoviZdravljaSluzbe.entrySet().stream()
						.filter(e -> ((DomZdravljaSluzba) e.getValue()).getIdDomaZdravlja() == idDomaZdravlja
								&& ((DomZdravljaSluzba) e.getValue()).getSluzbaOrd() == s.getSluzbaOrd())
						.findFirst().get();
			} catch (Exception e) {

				try {
					DataStore.dodaj(s);
				} catch (Exception e1) {
					// Really doesnt need to be here
				}
			}
		});
	}

	public static void srediSobe(int idDomaZdravlja, ArrayList<Soba> sobe2) {
		sobe2.stream().forEach(s -> {
			if (!sobe.containsKey(s.getId())) {
				try {
					DataStore.dodaj(s);
				} catch (Exception e) {
					// Again really doesnt need to be here
				}
			}
		});

	}

	public static boolean checkIfUsernameAvailable(String username) {
		var isGood = true;
		try {

			pacijenti.values().stream().filter(i -> ((Osoba) i).getUsername().equals(username)).findAny().get();
			isGood = false;

		} catch (Exception e) {
			isGood = true;
		}
		try {

			medicinskeSestre.values().stream().filter(i -> ((Osoba) i).getUsername().equals(username)).findAny().get();
			isGood = false;

		} catch (Exception e) {
			if (isGood != false)
				isGood = true;
		}
		try {

			lekari.values().stream().filter(i -> ((Osoba) i).getUsername().equals(username)).findAny().get();
			isGood = false;

		} catch (Exception e) {
			if (isGood != false)
				isGood = true;
		}
		return isGood;
	}

	public static void dodajPacijenta(Pacijent p, ZdravstvenaKnjizica zdravstvenaKnjizica) {
		p.setId(generateId(pacijenti));

		zdravstvenaKnjizica.setIdKorisnika(p.getId());
		zdravstvenaKnjizica.setId(generateId(zdravstveneKnjizice));
		p.setZdravstvenaKnjizicaId(zdravstvenaKnjizica.getId());
		try {
			dodaj(p);
			dodaj(zdravstvenaKnjizica);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean proveriIspravnostIDostupnostTermina(String termin, Lekar lekar) {
		try {
			var vremePocetka = LocalDateTime.parse(termin, DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"));
			if(vremePocetka.isAfter(LocalDateTime.now()) || vremePocetka.equals(LocalDateTime.now())) {
			var vremeKraja = vremePocetka.plusMinutes(15);
			if (pregledi.values().stream().filter(i -> ((Pregled) i).getLekarId() == lekar.getId())
					.map(i -> (Pregled) i).filter(p -> {
						return !((vremeKraja.isBefore(p.getTermin().getVremePocetka())
								|| vremeKraja.isEqual(p.getTermin().getVremePocetka()))
								|| (vremePocetka.isAfter(p.getTermin().getVremeKraja())
										|| vremePocetka.isEqual(p.getTermin().getVremeKraja())));
					}).count() != 0)
				return false;}
			else return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static boolean proveriIspravnostIDostupnostTermina(String termin, int lekarId) {
		try {
			var vremePocetka = LocalDateTime.parse(termin, DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"));
			if(vremePocetka.isAfter(LocalDateTime.now()) || vremePocetka.equals(LocalDateTime.now())) {
			var vremeKraja = vremePocetka.plusMinutes(15);
			if (pregledi.values().stream().filter(i -> ((Pregled) i).getLekarId() == lekarId)
					.map(i -> (Pregled) i).filter(p -> {
						return !((vremeKraja.isBefore(p.getTermin().getVremePocetka())
								|| vremeKraja.isEqual(p.getTermin().getVremePocetka()))
								|| (vremePocetka.isAfter(p.getTermin().getVremeKraja())
										|| vremePocetka.isEqual(p.getTermin().getVremeKraja())));
					}).count() != 0)
				return false;}
			else return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
