package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TabbedPaneCloser extends JPanel {
	JPanel thisPanel = this;
	JPanel toDisplay = new JPanel();
	
	/**
	 * Create the panel.
	 */
	public TabbedPaneCloser(JPanel toDisplay, String title) {
		this.toDisplay = toDisplay;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((JTabbedPane) thisPanel.getParent()).remove(((JTabbedPane) thisPanel.getParent()).indexOfTab(title));
			}
		});
		panel.add(btnZatvori, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(this.toDisplay, BorderLayout.CENTER);
		add(panel_1, BorderLayout.CENTER);
		

	}

}
