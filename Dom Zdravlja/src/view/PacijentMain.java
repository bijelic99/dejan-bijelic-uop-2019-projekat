package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import controller.Router;
import view.pacijent.PacijentMenuTab;
import view.pacijent.pregled.OtkaziPregled;
import view.pacijent.pregled.Pregledaj;
import view.pacijent.pregled.ZakaziPregled;

public class PacijentMain {

	private JFrame frmPacijent;
	private JTabbedPane tabbedPane;
	private JMenuItem mntmPregledajGotove;
	private JMenuItem mntmPregledajSve;
	private JMenuItem mntmZakazi;
	private JMenuItem mntmOtkazi;
	private PacijentMenuTab pmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacijentMain window = new PacijentMain();
					window.frmPacijent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PacijentMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPacijent = new JFrame();
		frmPacijent.setTitle("Pacijent");
		frmPacijent.setBounds(100, 100, 800, 600);
		frmPacijent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmPacijent.setJMenuBar(menuBar);

		JMenu mnPregledi = new JMenu("Pregled");
		menuBar.add(mnPregledi);

		mntmZakazi = new JMenuItem("Zakazi");
		mnPregledi.add(mntmZakazi);

		mntmOtkazi = new JMenuItem("Otkazi");
		mnPregledi.add(mntmOtkazi);

		mntmPregledajSve = new JMenuItem("Pregledaj Sve");
		mnPregledi.add(mntmPregledajSve);

		mntmPregledajGotove = new JMenuItem("Pregledaj Zakazane");
		mnPregledi.add(mntmPregledajGotove);

		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);

		JMenu mnOther = new JMenu("Other");
		menuBar.add(mnOther);

		JMenuItem mntmOdjaviSe = new JMenuItem("Odjavi Se");
		mntmOdjaviSe.addActionListener(this::odjava);
		mnOther.add(mntmOdjaviSe);

		JMenuItem mntmIzadji = new JMenuItem("Izadji");
		mntmIzadji.addActionListener(this::izlaz);
		mnOther.add(mntmIzadji);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmPacijent.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		frmPacijent.setVisible(true);

		GreetingPanel gp = new GreetingPanel(controller.Router.trenutniKorisnik);
		var tpc = new TabbedPaneCloser(gp, "Dobrodosli");
		tabbedPane.addTab("Dobrodosli", tpc);
		
		

		pmt = new PacijentMenuTab();
		tabbedPane.addTab("Main Menu", null, pmt, null);
		pmt.btnIzadji.addActionListener(this::izlaz);
		pmt.btnOdjaviSe.addActionListener(this::odjava);

		dodajAkcije();
	}

	private void dodajAkcije() {
		mntmZakazi.addActionListener(this::zakaziProzor);
		pmt.btnZakazi.addActionListener(this::zakaziProzor);

		mntmOtkazi.addActionListener(this::otkaziProzor);
		pmt.btnOtkazi.addActionListener(this::otkaziProzor);

		mntmPregledajSve.addActionListener(this::pregledajProzor);
		pmt.btnPregledajSve.addActionListener(this::pregledajProzor);

		mntmPregledajGotove.addActionListener(this::pregledajZakazaneProzor);
		pmt.btnPregledajGotove.addActionListener(this::pregledajZakazaneProzor);

	}

	private void zakaziProzor(ActionEvent e) {

		var zakaziPregled = new ZakaziPregled();
		var tpc = new TabbedPaneCloser(zakaziPregled, "Zakazi Pregled");
		tabbedPane.addTab("Zakazi Pregled", tpc);
		tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Zakazi Pregled"));

	}

	private void otkaziProzor(ActionEvent e) {

		var otkaziPregled = new OtkaziPregled();
		var tpc = new TabbedPaneCloser(otkaziPregled, "Otkazi Pregled");
		tabbedPane.addTab("Otkazi Pregled", tpc);
		tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Otkazi Pregled"));

	}

	private void pregledajProzor(ActionEvent e) {
		var pregledaj = new Pregledaj(false);
		var tpc = new TabbedPaneCloser(pregledaj, "Vidi sve preglede");
		tabbedPane.addTab("Vidi sve preglede", tpc);
		tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Vidi sve preglede"));
	}

	private void pregledajZakazaneProzor(ActionEvent e) {
		var pregledaj = new Pregledaj(true);
		var tpc = new TabbedPaneCloser(pregledaj, "Vidi zakazane preglede");
		tabbedPane.addTab("Vidi zakazane preglede", tpc);
		tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Vidi zakazane preglede"));
	}

	public void odjava(ActionEvent e) {
		frmPacijent.dispose();
		Router.trenutniKorisnik = null;
		Router.userRoute();
	}

	public void izlaz(ActionEvent e) {
		switch (JOptionPane.showConfirmDialog(null, "Jeste li sigurni da zelite izaci", "Izlaz",
				JOptionPane.YES_NO_OPTION)) {
		case JOptionPane.YES_OPTION:
			System.exit(0);
		default:
			break;
		}
	}
}
