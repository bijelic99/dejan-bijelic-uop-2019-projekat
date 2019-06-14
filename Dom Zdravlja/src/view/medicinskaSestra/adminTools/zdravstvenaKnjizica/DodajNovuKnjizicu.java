package view.medicinskaSestra.adminTools.zdravstvenaKnjizica;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.DataStore;
import model.KategorijaOsiguranja;
import model.Pacijent;
import model.ZdravstvenaKnjizica;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DodajNovuKnjizicu extends JPanel {
	private JTextField textField;
	private JComboBox<Pacijent> comboBox;
	private JComboBox<KategorijaOsiguranja> comboBox_1;

	/**
	 * Create the panel.
	 */
	public DodajNovuKnjizicu() {
		setLayout(new BorderLayout(0, 0));
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Jeste li sigurni da zelite dodati knjizicu") == JOptionPane.YES_OPTION) dodajKnjizicu();
			}
		});
		add(btnDodaj, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("fillx", "[left][grow,left,fill][][][]", "[][][]"));
		
		JLabel lblPacijent = new JLabel("Pacijent: ");
		panel.add(lblPacijent, "cell 0 0,alignx trailing");
		
		comboBox = new JComboBox<Pacijent>(new DefaultComboBoxModel<Pacijent>(DataStore.pacijenti.values().toArray(Pacijent[]::new)));
		panel.add(comboBox, "cell 1 0 4 1,growx");
		
		JLabel label = new JLabel("Vreme Isteka:");
		panel.add(label, "cell 0 1,alignx trailing");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 1 4 1,growx");
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("Kategorija: ");
		panel.add(label_1, "cell 0 2,alignx trailing");
		
		comboBox_1 = new JComboBox<KategorijaOsiguranja>(new DefaultComboBoxModel<KategorijaOsiguranja>(KategorijaOsiguranja.values()));
		panel.add(comboBox_1, "cell 1 2 4 1,growx");

	}

	protected void dodajKnjizicu() {
		if(comboBox.getSelectedIndex() != -1 && comboBox_1.getSelectedIndex() != -1) {
		
		try {
			
			var pacijent = (Pacijent)comboBox.getSelectedItem();
			var datumIsteka = LocalDate.parse(textField.getText().strip(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			var kategorijaOsiguranja = (KategorijaOsiguranja)comboBox_1.getSelectedItem();
			var zdravstvenaKnjizica = new ZdravstvenaKnjizica(-5, pacijent.getId(), datumIsteka, kategorijaOsiguranja);
			
			DataStore.dodajNovuZdravstvenuKnjizicu(zdravstvenaKnjizica);
			JOptionPane.showMessageDialog(null, "Uspesno ste dodali");
			view.Utility.resetForm(this);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nije dobar format datuma");
		}
		}
		else JOptionPane.showMessageDialog(null, "Greska");
	}


}
