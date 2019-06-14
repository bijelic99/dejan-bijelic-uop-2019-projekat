package view.medicinskaSestra.adminTools.lekar;

import java.awt.BorderLayout;
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
import model.DomZdravlja;
import model.Lekar;
import model.Sluzba;
import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IzmeniLekara extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton radioButton_1;
	private JRadioButton radioButton;
	private JComboBox<DomZdravlja> comboBox_1;
	private JComboBox<Sluzba> comboBox_2;
	private JComboBox<Lekar> comboBox;

	private Lekar menjaSe = null;

	/**
	 * Create the panel.
	 */
	public IzmeniLekara() {
		setBorder(new TitledBorder(null, "Izmeni Lekara", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		comboBox = new JComboBox<Lekar>(
				new DefaultComboBoxModel<Lekar>(DataStore.lekari.values().toArray(Lekar[]::new)));
		comboBox.setSelectedIndex(-1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ucitajLekara();
			}
		});
		panel.add(comboBox);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("fillx", "[left][left, fill][][][]"));

		JLabel label = new JLabel("Ime: ");
		label.setBounds(10, 14, 108, 14);
		panel_1.add(label);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(128, 11, 300, 20);
		panel_1.add(textField, "span 4, wrap");

		JLabel label_1 = new JLabel("Prezime: ");
		label_1.setBounds(10, 38, 108, 14);
		panel_1.add(label_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 35, 300, 20);
		panel_1.add(textField_1, "span 4, wrap");

		JLabel label_2 = new JLabel("JMBG: ");
		label_2.setBounds(10, 66, 108, 14);
		panel_1.add(label_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 63, 300, 20);
		panel_1.add(textField_2, "span 4, wrap");

		JLabel label_3 = new JLabel("Pol: ");
		label_3.setBounds(10, 94, 108, 14);
		panel_1.add(label_3);

		radioButton = new JRadioButton("Muski");
		buttonGroup.add(radioButton);
		radioButton.setSelected(true);
		radioButton.setBounds(128, 89, 60, 23);
		panel_1.add(radioButton);

		radioButton_1 = new JRadioButton("Zenski");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(190, 89, 109, 23);
		panel_1.add(radioButton_1, "wrap");

		JLabel label_4 = new JLabel("Adresa: ");
		label_4.setBounds(10, 122, 108, 14);
		panel_1.add(label_4);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 119, 300, 20);
		panel_1.add(textField_3, "span 4, wrap");

		JLabel label_5 = new JLabel("Broj Telefona: ");
		label_5.setBounds(10, 153, 108, 14);
		panel_1.add(label_5);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(128, 150, 300, 20);
		panel_1.add(textField_4, "span 4, wrap");

		JLabel label_8 = new JLabel("Plata: ");
		label_8.setBounds(10, 184, 108, 14);
		panel_1.add(label_8);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(128, 181, 300, 20);
		panel_1.add(textField_6, "span 4, wrap");

		JLabel label_9 = new JLabel("Dom Zdravlja: ");
		label_9.setBounds(10, 218, 108, 14);
		panel_1.add(label_9);

		comboBox_1 = new JComboBox<DomZdravlja>(
				new DefaultComboBoxModel<DomZdravlja>(DataStore.domoviZdravlja.values().toArray(DomZdravlja[]::new)));
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				var dz = (DomZdravlja) (comboBox_1.getSelectedItem());
				try {
					comboBox_2.setModel(new DefaultComboBoxModel<Sluzba>(
							dz.getSluzbe().stream().filter(s -> s.isDozvoljenoLekaru()).toArray(Sluzba[]::new)));
				} catch (Exception e2) {

				}

			}
		});
		comboBox_1.setSelectedIndex(-1);
		comboBox_1.setBounds(128, 214, 300, 22);
		panel_1.add(comboBox_1, "span 4, wrap");

		JLabel label_10 = new JLabel("Sluzba: ");
		label_10.setBounds(10, 247, 108, 14);
		panel_1.add(label_10);

		comboBox_2 = new JComboBox<Sluzba>();
		comboBox_2.setSelectedIndex(-1);
		comboBox_2.setBounds(128, 243, 300, 22);
		panel_1.add(comboBox_2, "span 4, wrap");

		JLabel label_11 = new JLabel("Specijalizacija: ");
		label_11.setBounds(10, 279, 108, 14);
		panel_1.add(label_11);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(128, 276, 300, 20);
		panel_1.add(textField_7, "span 4, wrap");

		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Jeste li sigurni da hocete da izmenite", "Izmena",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.YES_OPTION)
					if (menjaSe != null)
						izmeniLekara();

			}
		});
		add(btnIzmeni, BorderLayout.SOUTH);

	}

	protected void izmeniLekara() {
		try {
			menjaSe.setIme(textField.getText().strip() + "");
			menjaSe.setPrezime(textField_1.getText().strip() + "");
			menjaSe.setJmbg(textField_2.getText().strip() + "");
			menjaSe.setPol(radioButton.isSelected());
			menjaSe.setAdresa(textField_3.getText().strip() + "");
			menjaSe.setBrojTelefona(textField_4.getText().strip() + "");
			menjaSe.setPlata(Double.parseDouble(textField_6.getText().strip() + ""));
			menjaSe.setSpecijalizacija(textField_7.getText().strip() + "");
			menjaSe.setDomZdravljaId(((DomZdravlja) comboBox_1.getSelectedItem()).getId());
			menjaSe.setSluzba((Sluzba) comboBox_2.getSelectedItem());

			DataStore.izmeni(menjaSe);
			JOptionPane.showMessageDialog(null, "Uspesna Izmena.");
			view.Utility.resetForm(this);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greska pri izmeni!!!");
		}
		

	}

	protected void ucitajLekara() {
		try {
		menjaSe = (Lekar) (comboBox.getSelectedItem());
		textField.setText(menjaSe.getIme());
		textField_1.setText(menjaSe.getPrezime());
		textField_2.setText(menjaSe.getJmbg());
		if (menjaSe.isPol())
			radioButton.setSelected(true);
		else
			radioButton_1.setSelected(true);
		textField_3.setText(menjaSe.getAdresa());
		textField_4.setText(menjaSe.getBrojTelefona());
		try {
			comboBox_1.setSelectedItem(DataStore.domoviZdravlja.values().stream()
					.filter(d -> d.getId() == menjaSe.getDomZdravljaId()).findFirst().get());

		} catch (Exception e) {
			comboBox_1.setSelectedIndex(-1);
		}
		try {
			comboBox_2.setSelectedItem(menjaSe.getSluzba());
		} catch (Exception e) {
			comboBox_1.setSelectedIndex(-1);
		}

		textField_6.setText(menjaSe.getPlata() + "");

		textField_7.setText(menjaSe.getSpecijalizacija());
		}
		catch(Exception e) {}
	}

}
