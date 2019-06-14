package view.medicinskaSestra.adminTools.pacijent;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.DataStore;
import model.Lekar;
import model.Pacijent;
import model.ZdravstvenaKnjizica;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class DodajPacijenta extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup pol = new ButtonGroup();
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox<Lekar> comboBox;
	private JRadioButton rdbtnZenski;
	private JRadioButton rdbtnMuski;
	private JPasswordField passwordField;
	private NovaKnjizica nk = null;
	private ZdravstvenaKnjizica zk = null;

	/**
	 * Create the panel.
	 */
	public DodajPacijenta() {
		setBorder(new TitledBorder(null, "Dodaj Novog Korisnika", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Jeste li sigurni da zelite dodati novog korisnika") == JOptionPane.YES_OPTION)
				dodajNovogPacijenta();
			}
		});
		panel_1.add(btnDodaj, BorderLayout.CENTER);

		JButton btnNapraviKnjizicu = new JButton("Zdravstvena Knjizica");
		btnNapraviKnjizicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] izbor = { "Nova", "Postojeca" };
				var izabran = -2;
				if ((izabran = JOptionPane.showOptionDialog(null, "Izaberite novu ili postojecu knjizicu",
						"Izbor knjizice", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, izbor,
						"Nova")) == 0) {
					
					dodajNovuKnjizicu();
				} else if (izabran == 1) {
					
					dodajPostojecuKnjizicu();
				}

			}
		});
		panel_1.add(btnNapraviKnjizicu, BorderLayout.WEST);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("fillx", "[left][left, fill][][][]"));

		JLabel lblIme = new JLabel("Ime: ");
		lblIme.setBounds(10, 11, 108, 14);
		panel.add(lblIme);

		textField = new JTextField();
		textField.setBounds(128, 8, 300, 20);
		textField.setColumns(10);
		panel.add(textField, "span 4, wrap");

		JLabel lblPrezime = new JLabel("Prezime: ");
		lblPrezime.setBounds(10, 35, 108, 14);
		panel.add(lblPrezime);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 32, 300, 20);
		panel.add(textField_1, "span 4, wrap");

		JLabel lblJmbg = new JLabel("JMBG: ");
		lblJmbg.setBounds(10, 63, 108, 14);
		panel.add(lblJmbg);

		textField_2 = new JTextField();
		lblJmbg.setLabelFor(textField_2);
		textField_2.setColumns(10);
		textField_2.setBounds(128, 60, 300, 20);
		panel.add(textField_2, "span 4, wrap");

		JLabel lblPol = new JLabel("Pol: ");
		lblPol.setBounds(10, 91, 108, 14);
		panel.add(lblPol);

		rdbtnMuski = new JRadioButton("Muski");
		rdbtnMuski.setSelected(true);
		pol.add(rdbtnMuski);
		rdbtnMuski.setBounds(128, 86, 60, 23);
		panel.add(rdbtnMuski);

		rdbtnZenski = new JRadioButton("Zenski");
		pol.add(rdbtnZenski);
		rdbtnZenski.setBounds(190, 86, 109, 23);
		panel.add(rdbtnZenski, "wrap");

		JLabel lblAdresa = new JLabel("Adresa: ");
		lblAdresa.setBounds(10, 119, 108, 14);
		panel.add(lblAdresa);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 116, 300, 20);
		panel.add(textField_3, "span 4, wrap");

		JLabel lblBrojTelefona = new JLabel("Broj Telefona: ");
		lblBrojTelefona.setBounds(10, 150, 108, 14);
		panel.add(lblBrojTelefona);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(128, 147, 300, 20);
		panel.add(textField_4, "span 4, wrap");

		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(10, 181, 108, 14);
		panel.add(lblUsername);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(128, 178, 300, 20);
		panel.add(textField_5, "span 4, wrap");

		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(10, 212, 108, 14);
		panel.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(128, 209, 300, 20);
		panel.add(passwordField, "span 4, wrap");

		JLabel lblIzabraniLekar = new JLabel("Izabrani Lekar: ");
		lblIzabraniLekar.setBounds(10, 243, 108, 14);
		panel.add(lblIzabraniLekar);

		comboBox = new JComboBox<Lekar>();
		DefaultComboBoxModel<Lekar> dcm = new DefaultComboBoxModel<Lekar>(
				DataStore.lekari.values().stream().map(i -> (Lekar) i).toArray(Lekar[]::new));
		comboBox.setModel(dcm);
		comboBox.setBounds(128, 239, 300, 22);
		panel.add(comboBox, "span 4");

	}

	protected void dodajPostojecuKnjizicu() {
		zk = (ZdravstvenaKnjizica)JOptionPane.showInputDialog(null, "Izaberite koju knjizicu zelite", "Izbor Knjizice", JOptionPane.QUESTION_MESSAGE, null, DataStore.zdravstveneKnjizice.values().toArray(ZdravstvenaKnjizica[]::new), null);
		
	}

	protected void dodajNovuKnjizicu() {
		nk = new NovaKnjizica();
		nk.setVisible(true);
		zk = nk.getZdravstvenaKnjizica();
		
	}

	private void dodajNovogPacijenta() {
		if (zk == null) {
			JOptionPane.showMessageDialog(null, "Niste Uneli Knjizicu");
		} else {
			if (!DataStore.checkIfUsernameAvailable(textField_5.getText().strip() + ""))
				JOptionPane.showMessageDialog(null, "Username se vec koristi");
			else {
				if (comboBox.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Izaberite Doktora");
				else {
					var p = new Pacijent();
					p.setIme(textField.getText().strip() + "");
					p.setPrezime(textField_1.getText().strip() + "");
					p.setJmbg(textField_2.getText().strip() + "");
					if (rdbtnMuski.isSelected())
						p.setPol(true);
					else
						p.setPol(false);
					p.setAdresa(textField_3.getText().strip() + "");
					p.setBrojTelefona(textField_4.getText().strip() + "");
					p.setUsername(textField_5.getText().strip() + "");
					p.setPassword(new String(passwordField.getPassword()));
					p.setIzabraniLekarId(((Lekar) (comboBox.getSelectedItem())).getId());
					
					
					DataStore.dodajPacijenta(p, zk);
					JOptionPane.showMessageDialog(null, "Uspesno ste dodali Korisnika");
					view.Utility.resetForm(this);
				}
			}

		}
	}
}
