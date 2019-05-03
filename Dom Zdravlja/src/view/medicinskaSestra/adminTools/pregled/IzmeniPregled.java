package view.medicinskaSestra.adminTools.pregled;

import java.awt.BorderLayout;
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
import controller.Miscellaneous;
import model.Lekar;
import model.Pacijent;
import model.Pregled;
import model.Soba;
import model.StatusPregleda;
import model.Termin;

@SuppressWarnings("serial")
public class IzmeniPregled extends JPanel {
	private JTextField textField;
	private JTextArea textArea;
	private JComboBox<Pacijent> comboBox_1;
	private JButton btnProveri;
	private JComboBox<Lekar> comboBox_2;
	private JComboBox<Soba> comboBox_3;
	private JComboBox<StatusPregleda> comboBox_4;
	private JComboBox<Pregled> comboBox;
	private Pregled menjaSe = null;

	/**
	 * Create the panel.
	 */
	public IzmeniPregled() {
		setBorder(new TitledBorder(null, "Izmeni Pregled", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Jeste li sigurni da hocete da izmenite", "Izmena",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.YES_OPTION)
					if (menjaSe != null)
						izmeniPregled();
			}
		});
		add(btnIzmeni, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		comboBox = new JComboBox<Pregled>(
				new DefaultComboBoxModel<Pregled>(DataStore.pregledi.values().toArray(Pregled[]::new)));
		comboBox.setSelectedIndex(-1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ucitajPregled();
			}
		});
		panel.add(comboBox);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel label = new JLabel("Pacijent: ");
		label.setBounds(10, 15, 100, 14);
		panel_1.add(label);

		JLabel label_1 = new JLabel("Lekar: ");
		label_1.setBounds(10, 40, 100, 14);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("Vreme Pocetka: ");
		label_2.setBounds(10, 90, 100, 14);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("Soba: ");
		label_3.setBounds(10, 65, 100, 14);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("Opis: ");
		label_4.setBounds(10, 140, 100, 14);
		panel_1.add(label_4);

		JLabel label_5 = new JLabel("Status: ");
		label_5.setBounds(10, 115, 100, 14);
		panel_1.add(label_5);

		comboBox_1 = new JComboBox<Pacijent>(
				new DefaultComboBoxModel<Pacijent>(DataStore.pacijenti.values().toArray(Pacijent[]::new)));

		comboBox_1.setBounds(120, 11, 378, 22);
		panel_1.add(comboBox_1);

		comboBox_2 = new JComboBox<Lekar>(
				new DefaultComboBoxModel<Lekar>(DataStore.lekari.values().toArray(Lekar[]::new)));
		comboBox_2.setSelectedIndex(-1);
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox_2.getSelectedIndex() != -1) {
					comboBox_3.setModel(new DefaultComboBoxModel<Soba>(DataStore.sobe
							.values().stream().filter(i -> ((Soba) i)
									.getIdDomaZdravlja() == ((Lekar) comboBox_2.getSelectedItem()).getDomZdravljaId())
							.toArray(Soba[]::new)));
					comboBox_3.setEnabled(true);
					textField.setEnabled(true);
					btnProveri.setEnabled(true);

				} else {
					comboBox_3.setEnabled(false);
					textField.setEnabled(false);
					btnProveri.setEnabled(false);
				}
			}
		});

		comboBox_2.setBounds(120, 36, 378, 22);
		panel_1.add(comboBox_2);

		comboBox_3 = new JComboBox<Soba>();
		comboBox_3.setEnabled(false);
		comboBox_3.setBounds(120, 61, 378, 22);
		panel_1.add(comboBox_3);

		comboBox_4 = new JComboBox<StatusPregleda>(new DefaultComboBoxModel<StatusPregleda>(StatusPregleda.values()));
		comboBox_4.setBounds(120, 111, 378, 22);
		panel_1.add(comboBox_4);

		textArea = new JTextArea();
		textArea.setBounds(120, 135, 378, 145);
		panel_1.add(textArea);

		textField = new JTextField();
		textField.setToolTipText("HH:MM dd-mm-yyyy");
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(120, 87, 161, 20);
		panel_1.add(textField);

		btnProveri = new JButton("Proveri");
		btnProveri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Miscellaneous.validateDateTime(textField.getText().strip()))
					JOptionPane.showMessageDialog(null, "Termin ispravan");
				else
					JOptionPane.showMessageDialog(null, "Termin neispravan");

			}
		});
		btnProveri.setEnabled(false);
		btnProveri.setBounds(291, 86, 89, 23);
		panel_1.add(btnProveri);

	}

	protected void izmeniPregled() {
		menjaSe.setPacijentId(((Pacijent)(comboBox_1.getSelectedItem())).getId());
		menjaSe.setLekarId(((Lekar)(comboBox_2.getSelectedItem())).getId());
		menjaSe.setSobaId(((Soba)(comboBox_3.getSelectedItem())).getId());
		menjaSe.setOpis(textArea.getText().strip());
		menjaSe.setStatus((StatusPregleda)(comboBox_4.getSelectedItem()));
		if (Miscellaneous.validateDateTime(textField.getText().strip())) {
			var dejt = LocalDateTime.parse(textField.getText().strip(), DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"));
			menjaSe.setTermin(new Termin(dejt, dejt.plusMinutes(15)));
			try {
				DataStore.izmeni(menjaSe);
				JOptionPane.showMessageDialog(null, "Uspesna Izmena");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Neuspesna Izmena");
			}
			
		} else
			JOptionPane.showMessageDialog(null, "Neispravan datum");
		
	}

	protected void ucitajPregled() {
		menjaSe = (Pregled) comboBox.getSelectedItem();
		try {
			comboBox_1.setSelectedItem(DataStore.pacijenti.values().stream()
					.filter(i -> i.getId() == menjaSe.getPacijentId()).findFirst().get());
			comboBox_2.setSelectedItem(DataStore.lekari.values().stream().filter(i -> i.getId() == menjaSe.getLekarId())
					.findFirst().get());
			comboBox_3.setSelectedItem(DataStore.sobe.values().stream().filter(i -> i.getId() == menjaSe.getSobaId()));
			textField.setText(
					menjaSe.getTermin().getVremePocetka().format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")));
			comboBox_4.setSelectedItem(menjaSe.getStatus());
			textArea.setText(menjaSe.getOpis());
		} catch (Exception e) {

		}

	}

	protected JTextArea getTextArea() {
		return textArea;
	}

	protected JComboBox<Pacijent> getComboBox_1() {
		return comboBox_1;
	}

	protected JButton getButton() {
		return btnProveri;
	}

	protected JComboBox<Lekar> getComboBox_2() {
		return comboBox_2;
	}

	protected JTextField getTextField() {
		return textField;
	}

	protected JComboBox<Soba> getComboBox_3() {
		return comboBox_3;
	}

	protected JComboBox<StatusPregleda> getComboBox_4() {
		return comboBox_4;
	}

	protected JComboBox<Pregled> getComboBox() {
		return comboBox;
	}
}
