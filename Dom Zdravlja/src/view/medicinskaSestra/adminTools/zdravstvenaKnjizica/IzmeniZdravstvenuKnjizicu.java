package view.medicinskaSestra.adminTools.zdravstvenaKnjizica;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.DataStore;
import model.KategorijaOsiguranja;
import model.ZdravstvenaKnjizica;

@SuppressWarnings("serial")
public class IzmeniZdravstvenuKnjizicu extends JPanel {

	private JLabel lblNewLabel;
	private JTextField textField;
	private JComboBox<ZdravstvenaKnjizica> comboBox;
	private JComboBox<KategorijaOsiguranja> comboBox_1;
	private ZdravstvenaKnjizica menjaSe = null;

	/**
	 * Create the panel.
	 */
	public IzmeniZdravstvenuKnjizicu() {
		setBorder(new TitledBorder(null, "Izmeni Zdravstvenu Knjizicu", TitledBorder.LEADING, TitledBorder.TOP, null,
				null));
		setLayout(new BorderLayout(0, 0));

		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Jeste li sigurni da hocete da izmenite", "Izmena",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.YES_OPTION)
					if (menjaSe != null)
						izmeniZdravstvenuKnjizicu();
			}
		});
		add(btnIzmeni, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		comboBox = new JComboBox<ZdravstvenaKnjizica>(new DefaultComboBoxModel<ZdravstvenaKnjizica>(
				DataStore.zdravstveneKnjizice.values().toArray(ZdravstvenaKnjizica[]::new)));
		comboBox.setSelectedIndex(-1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getSelectedIndex() != -1)
					ucitajKorisnika();
			}
		});

		panel.add(comboBox);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblKorisnik = new JLabel("Korisnik: ");
		lblKorisnik.setBounds(10, 11, 100, 14);
		panel_1.add(lblKorisnik);

		JLabel lblVremeIsteka = new JLabel("Vreme Isteka:");
		lblVremeIsteka.setBounds(10, 36, 100, 14);
		panel_1.add(lblVremeIsteka);

		JLabel lblKategorija = new JLabel("Kategorija: ");
		lblKategorija.setBounds(10, 61, 100, 14);
		panel_1.add(lblKategorija);

		lblNewLabel = new JLabel(" ");
		lblNewLabel.setBounds(120, 11, 308, 14);
		panel_1.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(120, 33, 308, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		comboBox_1 = new JComboBox<KategorijaOsiguranja>(
				new DefaultComboBoxModel<KategorijaOsiguranja>(Stream.of(KategorijaOsiguranja.values())
						.filter(k -> k != KategorijaOsiguranja.nema).toArray(KategorijaOsiguranja[]::new)));
		comboBox_1.setBounds(120, 57, 308, 22);
		panel_1.add(comboBox_1);

	}

	protected void izmeniZdravstvenuKnjizicu() {
		try {
			menjaSe.setDatumIsteka(LocalDate.parse(textField.getText().strip(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			menjaSe.setKategorija((KategorijaOsiguranja)comboBox_1.getSelectedItem());
			DataStore.izmeni(menjaSe);
			JOptionPane.showMessageDialog(null, "Uspesna Izmena");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Morate uneti pravilan datum formata dd-mm-yyyy i odabrati kategoriju");
		}
		
	}

	protected void ucitajKorisnika() {
		menjaSe = (ZdravstvenaKnjizica) comboBox.getSelectedItem();
		try {
			lblNewLabel.setText(DataStore.pacijenti.values().stream().filter(i -> i.getId() == menjaSe.getIdKorisnika())
					.findFirst().get().toString() + "");
		} catch (Exception e) {
			lblNewLabel.setText("Nedostupno");
		}
		textField.setText(menjaSe.getDatumIsteka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		comboBox_1.setSelectedItem(menjaSe.getKategorija());

	}

	protected JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	protected JComboBox<KategorijaOsiguranja> getComboBox_1() {
		return comboBox_1;
	}
}
