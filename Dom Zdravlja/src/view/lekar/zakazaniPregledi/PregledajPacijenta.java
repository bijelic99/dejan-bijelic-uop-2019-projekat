package view.lekar.zakazaniPregledi;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.DataStore;
import model.Pregled;
import model.StatusPregleda;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PregledajPacijenta extends JPanel {

	private JComboBox<Pregled> comboBox;

	/**
	 * Create the panel.
	 */
	public PregledajPacijenta() {
		setBorder(new TitledBorder(null, "Pregledaj pacijenta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		comboBox = new JComboBox<Pregled>();
		ucitajModel();
		comboBox.setSelectedIndex(-1);
		add(comboBox, BorderLayout.NORTH);

		JButton btnPregledaj = new JButton("Pregledaj");
		btnPregledaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,
						"Jeste li sigurni da zelite pregledati pacijenta") == JOptionPane.YES_OPTION)
					pregledaj();
			}
		});
		add(btnPregledaj, BorderLayout.SOUTH);

	}

	private void pregledaj() {
		if (comboBox.getSelectedIndex() != -1) {
			var pregled = (Pregled) comboBox.getSelectedItem();
			pregled.setStatus(StatusPregleda.zavrsen);
			try {
				DataStore.izmeni(pregled);
				JOptionPane.showMessageDialog(null, "Uspeh");
				ucitajModel();
				comboBox.setSelectedIndex(-1);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Greska " + e.getMessage());
			}

		}
		else JOptionPane.showMessageDialog(null, "Morate izabrati pregled");

	}
	
	private void ucitajModel() {
		var model = new DefaultComboBoxModel<Pregled>(DataStore.pregledi.values().stream().map(i -> (Pregled) i)
				.filter(p -> p.getStatus() == StatusPregleda.zakazan
						&& p.getLekarId() == controller.Router.trenutniKorisnik.getId())
				.toArray(Pregled[]::new));
		comboBox.setModel(model);

	}

}
