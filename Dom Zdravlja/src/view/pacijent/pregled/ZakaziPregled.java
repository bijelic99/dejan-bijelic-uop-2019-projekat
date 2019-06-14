package view.pacijent.pregled;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.DataStore;
import controller.Router;
import model.Pacijent;
import model.Pregled;
import model.StatusPregleda;
import model.TipKorisnika;

import java.awt.BorderLayout;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ZakaziPregled extends JPanel {

	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public ZakaziPregled() {
		setBorder(new TitledBorder(null, "Zakazi Pregled", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		JButton btnZakazi = new JButton("Zakazi");
		add(btnZakazi, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("fillx", "[][grow][][][]", "[][][grow]"));

		JLabel lblPacijent = new JLabel("Pacijent:");
		panel.add(lblPacijent, "cell 0 0");

		JLabel lblImeiprezime = new JLabel("ImeIPrezime");
		panel.add(lblImeiprezime, "cell 1 0 4 1");

		JLabel lblLekar = new JLabel("Lekar:");
		panel.add(lblLekar, "cell 0 1");

		JLabel lblLekarimeiprezime = new JLabel("LekarImeIPrezime");
		panel.add(lblLekarimeiprezime, "cell 1 1 4 1");

		JLabel lblOpis = new JLabel("Opis:");
		panel.add(lblOpis, "cell 0 2");

		textArea = new JTextArea();
		panel.add(textArea, "cell 1 2  4 4,grow");

		if (Router.trenutniKorisnik != null && Router.trenutniKorisnik.getUloga() == TipKorisnika.pacijent) {
			lblImeiprezime.setText(Router.trenutniKorisnik.toString());
			lblLekarimeiprezime.setText(
					DataStore.lekari.get(((Pacijent) Router.trenutniKorisnik).getIzabraniLekarId()).toString());
			btnZakazi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					zakaziPregled();
				}
			});
		}

	}

	protected void zakaziPregled() {
		if (!(textArea.getText().strip().isEmpty())) {
			Pregled p = new Pregled();
			p.setPacijentId(Router.trenutniKorisnik.getId());
			p.setLekarId(((Pacijent) Router.trenutniKorisnik).getIzabraniLekarId());
			p.setOpis(textArea.getText() + "");
			p.setStatus(StatusPregleda.zatrazen);
			try {
				DataStore.dodaj(p);
				JOptionPane.showMessageDialog(null, "Uspesno zakazivanje");
				view.Utility.resetForm(this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Greska pri Zakazivanju!!!");
			}
		}
		else JOptionPane.showMessageDialog(null, "Morate uneti opis!!!");
	}

}
