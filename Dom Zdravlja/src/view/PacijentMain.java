package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;

import controller.Router;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PacijentMain {

	private JFrame frmPacijent;

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
		
		JMenu mnPregledi = new JMenu("Pregledi");
		menuBar.add(mnPregledi);
		
		JMenuItem mntmZakazi = new JMenuItem("Zakazi");
		mnPregledi.add(mntmZakazi);
		
		JMenuItem mntmOtkazi = new JMenuItem("Otkazi");
		mnPregledi.add(mntmOtkazi);

		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);

		JMenu mnOther = new JMenu("Other");
		menuBar.add(mnOther);

		JMenuItem mntmOdjaviSe = new JMenuItem("Odjavi Se");
		mntmOdjaviSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPacijent.dispose();
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

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmPacijent.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		frmPacijent.setVisible(true);

		GreetingPanel gp = new GreetingPanel(controller.Router.trenutniKorisnik);
		tabbedPane.addTab("Dobro dosli", gp);
	}

}
