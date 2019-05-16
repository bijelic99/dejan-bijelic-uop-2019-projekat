package view.medicinskaSestra.adminTools.lekar;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.DataStore;
import model.DomZdravlja;
import model.Lekar;
import model.Sluzba;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class DodajLekara extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JTextField textField_6;
	private JTextField textField_7;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JComboBox<DomZdravlja> comboBox;
	private JComboBox<Sluzba> comboBox_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public DodajLekara() {
		setBorder(new TitledBorder(null, "Dodaj Lekara", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Jeste li sigurni da zelite dodati novog korisnika?", "Dodavanje novog korinsika", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					dodajKorisnika();
				}
			}
		});
		add(btnDodaj, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("fillx", "[left][left, fill][][][]", "[][][][][][][][][][][]"));
		
		JLabel label = new JLabel("Ime: ");
		label.setBounds(10, 14, 108, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(128, 11, 300, 20);
		panel.add(textField, "span 4, wrap");
		
		JLabel label_1 = new JLabel("Prezime: ");
		label_1.setBounds(10, 38, 108, 14);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 35, 300, 20);
		panel.add(textField_1, "span 4, wrap");
		
		JLabel label_2 = new JLabel("JMBG: ");
		label_2.setBounds(10, 66, 108, 14);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 63, 300, 20);
		panel.add(textField_2, "span 4, wrap");
		
		JLabel label_3 = new JLabel("Pol: ");
		label_3.setBounds(10, 94, 108, 14);
		panel.add(label_3);
		
		radioButton = new JRadioButton("Muski");
		buttonGroup.add(radioButton);
		radioButton.setSelected(true);
		radioButton.setBounds(128, 89, 60, 23);
		panel.add(radioButton);
		
		radioButton_1 = new JRadioButton("Zenski");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(190, 89, 109, 23);
		panel.add(radioButton_1, "wrap");
		
		JLabel label_4 = new JLabel("Adresa: ");
		label_4.setBounds(10, 122, 108, 14);
		panel.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 119, 300, 20);
		panel.add(textField_3, "span 4, wrap");
		
		JLabel label_5 = new JLabel("Broj Telefona: ");
		label_5.setBounds(10, 153, 108, 14);
		panel.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(128, 150, 300, 20);
		panel.add(textField_4, "span 4, wrap");
		
		JLabel label_6 = new JLabel("Username: ");
		label_6.setBounds(10, 184, 108, 14);
		panel.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(128, 181, 300, 20);
		panel.add(textField_5, "span 4, wrap");
		
		JLabel label_7 = new JLabel("Password: ");
		label_7.setBounds(10, 215, 108, 14);
		panel.add(label_7);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 212, 300, 20);
		panel.add(passwordField, "span 4, wrap");
		
		JLabel lblPlata = new JLabel("Plata: ");
		lblPlata.setBounds(10, 243, 108, 14);
		panel.add(lblPlata);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(128, 240, 300, 20);
		panel.add(textField_6, "span 4, wrap");
		
		JLabel lblDomZdravlja = new JLabel("Dom Zdravlja: ");
		lblDomZdravlja.setBounds(10, 277, 108, 14);
		panel.add(lblDomZdravlja);
		
		comboBox = new JComboBox<DomZdravlja>(new DefaultComboBoxModel<DomZdravlja>(DataStore.domoviZdravlja.values().toArray(DomZdravlja[]::new)));
		comboBox.setSelectedIndex(-1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox.getSelectedIndex() != -1) {
					comboBox_1.setModel(new DefaultComboBoxModel<Sluzba>(((DomZdravlja)comboBox.getSelectedItem()).getSluzbe().stream().filter(s->s.isDozvoljenoLekaru()).toArray(Sluzba[]::new)));
					comboBox_1.setEnabled(true);
					comboBox_1.setSelectedIndex(-1);
				}
			}
		});
		comboBox.setBounds(128, 273, 300, 22);
		panel.add(comboBox, "span 4, wrap");
		
		JLabel lblSluzba = new JLabel("Sluzba: ");
		lblSluzba.setBounds(10, 306, 108, 14);
		panel.add(lblSluzba);
		
		comboBox_1 = new JComboBox<Sluzba>();
		comboBox_1.setSelectedIndex(-1);
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(128, 302, 300, 22);
		panel.add(comboBox_1, "span 4, wrap");
		
		JLabel lblSpecijalizacija = new JLabel("Specijalizacija: ");
		lblSpecijalizacija.setBounds(10, 338, 108, 14);
		panel.add(lblSpecijalizacija);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(128, 335, 300, 20);
		panel.add(textField_7, "span 4");
		
		

	}

	protected void dodajKorisnika() {
		if(comboBox.getSelectedIndex() == -1) JOptionPane.showMessageDialog(null, "Izaberite Dom Zdravlja!!!");
		else if(comboBox_1.getSelectedIndex() == -1) JOptionPane.showMessageDialog(null, "Izaberite Sluzbu!!!");
		else if(!DataStore.checkIfUsernameAvailable(textField_5.getText().strip()+"")) JOptionPane.showMessageDialog(null, "Username Zauzet!!!");
		else {
			try {
			var l = new Lekar();
			l.setIme(textField.getText().strip()+"");
			l.setPrezime(textField_1.getText().strip()+"");
			l.setJmbg(textField_2.getText().strip()+"");
			l.setPol(radioButton.isSelected());
			l.setAdresa(textField_3.getText().strip()+"");
			l.setBrojTelefona(textField_4.getText().strip()+"");
			l.setUsername(textField_5.getText().strip()+"");
			l.setPassword(new String(passwordField.getPassword())+"");
			l.setPlata(Double.parseDouble(textField_6.getText().strip()+""));
			l.setSpecijalizacija(textField_7.getText().strip()+"");
			l.setDomZdravljaId(((DomZdravlja)comboBox.getSelectedItem()).getId());
			l.setSluzba((Sluzba)comboBox_1.getSelectedItem());
			DataStore.dodaj(l);
			JOptionPane.showMessageDialog(null, "Uspesno ste dodali novog lekara");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Greska pri dodavanju novog korisnika");
			}
		}
		
	}
}
