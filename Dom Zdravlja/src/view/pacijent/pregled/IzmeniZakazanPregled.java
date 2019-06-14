package view.pacijent.pregled;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import controller.DataStore;
import model.Pregled;
import model.StatusPregleda;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IzmeniZakazanPregled extends JPanel {
	private JComboBox<Pregled> comboBox;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public IzmeniZakazanPregled() {
		setBorder(new TitledBorder(null, "Izmeni zakazan pregled", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,
						"Jeste li sigurni da zelite da izmenite opis zatrazenog pregleda?") == JOptionPane.YES_OPTION)
					izmeni();
			}
		});
		add(btnIzmeni, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("fillx", "[20%][grow]", "[][grow]"));

		JLabel lblOpis = new JLabel("Opis:");
		panel.add(lblOpis, "cell 0 0,alignx right,aligny top");

		textArea = new JTextArea();
		panel.add(textArea, "cell 1 0 1 2, grow");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		
				comboBox = new JComboBox<Pregled>(new DefaultComboBoxModel<Pregled>(DataStore.pregledi.values().stream()
						.map(i -> (Pregled) i).filter(p -> p.getPacijentId() == controller.Router.trenutniKorisnik.getId()
								&& p.getStatus() == StatusPregleda.zatrazen)
						.toArray(Pregled[]::new)));
				panel_1.add(comboBox);
				comboBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (comboBox.getSelectedIndex() != -1) {
							textArea.setText(((Pregled) comboBox.getSelectedItem()).getOpis() + "");
						}
					}
				});
				comboBox.setSelectedIndex(-1);

	}

	protected void izmeni() {
		if(comboBox.getSelectedIndex() != -1) {
			var pregled = (Pregled)comboBox.getSelectedItem();
			if(!textArea.getText().isBlank()) {
				pregled.setOpis(textArea.getText());
				try {
					DataStore.izmeni(pregled);
					JOptionPane.showMessageDialog(null, "Uspeh!!!");
					view.Utility.resetForm(this);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Greska!!!");
				}
			} else JOptionPane.showMessageDialog(null, "Morate napisati opis");
		} else JOptionPane.showMessageDialog(null, "Morate odabrati pregled");
		
	}

}
