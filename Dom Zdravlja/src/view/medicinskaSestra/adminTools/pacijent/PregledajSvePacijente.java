package view.medicinskaSestra.adminTools.pacijent;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.DataStore;
import model.Identifiable;
import model.Lekar;
import model.Pacijent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PregledajSvePacijente extends JPanel {
	private JTable table;
	private HashMap<Integer, Identifiable> mapaPacijenata;

	/**
	 * Create the panel.
	 */
	public PregledajSvePacijente() {
		setBorder(new TitledBorder(null, "Pregled Pacijenata", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		mapaPacijenata = DataStore.pacijenti;
		table = new JTable(ucitajTabelu());
		table.setDefaultEditor(Object.class, null);


		add(new JScrollPane(table), BorderLayout.CENTER);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(ucitajTabelu());
			}
		});
		add(btnRefresh, BorderLayout.SOUTH);

	}

	private DefaultTableModel ucitajTabelu() {
		mapaPacijenata = DataStore.pacijenti;
		String[] redovi = { "Id", "Ime", "Prezime", "JMBG", "Pol", "Adresa", "Broj Telefona", "Username", "Izabrani Doktor"};
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
		
		return dtm;
	}

}
