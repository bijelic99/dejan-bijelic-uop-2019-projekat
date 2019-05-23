package view.medicinskaSestra.racun;

import javax.swing.JPanel;

import controller.DataStore;
import model.Pregled;
import model.Racun;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class RacunPanel extends JPanel {
	private Racun racun;
	private Pregled pregled;
	private JLabel lblCena_2;
	private JLabel lblNazivSobe_1;
	private JLabel lblImeIPrezime_1;
	private JLabel lblLekarImeI_1;
	private JLabel lblTerminOdDo_1;
	private JLabel lblOpis_2;

	/**
	 * Create the panel.
	 */
	public RacunPanel(Racun r) {
		this.racun = r;
		this.pregled = (Pregled) DataStore.pregledi.get(r.getPregledId());
		setLayout(new MigLayout("fillx", "[][][][][]", "[][][][][][][][][]"));

		JLabel lblPacijent = new JLabel("Pacijent:");
		add(lblPacijent, "cell 0 0");

		JLabel lblImeIPrezime = new JLabel(DataStore.pacijenti.get(pregled.getPacijentId()).toString());
		add(lblImeIPrezime, "cell 1 0 4 1");

		JLabel lblLekar = new JLabel("Lekar:");
		add(lblLekar, "cell 0 1");

		JLabel lblLekarImeI = new JLabel(DataStore.lekari.get(pregled.getLekarId()).toString());
		add(lblLekarImeI, "cell 1 1 4 1");

		JLabel lblTermin = new JLabel("Termin:");
		add(lblTermin, "cell 0 2");

		JLabel lblTerminOdDo = new JLabel(pregled.getTermin().toString());
		add(lblTerminOdDo, "cell 1 2 4 1");

		JLabel lblSoba = new JLabel("Soba:");
		add(lblSoba, "cell 0 3");

		JLabel lblNazivSobe = new JLabel(DataStore.sobe.get(pregled.getSobaId()).toString());
		add(lblNazivSobe, "cell 1 3 4 1");

		JLabel lblOpis = new JLabel("Opis:");
		add(lblOpis, "cell 0 4");

		JLabel lblOpis_1 = new JLabel(pregled.getOpis());
		add(lblOpis_1, "cell 1 4 4 4, ay top, ax left");

		JLabel lblCena = new JLabel("Cena:");
		add(lblCena, "cell 0 8");

		JLabel lblCena_1 = new JLabel(racun.getCena() + "");
		add(lblCena_1, "cell 1 8");

	}

	public RacunPanel() {

		setLayout(new MigLayout("fillx", "[][][][][]", "[][][][][][][][][]"));

		JLabel lblPacijent = new JLabel("Pacijent:");
		add(lblPacijent, "cell 0 0");

		lblImeIPrezime_1 = new JLabel("");
		add(lblImeIPrezime_1, "cell 1 0 4 1");

		JLabel lblLekar = new JLabel("Lekar:");
		add(lblLekar, "cell 0 1");

		lblLekarImeI_1 = new JLabel("");
		add(lblLekarImeI_1, "cell 1 1 4 1");

		JLabel lblTermin = new JLabel("Termin:");
		add(lblTermin, "cell 0 2");

		lblTerminOdDo_1 = new JLabel("");
		add(lblTerminOdDo_1, "cell 1 2 4 1");

		JLabel lblSoba = new JLabel("Soba:");
		add(lblSoba, "cell 0 3");

		lblNazivSobe_1 = new JLabel("");
		add(lblNazivSobe_1, "cell 1 3 4 1");

		JLabel lblOpis = new JLabel("Opis:");
		add(lblOpis, "cell 0 4");

		lblOpis_2 = new JLabel("");
		add(lblOpis_2, "cell 1 4 4 4, ay top, ax left");

		JLabel lblCena = new JLabel("Cena:");
		add(lblCena, "cell 0 8");

		lblCena_2 = new JLabel("");
		add(lblCena_2, "cell 1 8");

	}

	public JLabel getLblCena_1() {
		return lblCena_2;
	}

	public JLabel getLblNazivSobe() {
		return lblNazivSobe_1;
	}

	public JLabel getLblImeIPrezime() {
		return lblImeIPrezime_1;
	}

	public JLabel getLblLekarImeI() {
		return lblLekarImeI_1;
	}

	public JLabel getLblTerminOdDo() {
		return lblTerminOdDo_1;
	}

	public JLabel getLblOpis_1() {
		return lblOpis_2;
	}

	public void setRacun(Racun r) {
		/*
		 * private JLabel lblCena_2; private JLabel lblNazivSobe_1; private JLabel
		 * lblImeIPrezime_1; private JLabel lblLekarImeI_1; private JLabel
		 * lblTerminOdDo_1; private JLabel lblOpis_2;
		 */
		this.racun = r;
		this.pregled = (Pregled) DataStore.pregledi.get(r.getPregledId());
		lblCena_2.setText(racun.getCena()+"");
		lblNazivSobe_1.setText(DataStore.sobe.get(pregled.getSobaId()).toString());
		lblImeIPrezime_1.setText(DataStore.pacijenti.get(pregled.getPacijentId()).toString());
		lblLekarImeI_1.setText(DataStore.lekari.get(pregled.getLekarId()).toString());
		lblTerminOdDo_1.setText(pregled.getTermin().toString());
		lblOpis_2.setText(pregled.getOpis());

	}
}
