package utility;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;

import dao.DAOInterface;
import localDataStore.DataStore;
import model.DomZdravlja;
import model.KategorijaOsiguranja;
import model.Lekar;
import model.MedicinskaSestra;
import model.Pacijent;
import model.Sluzba;
import model.TipKorisnika;
import model.ZdravstvenaKnjizica;
import model.Soba;

public class DataLoadScript {

	public static void main(String[] args) {
		
		DataStore.initialLoad();
		
		var p=new Pacijent(0, "Dejan", "Bijelic", "MojJmbg", true, "NekaAdresa", "060555333", "bijelic99", "sifraSifra", TipKorisnika.pacijent, 0, 0);
		var k = new ZdravstvenaKnjizica(0, 0, LocalDate.of(2019, Month.JULY, 22), KategorijaOsiguranja.I);
		DAOInterface.dodaj(p, DAOInterface.pacijentPath);
		DAOInterface.dodaj(k, DAOInterface.zdravstvenaKnjizicaPath);
		
		p=new Pacijent(1, "Dragan", "Bijelic", "NjegovJmbg", true, "NekaAdresa", "060555333", "bijelic03", "sifraSifra2", TipKorisnika.pacijent, 0, 1);
		k = new ZdravstvenaKnjizica(1, 1, LocalDate.of(2019, Month.JULY, 15), KategorijaOsiguranja.II);
		DAOInterface.dodaj(p, DAOInterface.pacijentPath);
		DAOInterface.dodaj(k, DAOInterface.zdravstvenaKnjizicaPath);
		
		p=new Pacijent(2, "Radoslav", "Petrovic", "115445454", false, "NekaAdresa", "06021105445", "rasa", "rasaradoslav", TipKorisnika.pacijent, 1, 2);
		k = new ZdravstvenaKnjizica(2, 2, LocalDate.of(2019, Month.MAY, 5), KategorijaOsiguranja.III);
		DAOInterface.dodaj(p, DAOInterface.pacijentPath);
		DAOInterface.dodaj(k, DAOInterface.zdravstvenaKnjizicaPath);
		
		var ms = new MedicinskaSestra(0, "Medicinska", "Sestra", "JMBG", false, "Adresa", "+381555666", "ms00", "sifra", 32000.00, Sluzba.sluzbaOpsteMedicine, 0);
		DAOInterface.dodaj(ms, DAOInterface.medicinskaSestraPath);
		
		ms = new MedicinskaSestra(1, "Medicinska2", "Sestra2", "JMBG2", false, "Adres2a", "+3815556662", "ms01", "sifra", 34000.00, Sluzba.sluzbaZdravstveneZastiteDece, 1);
		DAOInterface.dodaj(ms, DAOInterface.medicinskaSestraPath);
		
		var lk = new Lekar(0, "Doktor", "Prvi", "ddasdasadsad", true, "Adresa", "dsadasa", "dr01", "sifra", 120000.00, Sluzba.sluzbaOpsteMedicine, 0, "Prva Specijalizacija");
		DAOInterface.dodaj(lk, DAOInterface.lekarPath);
		
		lk = new Lekar(1, "Doktor", "Drugi", "ddasdasadsad", false, "Adresa", "dsadasa", "dr02", "sifra", 125000.00, Sluzba.sluzbaOpsteMedicine, 1, "Druga Specijalizacija");
		DAOInterface.dodaj(lk, DAOInterface.lekarPath);
		
		var hs = new HashSet<Sluzba>();
		hs.add(Sluzba.sluzbaOpsteMedicine);
		hs.add(Sluzba.sluzbaZdravstveneZastiteDece);
		hs.add(Sluzba.sluzbaZdravstveneZastiteRadnika);
		var sobe =new ArrayList<Soba>();
		var s = new Soba(0, 0, "Prva");
		DAOInterface.dodaj(s, DAOInterface.sobaPath);
		sobe.add(s);
		s = new Soba(1, 0, "Druga");
		DAOInterface.dodaj(s, DAOInterface.sobaPath);
		sobe.add(s);
		s = new Soba(2, 0, "Treca");
		DAOInterface.dodaj(s, DAOInterface.sobaPath);
		sobe.add(s);
		s = new Soba(3, 0, "Cetvrta");
		DAOInterface.dodaj(s, DAOInterface.sobaPath);
		sobe.add(s);
		
		var dz = new DomZdravlja(0, "Dom Zdravlja u Novom Sadu", hs, sobe);
		DAOInterface.dodaj(dz, DAOInterface.domZdravljaPath);
		
		hs = new HashSet<Sluzba>();
		hs.add(Sluzba.sluzbaOpsteMedicine);
		hs.add(Sluzba.sluzbaZdravstveneZastiteDece);
		hs.add(Sluzba.sluzbaZdravstveneZastiteRadnika);
		hs.add(Sluzba.sluzbaZaPravneIEkonomskePoslove);
		sobe =new ArrayList<Soba>();
		s = new Soba(4, 1, "PrvaA");
		DAOInterface.dodaj(s, DAOInterface.sobaPath);
		sobe.add(s);
		s = new Soba(5, 1, "DrugaA");
		DAOInterface.dodaj(s, DAOInterface.sobaPath);
		sobe.add(s);
		s = new Soba(6, 1, "TrecaA");
		DAOInterface.dodaj(s, DAOInterface.sobaPath);
		sobe.add(s);
		s = new Soba(7, 1, "CetvrtaA");
		DAOInterface.dodaj(s, DAOInterface.sobaPath);
		sobe.add(s);
		
		dz = new DomZdravlja(1, "Dom Zdravlja u Nisu", hs, sobe);
		DAOInterface.dodaj(dz, DAOInterface.domZdravljaPath);
		
		
	}

}
