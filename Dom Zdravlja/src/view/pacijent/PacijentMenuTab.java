package view.pacijent;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PacijentMenuTab extends JPanel {
	public JButton btnZakazi;
	public JButton btnPregledajSve;
	public JButton btnOtkazi;
	public JButton btnPregledajGotove;

	/**
	 * Create the panel.
	 */
	public PacijentMenuTab() {
		setLayout(new MigLayout("fill", "[][][][]", "[]"));
		
		btnZakazi = new JButton("Zakazi");
		btnZakazi.setHorizontalTextPosition(SwingConstants.CENTER);
		btnZakazi.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnZakazi.setIcon(new ImageIcon(PacijentMenuTab.class.getResource("/view/icons/baseline_calendar_today_black_18dp.png")));
		add(btnZakazi, "cell 0 0, grow, width 25%");
		
		btnOtkazi = new JButton("Otkazi");
		btnOtkazi.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnOtkazi.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOtkazi.setIcon(new ImageIcon(PacijentMenuTab.class.getResource("/view/icons/baseline_highlight_off_black_18dp.png")));
		add(btnOtkazi, "cell 1 0, grow, width 25%");
		
		btnPregledajSve = new JButton("Pregledaj Sve");
		btnPregledajSve.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPregledajSve.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPregledajSve.setIcon(new ImageIcon(PacijentMenuTab.class.getResource("/view/icons/baseline_view_list_black_18dp.png")));
		add(btnPregledajSve, "cell 2 0, grow, width 25%");
		
		btnPregledajGotove = new JButton("Pregledaj Zakazane");
		btnPregledajGotove.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPregledajGotove.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPregledajGotove.setIcon(new ImageIcon(PacijentMenuTab.class.getResource("/view/icons/baseline_pageview_black_18dp.png")));
		add(btnPregledajGotove, "cell 3 0, grow, width 25%");

	}

	
}
