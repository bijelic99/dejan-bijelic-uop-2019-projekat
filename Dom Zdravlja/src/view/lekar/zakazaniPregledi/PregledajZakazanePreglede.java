package view.lekar.zakazaniPregledi;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.DataStore;
import model.Pregled;
import model.StatusPregleda;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PregledajZakazanePreglede extends JPanel {
	private JTable jt;

	/**
	 * Create the panel.
	 */
	public PregledajZakazanePreglede() {
		setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Pregledaj zakazane preglede", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ucitajPodatke();
			}
		});
		add(btnRefresh, BorderLayout.SOUTH);

		jt = new JTable();
		jt.setDefaultEditor(Object.class, null);
		
		JScrollPane scrollPane = new JScrollPane(jt);
		add(scrollPane, BorderLayout.CENTER);
		
		ucitajPodatke();

	}

	private void ucitajPodatke() {

		String[] cols = { "ID", "Lekar", "Opis", "Soba", "Status", "Termin" };
		var dtm = new DefaultTableModel(cols, 0);
		var lekarId = controller.Router.trenutniKorisnik.getId();
		
		DataStore.pregledi.values().stream().map(i->(Pregled)i).filter(p->p.getStatus() == StatusPregleda.zakazan && p.getLekarId() == lekarId).forEach(p->{
			Object[] o = new Object[cols.length];
			o[0] = p.getId();
			o[1] = DataStore.lekari.get(p.getLekarId());
			o[2] = p.getOpis();
			o[3] = DataStore.sobe.get(p.getSobaId());
			o[4] = p.getStatus();
			o[5] = p.getTermin();
			dtm.addRow(o);
		});
		jt.setModel(dtm);
	}

}
