package view.medicinskaSestra.adminTools.pacijent;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.DataStore;
import model.Lekar;
import model.Pacijent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class IzmeniPacijenta extends JPanel {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JComboBox<Pacijent> comboBox;
	private JComboBox<Lekar> comboBox_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private Pacijent menjaSe = null;

	/**
	 * Create the panel.
	 */
	public IzmeniPacijenta() {
		setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Izmena Pacijenta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		var dcm = new DefaultComboBoxModel<Pacijent>(
				DataStore.pacijenti.values().stream().map(i -> (Pacijent) i).toArray(Pacijent[]::new));
		comboBox = new JComboBox<Pacijent>(dcm);
		comboBox.setSelectedIndex(-1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ucitajPacijenta();
			}
		});
		panel.add(comboBox);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		comboBox_1 = new JComboBox<Lekar>(new DefaultComboBoxModel<Lekar>(
				DataStore.lekari.values().stream().map(i -> (Lekar) i).toArray(Lekar[]::new)));
		comboBox_1.setBounds(128, 242, 300, 22);
		panel_1.add(comboBox_1);

		JLabel label = new JLabel("Izabrani Lekar: ");
		label.setBounds(10, 246, 108, 14);
		panel_1.add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 150, 300, 20);
		panel_1.add(textField_1);

		JLabel label_3 = new JLabel("Broj Telefona: ");
		label_3.setBounds(10, 153, 108, 14);
		panel_1.add(label_3);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 119, 300, 20);
		panel_1.add(textField_2);

		JLabel label_4 = new JLabel("Adresa: ");
		label_4.setBounds(10, 122, 108, 14);
		panel_1.add(label_4);

		radioButton = new JRadioButton("Zenski");
		buttonGroup.add(radioButton);
		radioButton.setBounds(190, 89, 109, 23);
		panel_1.add(radioButton);

		radioButton_1 = new JRadioButton("Muski");
		buttonGroup.add(radioButton_1);
		radioButton_1.setSelected(true);
		radioButton_1.setBounds(128, 89, 60, 23);
		panel_1.add(radioButton_1);

		JLabel label_5 = new JLabel("Pol: ");
		label_5.setBounds(10, 94, 108, 14);
		panel_1.add(label_5);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 63, 300, 20);
		panel_1.add(textField_3);

		JLabel label_6 = new JLabel("JMBG: ");
		label_6.setBounds(10, 66, 108, 14);
		panel_1.add(label_6);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(128, 35, 300, 20);
		panel_1.add(textField_4);

		JLabel label_7 = new JLabel("Prezime: ");
		label_7.setBounds(10, 38, 108, 14);
		panel_1.add(label_7);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(128, 11, 300, 20);
		panel_1.add(textField_5);

		JLabel label_8 = new JLabel("Ime: ");
		label_8.setBounds(10, 14, 108, 14);
		panel_1.add(label_8);

		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Jeste li sigurni da hocete da izmenite", "Izmena",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.YES_OPTION)
					if (menjaSe != null)
						izmeniKorisnika();
					else
						JOptionPane.showMessageDialog(null, "Bilo bi lepo kada bio izabran lekar");
			}
		});
		add(btnIzmeni, BorderLayout.SOUTH);

	}

	protected void izmeniKorisnika() {
		menjaSe.setIme(textField_5.getText().strip() + "");
		menjaSe.setPrezime(textField_4.getText().strip() + "");
		menjaSe.setJmbg(textField_3.getText().strip() + "");
		if (radioButton_1.isSelected())
			menjaSe.setPol(true);
		else
			menjaSe.setPol(false);
		menjaSe.setAdresa(textField_2.getText().strip() + "");
		menjaSe.setBrojTelefona(textField_1.getText().strip() + "");
		menjaSe.setIzabraniLekarId(((Lekar) comboBox_1.getSelectedItem()).getId());

		try {
			DataStore.izmeni(menjaSe);
			JOptionPane.showMessageDialog(null, "Uspesno ste izmenili");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greska pri izmeni "+e.getMessage());
		}

	}

	protected void ucitajPacijenta() {
		menjaSe = ((Pacijent) (comboBox.getSelectedItem()));
		textField_5.setText(menjaSe.getIme() + "");
		textField_4.setText(menjaSe.getPrezime() + "");
		textField_3.setText(menjaSe.getJmbg() + "");
		if (menjaSe.isPol())
			radioButton_1.setSelected(true);
		else
			radioButton.setSelected(true);
		textField_2.setText(menjaSe.getAdresa() + "");
		textField_1.setText(menjaSe.getBrojTelefona() + "");
		try {
			comboBox_1.setSelectedItem(DataStore.lekari.values().stream().map(i -> (Lekar) i)
					.filter(l -> l.getId() == menjaSe.getIzabraniLekarId()).findFirst().get());
		} catch (Exception e) {
			comboBox_1.setSelectedIndex(-1);
		}

	}

}
