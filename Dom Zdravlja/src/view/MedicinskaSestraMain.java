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
				tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex()+1);
				
			}
		});
		mnPacijent.add(mntmDodaj);
		
		JMenuItem mntmIzmeni = new JMenuItem("Izmeni");
		mnPacijent.add(mntmIzmeni);
		
		JMenuItem mntmObrisi = new JMenuItem("Obrisi");
		mnPacijent.add(mntmObrisi);
		
		JMenuItem mntmPregledajSve = new JMenuItem("Pregledaj Sve");
		mntmPregledajSve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.add("Svi Pacijenti", new TabbedPaneCloser(new PregledajSvePacijente(), "Svi Pacijenti"));
				tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex()+1);
			}
		});
		mnPacijent.add(mntmPregledajSve);
		
		JMenu mnLekar = new JMenu("Lekar");
		mnAdminTools.add(mnLekar);
		
		JMenuItem menuItem = new JMenuItem("Dodaj");
		mnLekar.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Izmeni");
		mnLekar.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Obrisi");
		mnLekar.add(menuItem_2);
		
		JMenuItem menuItem_12 = new JMenuItem("Pregledaj Sve");
		mnLekar.add(menuItem_12);
		
		JMenu mnMedicinskaSestra = new JMenu("Medicinska Sestra");
		mnAdminTools.add(mnMedicinskaSestra);
		
		JMenuItem menuItem_3 = new JMenuItem("Dodaj");
		mnMedicinskaSestra.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Izmeni");
		mnMedicinskaSestra.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Obrisi");
		mnMedicinskaSestra.add(menuItem_5);
		
		JMenuItem menuItem_13 = new JMenuItem("Pregledaj Sve");
		mnMedicinskaSestra.add(menuItem_13);
		
		JMenu mnDomoviZdravlja = new JMenu("Domovi Zdravlja");
		mnAdminTools.add(mnDomoviZdravlja);
		
		JMenuItem menuItem_6 = new JMenuItem("Dodaj");
		mnDomoviZdravlja.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("Izmeni");
		mnDomoviZdravlja.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("Obrisi");
		mnDomoviZdravlja.add(menuItem_8);
		
		JMenuItem menuItem_14 = new JMenuItem("Pregledaj Sve");
		mnDomoviZdravlja.add(menuItem_14);
		
		JMenu mnPregledi = new JMenu("Pregledi");
		mnAdminTools.add(mnPregledi);
		
		JMenuItem menuItem_9 = new JMenuItem("Dodaj");
		mnPregledi.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("Izmeni");
		mnPregledi.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("Obrisi");
		mnPregledi.add(menuItem_11);
		
		JMenuItem menuItem_15 = new JMenuItem("Pregledaj Sve");
		mnPregledi.add(menuItem_15);
		
		JMenu mnPregledi_1 = new JMenu("Pregledi");
		menuBar.add(mnPregledi_1);
		
		JMenuItem mntmZakazi = new JMenuItem("Zakazi");
		mnPregledi_1.add(mntmZakazi);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		JMenu mnOther = new JMenu("Other");
		menuBar.add(mnOther);
		
		JMenuItem mntmOdjaviSe = new JMenuItem("Odjavi se");
		mntmOdjaviSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPocetniProzorSestra.dispose();
				Router.trenutniKorisnik=null;
				Router.userRoute();
			}
		});
		mnOther.add(mntmOdjaviSe);
		
		JMenuItem mntmIzadji = new JMenuItem("Izadji");
		mntmIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(JOptionPane.showConfirmDialog(null, "Jeste li sigurni da zelite izaci", "Izlaz", JOptionPane.YES_NO_OPTION)){
				case JOptionPane.YES_OPTION: System.exit(0);
				default: break;
				}
			}
		});
		mnOther.add(mntmIzadji);
		frmPocetniProzorSestra.setVisible(true);
		
		GreetingPanel gp = new GreetingPanel(controller.Router.trenutniKorisnik);
		tabbedPane.addTab("Dobro dosli", gp);
		
	}
}
