package view.medicinskaSestra.adminTools.pregled;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.DataStore;
import model.Pregled;

@SuppressWarnings("serial")
public class PregledajSvePreglede extends JPanel {
	private JTable table;
	/**
	 * Create the panel.
	 */
	public PregledajSvePreglede() {
		setBorder(new TitledBorder(null, "Pregledaj Sve Preglede", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		String[] redovi = { "Id", "Pacijent", "Lekar", "Vreme Pocetka",  "Soba", "Status", "Opis"};
		var dtm = new DefaultTableModel(redovi, 0);
		
		DataStore.pregledi.values().stream().map(i->(Pregled)i).map(p->{
			var a = new Object[redovi.length];
			a[0] = p.getId();
			try {
				a[1] = DataStore.pacijenti.values().stream().filter(i->i.getId() == p.getPacijentId()).findFirst().get();
			} catch (Exception e) {
				a[1] = "Nedostupno";
			}
			try {
				a[2] = DataStore.lekari.values().stream().filter(l->l.getId() == p.getLekarId()).findFirst().get();
			} catch (Exception e) {
				a[2] = "Nedostupno";
			}
			a[3] = p.getTermin().getVremePocetka().format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"));
			try {
				a[4] = DataStore.sobe.values().stream().filter(i->i.getId() == p.getSobaId()).findFirst().get();
			} catch (Exception e) {
				a[4] = "Nedostupno";
			}
			a[5] = p.getStatus();
			a[6] = p.getOpis();
					
			return a;
		}).forEach(o->dtm.addRow(o));
		
		return dtm;
	}

}
