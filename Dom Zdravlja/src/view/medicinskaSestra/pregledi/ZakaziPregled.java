package view.medicinskaSestra.pregledi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.DataStore;
import model.Lekar;
import model.Pacijent;
import model.Pregled;
import model.Soba;
import model.StatusPregleda;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class ZakaziPregled extends JPanel {
	protected JComboBox<Soba> comboBox_2;
	protected JComboBox<Lekar> comboBox_1;
	protected JComboBox<Pacijent> comboBox;
	protected JTextArea textArea;
	protected JTextField textField;
	protected JButton btnProveri;

	/**
	 * Create the panel.
	 */
	public ZakaziPregled() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Zakazi Pregled", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		JButton btnZakazi = new JButton("Zakazi");
		btnZakazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == -1 || comboBox_1.getSelectedIndex() == -1
						|| comboBox_2.getSelectedIndex() == -1 || textField.getText().strip().isEmpty()
						|| textArea.getText().strip().isEmpty())
					JOptionPane.showMessageDialog(null, "Morate Sve popuniti");
				else {
					if (JOptionPane.showConfirmDialog(null, "Jeste li sigurni da zelite zakazati pregled", "Dodavanje",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
						zakaziPregled();
				}
			}
		});
		add(btnZakazi, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("fillx", "[left][left, fill][][][fill]", "[][][][][fill]"));

		JLabel lblPacijent = new JLabel("Pacijent: ");
		lblPacijent.setBounds(10, 11, 100, 14);
		panel.add(lblPacijent);

		comboBox = new JComboBox<Pacijent>(
				new DefaultComboBoxModel<Pacijent>(DataStore.pacijenti.values().toArray(Pacijent[]::new)));
		comboBox.setBounds(120, 7, 378, 22);
		panel.add(comboBox, "span 4, wrap");

		JLabel lblLekar = new JLabel("Lekar: ");
		lblLekar.setBounds(10, 36, 100, 14);
		panel.add(lblLekar);

		comboBox_1 = new JComboBox<Lekar>(
				new DefaultComboBoxModel<Lekar>(DataStore.lekari.values().toArray(Lekar[]::new)));
		comboBox_1.setSelectedIndex(-1);
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox_1.getSelectedIndex() != -1) {
					comboBox_2.setModel(new DefaultComboBoxModel<Soba>(DataStore.sobe
							.values().stream().filter(i -> ((Soba) i)
									.getIdDomaZdravlja() == ((Lekar) comboBox_1.getSelectedItem()).getDomZdravljaId())
							.toArray(Soba[]::new)));
					comboBox_2.setEnabled(true);
					textField.setEnabled(true);
					btnProveri.setEnabled(true);

				} else {
					comboBox_2.setEnabled(false);
					textField.setEnabled(false);
					btnProveri.setEnabled(false);
				}
			}
		});
		comboBox_1.setBounds(120, 32, 378, 22);
		panel.add(comboBox_1, "span 4, wrap");

		JLabel lblVremePocetka = new JLabel("Vreme Pocetka: ");
		lblVremePocetka.setBounds(10, 86, 100, 14);
		panel.add(lblVremePocetka);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setToolTipText("HH:MM dd-mm-yyyy");
		textField.setBounds(120, 83, 161, 20);
		panel.add(textField, "span 3");

		btnProveri = new JButton("Proveri");
		btnProveri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DataStore.proveriIspravnostIDostupnostTermina(textField.getText().strip(),
						((Lekar) comboBox_1.getSelectedItem())))
					JOptionPane.showMessageDialog(null, "Termin ispravan");
				else
					JOptionPane.showMessageDialog(null, "Termin neispravan");
			}
		});
		btnProveri.setEnabled(false);
		btnProveri.setBounds(291, 82, 89, 23);
		panel.add(btnProveri, "wrap");

		JLabel lblSoba = new JLabel("Soba: ");
		lblSoba.setBounds(10, 61, 100, 14);
		panel.add(lblSoba);

		comboBox_2 = new JComboBox<Soba>();
		comboBox_2.setEnabled(false);
		comboBox_2.setBounds(120, 57, 378, 22);
		panel.add(comboBox_2, "span 4, wrap");

		JLabel lblOpis = new JLabel("Opis: ");
		lblOpis.setBounds(10, 136, 100, 14);
		panel.add(lblOpis);

		textArea = new JTextArea();
		textArea.setRows(4);
		textArea.setBounds(120, 131, 378, 145);
		panel.add(textArea, "span 4 3, wrap");

		JLabel lblStatus = new JLabel("Status: ");
		lblStatus.setBounds(10, 111, 100, 14);
		panel.add(lblStatus, "cell 0 7");

		JLabel lblZakazan = new JLabel("Zakazan");
		lblZakazan.setBounds(10, 111, 100, 14);
		panel.add(lblZakazan, "span 4, wrap");

	}

	protected void zakaziPregled() {
		var pacijent = (Pacijent) comboBox.getSelectedItem();
		var lekar = (Lekar) comboBox_1.getSelectedItem();
		var soba = (Soba) comboBox_2.getSelectedItem();
		var status = StatusPregleda.zakazan;

		if (DataStore.proveriIspravnostIDostupnostTermina(textField.getText().strip(), lekar)) {
			var pregled = new Pregled(-2, pacijent.getId(), lekar.getId(),
					LocalDateTime.parse(textField.getText().strip(), DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")),
					soba.getId(), textArea.getText().strip(), status);
			try {
				DataStore.dodaj(pregled);
				JOptionPane.showMessageDialog(null, "Uspesno ste dodali");
				view.Utility.resetForm(this);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Greska pri dodavanju");
			}
		} else
			JOptionPane.showMessageDialog(null, "Neispravan datum");

	}

}
