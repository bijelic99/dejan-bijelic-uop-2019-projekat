package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import controller.Router;
import view.medicinskaSestra.adminTools.lekar.DodajLekara;
import view.medicinskaSestra.adminTools.lekar.IzmeniLekara;
import view.medicinskaSestra.adminTools.lekar.ObrisiLekara;
import view.medicinskaSestra.adminTools.lekar.PregledajSveLekare;
import view.medicinskaSestra.adminTools.medicinskaSestra.DodajMedicinskuSestru;
import view.medicinskaSestra.adminTools.medicinskaSestra.IzmeniMedicinskuSestru;
import view.medicinskaSestra.adminTools.medicinskaSestra.ObrisiMedicinskuSestru;
import view.medicinskaSestra.adminTools.medicinskaSestra.PregledajSveMedicinskeSestre;
import view.medicinskaSestra.adminTools.pacijent.DodajPacijenta;
import view.medicinskaSestra.adminTools.pacijent.IzmeniPacijenta;
import view.medicinskaSestra.adminTools.pacijent.ObrisiPacijenta;
import view.medicinskaSestra.adminTools.pacijent.PregledajSvePacijente;
import view.medicinskaSestra.adminTools.pregled.DodajPregled;
import view.medicinskaSestra.adminTools.pregled.IzmeniPregled;
import view.medicinskaSestra.adminTools.pregled.ObrisiPregled;
import view.medicinskaSestra.adminTools.pregled.PregledajSvePreglede;
import view.medicinskaSestra.adminTools.zdravstvenaKnjizica.IzmeniZdravstvenuKnjizicu;
import view.medicinskaSestra.adminTools.zdravstvenaKnjizica.PregledajSveZdravstveneKnjizice;
import view.medicinskaSestra.pregledi.ZakaziPregled;
import view.medicinskaSestra.pregledi.ZakaziVecZatrazen;
import view.medicinskaSestra.racun.PrikaziRacun;

public class MedicinskaSestraMain {

	private JFrame frmPocetniProzorSestra;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicinskaSestraMain window = new MedicinskaSestraMain();
					window.frmPocetniProzorSestra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MedicinskaSestraMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPocetniProzorSestra = new JFrame();
		frmPocetniProzorSestra.setTitle("Pocetni Prozor Sestra");
		frmPocetniProzorSestra.setBounds(100, 100, 800, 600);
		frmPocetniProzorSestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPocetniProzorSestra.getContentPane().setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmPocetniProzorSestra.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		frmPocetniProzorSestra.setJMenuBar(menuBar);

		JMenu mnAdminTools = new JMenu("Admin Tools");
		menuBar.add(mnAdminTools);

		JMenu mnPacijent = new JMenu("Pacijent");
		mnAdminTools.add(mnPacijent);

