package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
		frmPacijent.setBounds(100, 100, 450, 300);
		frmPacijent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPacijent.setVisible(true);
	}

}
