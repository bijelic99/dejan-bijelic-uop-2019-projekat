package view;

import java.time.LocalDate;

import dao.DAOInterface;
import model.ZdravstvenaKnjizica;

public class Main {

	public static void main(String[] args) {
		var zk = new ZdravstvenaKnjizica(1, 0, LocalDate.now(), model.KategorijaOsiguranja.nema);
		DAOInterface.dodaj(zk, DAOInterface.zdravstvenaKnjizicaPath);

	}

}
