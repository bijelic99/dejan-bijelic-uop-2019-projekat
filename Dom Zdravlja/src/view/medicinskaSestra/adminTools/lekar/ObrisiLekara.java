package view.medicinskaSestra.adminTools.lekar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controller.DataStore;
import model.Identifiable;
import model.Lekar;

@SuppressWarnings("serial")
public class ObrisiLekara extends JPanel {
	private JComboBox<Lekar> comboBox;

	/**
	 * Create the panel.
	 */
	public ObrisiLekara() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Brisanje Lekara", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != -1) {
					if (JOptionPane.showConfirmDialog(null, "Jeste li sigurni da zelite da obrisete ?", "Brisanje",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
						try {
							DataStore.obrisi(((Identifiable)comboBox.getSelectedItem()));
							JOptionPane.showMessageDialog(null, "Uspesno Obrisano");
							comboBox.setSelectedIndex(-1);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Greska, nije obrisano!!!");
						}
				}
			}
		});
		add(btnObrisi, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		comboBox = new JComboBox<Lekar>(
				new DefaultComboBoxModel<Lekar>(DataStore.lekari.values().toArray(Lekar[]::new)));
		comboBox.setSelectedIndex(-1);
		panel.add(comboBox);

	}

}
