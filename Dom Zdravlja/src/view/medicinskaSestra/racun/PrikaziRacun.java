package view.medicinskaSestra.racun;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.DataStore;
import model.Pregled;
import model.Racun;
import model.StatusPregleda;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class PrikaziRacun extends JPanel {
	private JComboBox<Pregled> comboBox;
	private RacunPanel panel_1;

	/**
	 * Create the panel.
	 */
	public PrikaziRacun() {
		setBorder(new TitledBorder(null, "Prikazi Racun", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		comboBox = new JComboBox<Pregled>(new DefaultComboBoxModel<Pregled>(DataStore.pregledi.values().stream()
				.map(i -> (Pregled) i).filter(p -> p.getStatus() == StatusPregleda.zavrsen).toArray(Pregled[]::new)));
		comboBox.setSelectedIndex(-1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox.getSelectedIndex() != -1) {
					var r = new Racun((Pregled)comboBox.getSelectedItem());
					panel_1.setRacun(r);
					
					
				}
			}
		});
		panel.add(comboBox);
		
		panel_1 = new RacunPanel();
		add(panel_1, BorderLayout.CENTER);

	}

}
