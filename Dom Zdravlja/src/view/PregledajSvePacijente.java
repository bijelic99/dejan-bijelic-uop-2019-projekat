package view;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import localDataStore.DataStore;
import model.Identifiable;
import model.Lekar;
import model.Pacijent;

@SuppressWarnings("serial")
public class PregledajSvePacijente extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PregledajSvePacijente(HashMap<Integer, Identifiable> mapaPacijenata) {
		
		String[] redovi = { "Id", "Ime", "Prezime", "JMBG", "Pol", "Adresa", "Broj Telefona", "Username", "Izabrani Doktor"};
		setLayout(new BorderLayout(0, 0));
		var listaPacijenata = mapaPacijenata.entrySet().stream().map(es -> ((Pacijent) es.getValue()))
				.sorted((p1, p2) -> {
					if (p1.getId() > p2.getId())
						return 1;
					else if (p1.getId() < p2.getId())
						return -1;
					return 0;
				}).collect(Collectors.toList());
		var dtm = new DefaultTableModel(redovi, 0);
		
		listaPacijenata.stream().map(p->{
			Object[] row = new Object[9];
			row[0] = p.getId();
			row[1] = p.getIme();
			row[2] = p.getPrezime();
			row[3] = p.getJmbg();
			row[4] = p.isPol();
			row[5] = p.getAdresa();
			row[6] = p.getBrojTelefona();
			row[7] = p.getUsername();
			try {
				row[8] = DataStore.lekari.values().stream().filter(i->((Lekar)i).getId() == p.getIzabraniLekarId()).findFirst().get();
			}catch (Exception e) {
				row[8] = "Nije Dostupno";
			}
					
			return row;
		}).forEach(o -> dtm.addRow(o));
		table = new JTable(dtm);



		add(new JScrollPane(table), BorderLayout.CENTER);

	}

}
