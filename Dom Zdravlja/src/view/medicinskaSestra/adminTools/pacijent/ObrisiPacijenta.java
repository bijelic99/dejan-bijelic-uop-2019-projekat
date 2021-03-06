package view.medicinskaSestra.adminTools.pacijent;

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
import model.Pacijent;
import model.ZdravstvenaKnjizica;

@SuppressWarnings("serial")
public class ObrisiPacijenta extends JPanel {
	private JComboBox<Pacijent> comboBox;

	/**
	 * Create the panel.
	 */
	public ObrisiPacijenta() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Brisanje Pacijenta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != -1) {
					if (JOptionPane.showConfirmDialog(null, "Jeste li sigurni da zelite da obrisete ?", "Brisanje",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
						try {
							DataStore.obrisi(((Identifiable)comboBox.getSelectedItem()));
							DataStore.obrisi(DataStore.zdravstveneKnjizice.values().stream().filter(i->((ZdravstvenaKnjizica)i).getIdKorisnika() == ((Identifiable)comboBox.getSelectedItem()).getId()).findFirst().get());
							JOptionPane.showMessageDialog(null, "Uspesno Obrisano");
							comboBox.setSelectedIndex(-1);
							comboBox.setModel(new DefaultComboBoxModel<Pacijent>(DataStore.pacijenti.values().toArray(Pacijent[]::new)));
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

		comboBox = new JComboBox<Pacijent>(
				new DefaultComboBoxModel<Pacijent>(DataStore.pacijenti.values().toArray(Pacijent[]::new)));
		comboBox.setSelectedIndex(-1);
		panel.add(comboBox);

	}

}
