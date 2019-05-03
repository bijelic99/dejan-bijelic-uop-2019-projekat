package view.medicinskaSestra.adminTools.pregled;

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
import model.Pregled;

@SuppressWarnings("serial")
public class ObrisiPregled extends JPanel {
	private JComboBox<Pregled> comboBox;

	/**
	 * Create the panel.
	 */
	public ObrisiPregled() {
		setBorder(new TitledBorder(null, "Obrisi Pregled", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
							comboBox.setModel(new DefaultComboBoxModel<Pregled>(DataStore.pregledi.values().toArray(Pregled[]::new)));
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
		
		comboBox = new JComboBox<Pregled>(new DefaultComboBoxModel<Pregled>(DataStore.pregledi.values().toArray(Pregled[]::new)));
		panel.add(comboBox);

	}

	protected JComboBox<Pregled> getComboBox() {
		return comboBox;
	}
}
