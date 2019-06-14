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
import model.Pacijent;
import model.ZdravstvenaKnjizica;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class IzmeniZdravstvenuKnjizicu extends JPanel {

	private JTextField textField;
	private JComboBox<ZdravstvenaKnjizica> comboBox;
	private JComboBox<KategorijaOsiguranja> comboBox_1;
	private ZdravstvenaKnjizica menjaSe = null;
	private JComboBox<Pacijent> comboBox_2;

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
		panel_1.setLayout(new MigLayout("fillx", "[left][left, fill][][][]"));

		JLabel lblKorisnik = new JLabel("Korisnik: ");
		lblKorisnik.setBounds(10, 11, 100, 14);
		panel_1.add(lblKorisnik, "cell 0 0 1 1");

		JLabel lblVremeIsteka = new JLabel("Vreme Isteka:");
		lblVremeIsteka.setBounds(10, 36, 100, 14);
		panel_1.add(lblVremeIsteka, "cell 0 1 1 1");

		JLabel lblKategorija = new JLabel("Kategorija: ");
		lblKategorija.setBounds(10, 61, 100, 14);
		panel_1.add(lblKategorija, "cell 0 2 1 1");

		comboBox_2 = new JComboBox<Pacijent>(
				new DefaultComboBoxModel<Pacijent>(DataStore.pacijenti.values().toArray(Pacijent[]::new)));
		comboBox_2.setSelectedIndex(-1);
		panel_1.add(comboBox_2, "cell 1 0 4 1");

		textField = new JTextField();
		textField.setBounds(120, 33, 308, 20);
		panel_1.add(textField, "cell 1 1 4 1");

		comboBox_1 = new JComboBox<KategorijaOsiguranja>(
				new DefaultComboBoxModel<KategorijaOsiguranja>(Stream.of(KategorijaOsiguranja.values())
						.filter(k -> k != KategorijaOsiguranja.nema).toArray(KategorijaOsiguranja[]::new)));
		comboBox_1.setBounds(120, 57, 308, 22);
		panel_1.add(comboBox_1, "cell 1 2 4 1");

	}

	protected void izmeniZdravstvenuKnjizicu() {
		if (comboBox_2.getSelectedIndex() != -1) {
			try {
				menjaSe.setDatumIsteka(
						LocalDate.parse(textField.getText().strip(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				menjaSe.setKategorija((KategorijaOsiguranja) comboBox_1.getSelectedItem());
				var pacijent = (Pacijent) comboBox_2.getSelectedItem();
				pacijent.setZdravstvenaKnjizicaId(menjaSe.getId());
				menjaSe.setIdKorisnika(pacijent.getId());
				DataStore.zdravstveneKnjizice.values().stream().map(i -> (ZdravstvenaKnjizica) i)
						.filter(zk -> zk.getId() != menjaSe.getId() && zk.getIdKorisnika() == pacijent.getId())
						.forEach(zk -> {
							zk.setIdKorisnika(-5);
							try {
								DataStore.izmeni(zk);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						});
				DataStore.izmeni(menjaSe);
				DataStore.izmeni(pacijent);
				JOptionPane.showMessageDialog(null, "Uspesna Izmena");
				view.Utility.resetForm(this);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Morate uneti pravilan datum formata dd-mm-yyyy i odabrati kategoriju");
			}
		} else
			JOptionPane.showMessageDialog(null, "Morate uneti korisnika");

	}

	protected void ucitajKorisnika() {
		if(comboBox.getSelectedIndex() != -1) {
		menjaSe = (ZdravstvenaKnjizica) comboBox.getSelectedItem();
		try {
			comboBox_2.setSelectedItem((Pacijent) DataStore.pacijenti.values().stream()
					.filter(i -> i.getId() == menjaSe.getIdKorisnika()).findFirst().get());
		} catch (Exception e) {
			comboBox_2.setSelectedIndex(-1);
		}
		textField.setText(menjaSe.getDatumIsteka().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		comboBox_1.setSelectedItem(menjaSe.getKategorija());
		}
	}

	protected JComboBox<KategorijaOsiguranja> getComboBox_1() {
		return comboBox_1;
	}
}
