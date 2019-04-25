package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class LekarMain {

	private JFrame frmPocetniProzorLekar;

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
		frmPocetniProzorLekar.setBounds(100, 100, 450, 300);
		frmPocetniProzorLekar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPocetniProzorLekar.setVisible(true);
	}

}
