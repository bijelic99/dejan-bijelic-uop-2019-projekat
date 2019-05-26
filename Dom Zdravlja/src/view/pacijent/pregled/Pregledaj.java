package view.pacijent.pregled;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.DataStore;
import controller.Router;
import model.Pregled;
import model.StatusPregleda;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Pregledaj extends JPanel {
	private JTable jt;
	private Boolean samoZakazani;
	/**
	 * Create the panel.
	 */
	public Pregledaj() {
		setBorder(new TitledBorder(null, "Pregledaj Preglede", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		this.samoZakazani = false;
		
		JScrollPane scrollPane = new JScrollPane(jt);
		add(scrollPane, BorderLayout.CENTER);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ucitajPreglede();
			}
		});
		add(btnRefresh, BorderLayout.SOUTH);

		ucitajPreglede();
	}
	public Pregledaj(Boolean samoZakazani) {
		setBorder(new TitledBorder(null, "Pregledaj Preglede", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		jt = new JTable();
		JScrollPane scrollPane = new JScrollPane(jt);
		add(scrollPane, BorderLayout.CENTER);
		
		this.samoZakazani = samoZakazani;
		
		ucitajPreglede();
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ucitajPreglede();
			}
		});
		add(btnRefresh, BorderLayout.SOUTH);
		
	}
	private void ucitajPreglede() {
		var korisnikId = Router.trenutniKorisnik.getId();
		String[] cols = {"ID","Lekar","Opis","Soba","Status","Termin"};
		var dtm = new DefaultTableModel(cols,0);
		if(samoZakazani) {
			DataStore.pregledi.values().stream().map(i->(Pregled)i).filter(p->p.getPacijentId() == korisnikId && p.getStatus() == StatusPregleda.zakazan).forEach(p->{
				Object[] o = new Object[cols.length];
				o[0] = p.getId();
				o[1] = DataStore.lekari.get(p.getLekarId());
				o[2] = p.getOpis();
				o[3] = DataStore.sobe.get(p.getSobaId());
				o[4] = p.getStatus();
				o[5] = p.getTermin();
				dtm.addRow(o);
			});
		}
		else {
			DataStore.pregledi.values().stream().map(i->(Pregled)i).filter(p->p.getPacijentId() == korisnikId).forEach(p->{
				Object[] o = new Object[cols.length];
				o[0] = p.getId();
				o[1] = DataStore.lekari.get(p.getLekarId());
				o[2] = p.getOpis();
				o[3] = DataStore.sobe.get(p.getSobaId());
				o[4] = p.getStatus();
				o[5] = p.getTermin();
				dtm.addRow(o);
			});
		}
		jt.setModel(dtm);
		
	}

}
