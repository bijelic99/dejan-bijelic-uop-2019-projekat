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
import view.lekar.LekarMenuTab;
import view.lekar.zakazaniPregledi.OtkaziPregled;
import view.lekar.zakazaniPregledi.PregledajPacijenta;
import view.lekar.zakazaniPregledi.PregledajZakazanePreglede;

public class LekarMain {

	private JFrame frmPocetniProzorLekar;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LekarMain window = new LekarMain();
					window.frmPocetniProzorLekar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LekarMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPocetniProzorLekar = new JFrame();
		frmPocetniProzorLekar.setTitle("Pocetni Prozor Lekar");
		frmPocetniProzorLekar.setBounds(100, 100, 800, 600);
		frmPocetniProzorLekar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmPocetniProzorLekar.setJMenuBar(menuBar);

		JMenu mnZakazaniPregledi = new JMenu("Zakazani Pregledi");
		menuBar.add(mnZakazaniPregledi);

		JMenuItem mntmPregledaj = new JMenuItem("Pregledaj");
		mntmPregledaj.addActionListener(this::pregledajPacijenta);
		mnZakazaniPregledi.add(mntmPregledaj);

		JMenuItem mntmOtkazi = new JMenuItem("Otkazi");
		mntmOtkazi.addActionListener(this::otkaziPregled);
		mnZakazaniPregledi.add(mntmOtkazi);

		JMenuItem mntmPregledajZakazane = new JMenuItem("Pregledaj Zakazane");
		mntmPregledajZakazane.addActionListener(this::pregledajZakazanePreglede);
		mnZakazaniPregledi.add(mntmPregledajZakazane);

		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);

		JMenu mnOther = new JMenu("Other");
		menuBar.add(mnOther);

		JMenuItem mntmOdjaviSe = new JMenuItem("Odjavi se");
		mntmOdjaviSe.addActionListener(this::odjava);
		mnOther.add(mntmOdjaviSe);

		JMenuItem mntmIzadji = new JMenuItem("Izadji");
		mntmIzadji.addActionListener(this::izlaz);
		mnOther.add(mntmIzadji);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmPocetniProzorLekar.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		frmPocetniProzorLekar.setVisible(true);

		GreetingPanel gp = new GreetingPanel(controller.Router.trenutniKorisnik);
		var tpc = new TabbedPaneCloser(gp, "Dobrodosli");
		tabbedPane.addTab("Dobrodosli", tpc);
		tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Dobrodosli"));

		var mainMenu = new LekarMenuTab();
		mainMenu.btnPregledajZakazane.addActionListener(this::pregledajZakazanePreglede);
		mainMenu.btnOtkaziPregled.addActionListener(this::otkaziPregled);
		mainMenu.btnPregledajPacijenta.addActionListener(this::pregledajPacijenta);
		mainMenu.btnOdjaviSe.addActionListener(this::odjava);
		mainMenu.btnIzadji.addActionListener(this::izlaz);
		tabbedPane.addTab("Main Menu", null, mainMenu, null);
	}

	public void odjava(ActionEvent e) {
		if (JOptionPane.showConfirmDialog(null,
				"Jeste li sigurni da zelite da se odjavite?", "Odjava",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			frmPocetniProzorLekar.dispose();
			Router.trenutniKorisnik = null;
			Router.userRoute();
		}
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

	public void pregledajPacijenta(ActionEvent e) {
		tabbedPane.add("Pregledaj pacijenta",
				new TabbedPaneCloser(new PregledajPacijenta(), "Pregledaj pacijenta"));
		tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Pregledaj pacijenta"));
	}

	public void otkaziPregled(ActionEvent e) {
		tabbedPane.add("Otkazi pregled",
				new TabbedPaneCloser(new OtkaziPregled(), "Otkazi pregled"));
		tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Otkazi pregled"));
	}
	
	public void pregledajZakazanePreglede(ActionEvent e) {
		tabbedPane.add("Zakazani pregledi",
				new TabbedPaneCloser(new PregledajZakazanePreglede(), "Zakazani pregledi"));
		tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Zakazani pregledi"));
	}
	
	

}