		JMenuItem mntmDodaj = new JMenuItem("Dodaj");
		mntmDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tabbedPane.add("Dodaj Pacijenta", new TabbedPaneCloser(new DodajPacijenta(), "Dodaj Pacijenta"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Dodaj Pacijenta"));

			}
		});
		mnPacijent.add(mntmDodaj);

		JMenuItem mntmIzmeni = new JMenuItem("Izmeni");
		mntmIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Izmeni Pacijenta", new TabbedPaneCloser(new IzmeniPacijenta(), "Izmeni Pacijenta"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Izmeni Pacijenta"));
			}
		});
		mnPacijent.add(mntmIzmeni);

		JMenuItem mntmObrisi = new JMenuItem("Obrisi");
		mntmObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Obrisi Pacijenta", new TabbedPaneCloser(new ObrisiPacijenta(), "Obrisi Pacijenta"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Obrisi Pacijenta"));
			}
		});
		mnPacijent.add(mntmObrisi);

		JMenuItem mntmPregledajSve = new JMenuItem("Pregledaj Sve");
		mntmPregledajSve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tabbedPane.add("Svi Pacijenti", new TabbedPaneCloser(new PregledajSvePacijente(), "Svi Pacijenti"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Svi Pacijenti"));
			}
		});
		mnPacijent.add(mntmPregledajSve);

		JMenu mnLekar = new JMenu("Lekar");
		mnAdminTools.add(mnLekar);

		JMenuItem menuItem = new JMenuItem("Dodaj");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Dodaj Lekara", new TabbedPaneCloser(new DodajLekara(), "Dodaj Lekara"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Dodaj Lekara"));
			}
		});
		mnLekar.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("Izmeni");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Izmeni Lekara", new TabbedPaneCloser(new IzmeniLekara(), "Izmeni Lekara"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Izmeni Lekara"));

			}
		});
		mnLekar.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("Obrisi");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Obrisi Lekara", new TabbedPaneCloser(new ObrisiLekara(), "Obrisi Lekara"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Obrisi Lekara"));
			}
		});
		mnLekar.add(menuItem_2);

		JMenuItem menuItem_12 = new JMenuItem("Pregledaj Sve");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Svi Lekari", new TabbedPaneCloser(new PregledajSveLekare(), "Svi Lekari"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Svi Lekari"));
			}
		});
		mnLekar.add(menuItem_12);

		JMenu mnMedicinskaSestra = new JMenu("Medicinska Sestra");
		mnAdminTools.add(mnMedicinskaSestra);

		JMenuItem menuItem_3 = new JMenuItem("Dodaj");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Nova Medicinska Sestra",
						new TabbedPaneCloser(new DodajMedicinskuSestru(), "Nova Medicinska Sestra"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Nova Medicinska Sestra"));
			}
		});
		mnMedicinskaSestra.add(menuItem_3);

		JMenuItem menuItem_4 = new JMenuItem("Izmeni");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Izmeni Medicinsku Sestru",
						new TabbedPaneCloser(new IzmeniMedicinskuSestru(), "Izmeni Medicinsku Sestru"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Izmeni Medicinsku Sestru"));
			}
		});
		mnMedicinskaSestra.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("Obrisi");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Obrisi Medicinsku Sestru",
						new TabbedPaneCloser(new ObrisiMedicinskuSestru(), "Obrisi Medicinsku Sestru"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Obrisi Medicinsku Sestru"));
			}
		});
		mnMedicinskaSestra.add(menuItem_5);

		JMenuItem menuItem_13 = new JMenuItem("Pregledaj Sve");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Sve Medicinske Sestre",
						new TabbedPaneCloser(new PregledajSveMedicinskeSestre(), "Sve Medicinske Sestre"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Sve Medicinske Sestre"));
			}
		});
		mnMedicinskaSestra.add(menuItem_13);

		JMenu mnZdravstvenaKnjizica = new JMenu("Zdravstvena Knjizica");
		mnAdminTools.add(mnZdravstvenaKnjizica);

		JMenuItem menuItem_17 = new JMenuItem("Izmeni");
		menuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Izmeni Zdravstvenu Knjizicu",
						new TabbedPaneCloser(new IzmeniZdravstvenuKnjizicu(), "Izmeni Zdravstvenu Knjizicu"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Izmeni Zdravstvenu Knjizicu"));
			}
		});
		mnZdravstvenaKnjizica.add(menuItem_17);

		JMenuItem menuItem_19 = new JMenuItem("Pregledaj Sve");
		menuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Pregledaj Zdravstvene Knjizice",
						new TabbedPaneCloser(new PregledajSveZdravstveneKnjizice(), "Pregledaj Zdravstvene Knjizice"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Pregledaj Zdravstvene Knjizice"));
			}
		});
		mnZdravstvenaKnjizica.add(menuItem_19);

		JMenu mnPregled2 = new JMenu("Pregled");
		mnAdminTools.add(mnPregled2);

		JMenuItem menuItem_9 = new JMenuItem("Dodaj");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Dodaj Pregled", new TabbedPaneCloser(new DodajPregled(), "Dodaj Pregled"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Dodaj Pregled"));
			}
		});
		mnPregled2.add(menuItem_9);

		JMenuItem menuItem_10 = new JMenuItem("Izmeni");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Izmeni Pregled", new TabbedPaneCloser(new IzmeniPregled(), "Izmeni Pregled"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Izmeni Pregled"));
			}
		});
		mnPregled2.add(menuItem_10);

		JMenuItem menuItem_11 = new JMenuItem("Obrisi");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Obrisi Pregled", new TabbedPaneCloser(new ObrisiPregled(), "Obrisi Pregled"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Obrisi Pregled"));
			}
		});
		mnPregled2.add(menuItem_11);

		JMenuItem menuItem_15 = new JMenuItem("Pregledaj Sve");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Pregledaj Preglede",
						new TabbedPaneCloser(new PregledajSvePreglede(), "Pregledaj Preglede"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Pregledaj Preglede"));
			}
		});
		mnPregled2.add(menuItem_15);

		JMenu mnDomZdravlja = new JMenu("Dom Zdravlja");
		mnAdminTools.add(mnDomZdravlja);

		JMenuItem menuItem_6 = new JMenuItem("Dodaj");
		mnDomZdravlja.add(menuItem_6);

		JMenuItem menuItem_7 = new JMenuItem("Izmeni");
		mnDomZdravlja.add(menuItem_7);

		JMenuItem menuItem_8 = new JMenuItem("Obrisi");
		mnDomZdravlja.add(menuItem_8);

		JMenuItem menuItem_14 = new JMenuItem("Pregledaj Sve");
		mnDomZdravlja.add(menuItem_14);

		JMenu mnPregled_1 = new JMenu("Pregled");
		menuBar.add(mnPregled_1);
		
		JMenuItem mntmPregledajSve_1 = new JMenuItem("Pregledaj Sve");
		mntmPregledajSve_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Pregledaj Preglede",
						new TabbedPaneCloser(new PregledajSvePreglede(), "Pregledaj Preglede"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Pregledaj Preglede"));
			}
		});
		
		JMenu mnZakazi = new JMenu("Zakazi");
		mnPregled_1.add(mnZakazi);
		
				JMenuItem mntmZakaziNovi = new JMenuItem("Zakazi Novi");
				mnZakazi.add(mntmZakaziNovi);
				
				JMenuItem mntmZakaziVecZatrazen = new JMenuItem("Zakazi Vec Zatrazen");
				mntmZakaziVecZatrazen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tabbedPane.add("Zakazi Zatrazen Pregled", new TabbedPaneCloser(new ZakaziVecZatrazen(), "Zakazi Zatrazen Pregled"));
						tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Zakazi Zatrazen Pregled"));
					}
				});
				mnZakazi.add(mntmZakaziVecZatrazen);
				mntmZakaziNovi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tabbedPane.add("Zakazi Pregled", new TabbedPaneCloser(new ZakaziPregled(), "Zakazi Pregled"));
						tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Zakazi Pregled"));
					}
				});
		mnPregled_1.add(mntmPregledajSve_1);
		
		JMenu mnRacun = new JMenu("Racun");
		menuBar.add(mnRacun);
		
		JMenuItem mntmPrikazi = new JMenuItem("Prikazi");
		mntmPrikazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add("Prikazi Racun", new TabbedPaneCloser(new PrikaziRacun(), "Prikazi Racun"));
				tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Prikazi Racun"));
			}
		});
		mnRacun.add(mntmPrikazi);

		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);

		JMenu mnOther = new JMenu("Other");
		menuBar.add(mnOther);

		JMenuItem mntmOdjaviSe = new JMenuItem("Odjavi se");
		mntmOdjaviSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPocetniProzorSestra.dispose();
				Router.trenutniKorisnik = null;
				Router.userRoute();
			}
		});
		mnOther.add(mntmOdjaviSe);

		JMenuItem mntmIzadji = new JMenuItem("Izadji");
		mntmIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (JOptionPane.showConfirmDialog(null, "Jeste li sigurni da zelite izaci", "Izlaz",
						JOptionPane.YES_NO_OPTION)) {
				case JOptionPane.YES_OPTION:
					System.exit(0);
				default:
					break;
				}
			}
		});
		mnOther.add(mntmIzadji);
		frmPocetniProzorSestra.setVisible(true);

		GreetingPanel gp = new GreetingPanel(controller.Router.trenutniKorisnik);
		var tpc = new TabbedPaneCloser(gp, "Dobrodosli");
		tabbedPane.addTab("Dobrodosli", tpc);

	}
}
