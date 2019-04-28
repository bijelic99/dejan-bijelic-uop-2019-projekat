package view.medicinskaSestra.adminTools.lekar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.DataStore;
import model.DomZdravlja;
import model.Lekar;

@SuppressWarnings("serial")
public class PregledajSveLekare extends JPanel {

	private JTable table;

	/**
	 * Create the panel.
	 */
	public PregledajSveLekare() {
		setBorder(new TitledBorder(null, "Pregled Lekara", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

	private DefaultTableModel ucitajTabelu() {

		String[] redovi = { "Id", "Ime", "Prezime", "JMBG", "Pol", "Adresa", "Broj Telefona", "Username",
				"Dom Zdravlja", "Sluzba", "Plata", "Specijalizacija" };
		var dtm = new DefaultTableModel(redovi, 0);
		DataStore.lekari.values().stream().map(i -> (Lekar) i).map(l -> {
			var a = new Object[redovi.length];
			a[0] = l.getId();
			a[1] = l.getIme();
			a[2] = l.getPrezime();
			a[3] = l.getJmbg();
			a[4] = l.isPol() ? "Muski" : "Zenski";
			a[5] = l.getAdresa();
			a[6] = l.getBrojTelefona();
			a[7] = l.getUsername();
			try {
				a[8] = DataStore.domoviZdravlja.values().stream().map(i -> (DomZdravlja) i)
						.filter(d -> d.getId() == l.getDomZdravljaId()).findFirst().get();
			} catch (Exception e) {
				a[8] = "nema";
			}
			a[9] = l.getSluzba();
			a[10] = l.getPlata();
			a[11] = l.getSpecijalizacija();
			return a;
		}).forEach(a -> dtm.addRow(a));

		return dtm;
	}

}
