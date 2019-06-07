package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TabbedPaneCloser extends JPanel {
	JPanel thisPanel = this;
	JPanel toDisplay; 
	
	/**
	 * Create the panel.
	 */
	public TabbedPaneCloser() {
		this.toDisplay = new JPanel();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					((JTabbedPane) thisPanel.getParent()).remove(((JTabbedPane) thisPanel.getParent()).indexOfTab("NoName"));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				
			}
		});
		panel.add(btnZatvori, BorderLayout.EAST);
		
		JScrollPane panel_1 = new JScrollPane();
		var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		var minPanelSize = new Dimension(screenSize.width/5, screenSize.height/5);
		this.toDisplay.setMinimumSize(minPanelSize);
		panel_1.setViewportView(this.toDisplay);
		add(panel_1, BorderLayout.CENTER);
		

	}
	
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
		
		JScrollPane panel_1 = new JScrollPane();
		panel_1.setViewportView(this.toDisplay);
		add(panel_1, BorderLayout.CENTER);
		

	}

}
