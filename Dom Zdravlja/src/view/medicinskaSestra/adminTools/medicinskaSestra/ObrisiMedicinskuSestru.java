package view.medicinskaSestra.adminTools.medicinskaSestra;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.DataStore;
import model.Identifiable;
import model.MedicinskaSestra;

@SuppressWarnings("serial")
public class ObrisiMedicinskuSestru extends JPanel {
	private JComboBox<MedicinskaSestra> comboBox;

	/**
	 * Create the panel.
	 */
	public ObrisiMedicinskuSestru() {
		setBorder(new TitledBorder(null, "Obrisi Medicinsku Sestru", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
							comboBox.setModel(new DefaultComboBoxModel<MedicinskaSestra>(DataStore.medicinskeSestre.values().toArray(MedicinskaSestra[]::new)));
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
		
		comboBox = new JComboBox<MedicinskaSestra>(new DefaultComboBoxModel<MedicinskaSestra>(DataStore.medicinskeSestre.values().toArray(MedicinskaSestra[]::new)));
		comboBox.setSelectedIndex(-1);
		panel.add(comboBox);

	}

}
