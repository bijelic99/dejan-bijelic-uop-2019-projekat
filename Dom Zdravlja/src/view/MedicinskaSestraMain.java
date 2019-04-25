package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MedicinskaSestraMain {

	private JFrame frmPocetniProzorSestra;

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
		frmPocetniProzorSestra.setBounds(100, 100, 450, 300);
		frmPocetniProzorSestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPocetniProzorSestra.setVisible(true);
	}

}
