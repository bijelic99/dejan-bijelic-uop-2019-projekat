package view;

import javax.swing.JPanel;

import model.Osoba;
import model.Pacijent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class GreetingPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	Osoba o = null;
	
	public GreetingPanel(Osoba o) {
		if(o == null) o = new Pacijent();
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblDobroDosli = new JLabel("Dobrodosli: "+o.getIme()+" "+o.getPrezime());
		lblDobroDosli.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDobroDosli.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblDobroDosli);
		
		JLabel lblUsername = new JLabel("Username: "+o.getUsername());
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblUsername, BorderLayout.SOUTH);

	}
}
