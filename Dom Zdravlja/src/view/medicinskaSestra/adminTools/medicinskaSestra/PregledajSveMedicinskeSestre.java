package view.medicinskaSestra.adminTools.medicinskaSestra;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.DataStore;
import model.DomZdravlja;
import model.MedicinskaSestra;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PregledajSveMedicinskeSestre extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PregledajSveMedicinskeSestre() {
		setBorder(new TitledBorder(null, "Pregled Medicinskih Sestri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		table = new JTable(ucitajTabelu());
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(ucitajTabelu());
			}
		});
		add(btnRefresh, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		
	}

	private TableModel ucitajTabelu() {
		String[] redovi = { "Id", "Ime", "Prezime", "JMBG", "Pol", "Adresa", "Broj Telefona", "Username",
				"Dom Zdravlja", "Sluzba", "Plata"};
		var dtm = new DefaultTableModel(redovi, 0);
		DataStore.medicinskeSestre.values().stream().map(i->(MedicinskaSestra)i).map(m->{
			var a = new Object[redovi.length];
			a[0] = m.getId();
			a[1] = m.getIme();
			a[2] = m.getPrezime();
			a[3] = m.getJmbg();
			a[4] = m.isPol() ? "Muski" : "Zenski";
			a[5] = m.getAdresa();
			a[6] = m.getBrojTelefona();
			a[7] = m.getUsername();
			try {
				a[8] = DataStore.domoviZdravlja.values().stream().map(i -> (DomZdravlja) i)
						.filter(d -> d.getId() == m.getDomZdravljaId()).findFirst().get();
			} catch (Exception e) {
				a[8] = "nema";
			}
			a[9] = m.getSluzba();
			a[10] = m.getPlata();
			return a;
		}).forEach(a->dtm.addRow(a));
		
		return dtm;
	}

}
