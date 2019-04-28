package view.medicinskaSestra.adminTools.pacijent;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Miscellaneous;
import model.KategorijaOsiguranja;
import model.ZdravstvenaKnjizica;

@SuppressWarnings("serial")
public class NovaKnjizica extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JComboBox<KategorijaOsiguranja> comboBox;
	private ZdravstvenaKnjizica zdravstvenaKnjizica = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NovaKnjizica dialog = new NovaKnjizica();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NovaKnjizica() {
		setTitle("Zdravstvena Knjizica");
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDatumIstekaddmmyyyy = new JLabel("Datum Isteka(dd-mm-yyyy): ");
		lblDatumIstekaddmmyyyy.setBounds(10, 11, 150, 14);
		contentPanel.add(lblDatumIstekaddmmyyyy);
		
		textField = new JTextField();
		textField.setBounds(170, 8, 254, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblKategorija = new JLabel("Kategorija: ");
		lblKategorija.setBounds(10, 39, 150, 14);
		contentPanel.add(lblKategorija);
		
		comboBox = new JComboBox<KategorijaOsiguranja>();
		DefaultComboBoxModel<KategorijaOsiguranja> dcm = new DefaultComboBoxModel<KategorijaOsiguranja>(KategorijaOsiguranja.values());
		comboBox.setModel(dcm);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(170, 39, 254, 22);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(Miscellaneous.validateDate(textField.getText())) {
							zdravstvenaKnjizica = new ZdravstvenaKnjizica(-5, -5, LocalDate.parse(textField.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy")), (KategorijaOsiguranja)comboBox.getSelectedItem());
							dispose();
						}
						else JOptionPane.showMessageDialog(null, "Nije Ispravan Datum");
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public ZdravstvenaKnjizica getZdravstvenaKnjizica() {
		return zdravstvenaKnjizica;
	}

	public void setZdravstvenaKnjizica(ZdravstvenaKnjizica zdravstvenaKnjizica) {
		this.zdravstvenaKnjizica = zdravstvenaKnjizica;
	}
}
