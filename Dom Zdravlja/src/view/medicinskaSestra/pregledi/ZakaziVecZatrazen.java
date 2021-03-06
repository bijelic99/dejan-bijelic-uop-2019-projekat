package view.medicinskaSestra.pregledi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.DataStore;
import model.Pregled;
import model.Soba;
import model.StatusPregleda;
import model.Termin;
import model.Lekar;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class ZakaziVecZatrazen extends JPanel {
	private JComboBox<Pregled> comboBox;
	private JTextField textField;
	private JComboBox<Soba> comboBox_1;

	/**
	 * Create the panel.
	 */
	public ZakaziVecZatrazen() {
		setBorder(new TitledBorder(null, "Zakazi Pregled", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		JButton btnZakazi = new JButton("Zakazi");
		btnZakazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != -1 && DataStore.proveriIspravnostIDostupnostTermina(
						textField.getText().strip(), (((Pregled) comboBox.getSelectedItem()).getLekarId())))
					if (JOptionPane.showConfirmDialog(null, "Jeste li sigurni da zelite zakazati za taj termin",
							"Potvrda zakazivanja", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
						ZakaziPregled();
					else
						JOptionPane.showMessageDialog(null, "Morate izabrati pregled i upisati ispravno vreme");
			}
		});
		add(btnZakazi, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		comboBox = new JComboBox<Pregled>(new DefaultComboBoxModel<Pregled>(DataStore.pregledi.values().stream()
				.map(i -> (Pregled) i).filter(p -> p.getStatus() == StatusPregleda.zatrazen).toArray(Pregled[]::new)));
		comboBox.setSelectedIndex(-1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getSelectedIndex() != -1) {
					comboBox_1.setModel(new DefaultComboBoxModel<Soba>(
							DataStore.sobe.values().stream().map(i -> (Soba) i).filter(s -> {
								return s.getIdDomaZdravlja() == ((Lekar) DataStore.lekari
										.get(((Pregled) comboBox.getSelectedItem()).getLekarId())).getDomZdravljaId();
							}).toArray(Soba[]::new)));
				}
			}
		});
		panel.add(comboBox);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("fillx", "[][grow,fill][][][fill]", "[][]"));

		JLabel lblUnesiteDatum = new JLabel("Unesite Datum: ");
		panel_1.add(lblUnesiteDatum, "cell 0 0,alignx trailing");

		textField = new JTextField();
		panel_1.add(textField, "cell 1 0 3 1");
		textField.setColumns(10);

		JButton btnProveri = new JButton("Proveri");
		btnProveri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != -1) {
					if (DataStore.proveriIspravnostIDostupnostTermina(textField.getText().strip(),
							(((Pregled) comboBox.getSelectedItem()).getLekarId())))
						JOptionPane.showMessageDialog(null, "Termin ispravan");
					else
						JOptionPane.showMessageDialog(null, "Termin neispravan");
				} else
					JOptionPane.showMessageDialog(null, "Izaberite Pregled");
			}
		});
		panel_1.add(btnProveri, "cell 4 0");

		JLabel lblIzaberiteSobu = new JLabel("Izaberite Sobu:");
		panel_1.add(lblIzaberiteSobu, "cell 0 1,alignx trailing");

		comboBox_1 = new JComboBox<Soba>();
		panel_1.add(comboBox_1, "cell 1 1 4 1,growx");

	}

	protected void ZakaziPregled() {
		var pregled = (Pregled) comboBox.getSelectedItem();
		pregled.setStatus(StatusPregleda.zakazan);
		var vreme = LocalDateTime.parse(textField.getText().strip(), DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"));
		pregled.setTermin(new Termin(vreme, vreme.plusMinutes(15)));
		try {
			pregled.setSobaId(((Soba)comboBox_1.getSelectedItem()).getId());
			DataStore.izmeni(pregled);
			JOptionPane.showMessageDialog(null, "Uspesno ste zakazali");
			view.Utility.resetForm(this);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greska " + e.getMessage());
		}
	}

	protected JComboBox<Pregled> getComboBox() {
		return comboBox;
	}
}
