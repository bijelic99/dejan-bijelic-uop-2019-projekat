package view.pacijent.pregled;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.DataStore;
import controller.Router;
import model.Pregled;
import model.StatusPregleda;
import model.TipKorisnika;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OtkaziPregled extends JPanel {
	private JComboBox<Pregled> comboBox;

	/**
	 * Create the panel.
	 */
	public OtkaziPregled() {
		setBorder(new TitledBorder(null, "Otkazi Pregled", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		JButton btnOtkazi = new JButton("Otkazi");
		btnOtkazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Jeste li sigurni da zelite otkazati",
						"Potvrda zakazivanja", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					otkaziPregled();
			}
		});
		add(btnOtkazi, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		comboBox = new JComboBox<Pregled>();
		panel.add(comboBox);

		if (Router.trenutniKorisnik != null && Router.trenutniKorisnik.getUloga() == TipKorisnika.pacijent) {
			comboBox.setModel(new DefaultComboBoxModel<Pregled>(
					DataStore.pregledi.values().stream().map(i -> (Pregled) i).filter(p -> {
						return p.getPacijentId() == Router.trenutniKorisnik.getId()
								&& (p.getStatus() == StatusPregleda.zatrazen
										|| p.getStatus() == StatusPregleda.zakazan);
					}).toArray(Pregled[]::new)));
		}

	}

	protected void otkaziPregled() {
		var p = (Pregled)comboBox.getSelectedItem();
		p.setStatus(StatusPregleda.otkazan);
		try {
			DataStore.izmeni(p);
			JOptionPane.showMessageDialog(null, "Uspesno ste otkazali");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greska pri otkazivanju");
		}
		
	}

}
