package view.medicinskaSestra.adminTools.zdravstvenaKnjizica;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.DataStore;
import model.ZdravstvenaKnjizica;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PregledajSveZdravstveneKnjizice extends JPanel {
	private JTable table;
	/**
	 * Create the panel.
	 */
	public PregledajSveZdravstveneKnjizice() {
		setBorder(new TitledBorder(null, "Pregledaj Sve Zdravstvene Knjizice", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		String[] redovi = { "Id", "Id Korisnika", "Korisnik", "Kategorija Osiguranja", "Datum Isteka"};
		var dtm = new DefaultTableModel(redovi, 0);
		
		DataStore.zdravstveneKnjizice.values().stream().map(i->(ZdravstvenaKnjizica)i).map(z->{
			var a = new Object[redovi.length];
			a[0] = z.getId();
			a[1] = z.getIdKorisnika();
			try {
				a[2]=DataStore.pacijenti.values().stream().filter(i->i.getId() == z.getIdKorisnika()).findFirst().get();
			} catch (Exception e) {
				a[2]="Nedostupno";
			}
			a[3] = z.getKategorija();
			a[4] = z.getDatumIsteka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					
			return a;
		}).forEach(o->dtm.addRow(o));
		
		return dtm;
	}

}
