package view.pacijent;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PacijentMenuTab extends JPanel {
	public JButton btnZakazi;
	public JButton btnPregledajSve;
	public JButton btnOtkazi;
	public JButton btnPregledajGotove;
	public JButton btnOdjaviSe;
	public JButton btnIzadji;
	public JButton btnIzmeni;

	/**
	 * Create the panel.
	 */
	public PacijentMenuTab() {
		setLayout(new MigLayout("fill", "[20%][20%][20%][20%][20%]", "[][]"));
		
		var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		var minPanelSize = new Dimension(screenSize.width/5, screenSize.height/5);
		this.setMinimumSize(minPanelSize);
		
		btnZakazi = new JButton("Zakazi");
		btnZakazi.setHorizontalTextPosition(SwingConstants.CENTER);
		btnZakazi.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnZakazi.setIcon(new ImageIcon(PacijentMenuTab.class.getResource("/view/icons/baseline_calendar_today_black_18dp.png")));
		add(btnZakazi, "cell 0 0 1 2, grow");
		
		btnOtkazi = new JButton("Otkazi");
		btnOtkazi.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnOtkazi.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOtkazi.setIcon(new ImageIcon(PacijentMenuTab.class.getResource("/view/icons/baseline_highlight_off_black_18dp.png")));
		add(btnOtkazi, "cell 1 0 1 1, grow");
		
		btnPregledajSve = new JButton("Pregledaj Sve");
		btnPregledajSve.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPregledajSve.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPregledajSve.setIcon(new ImageIcon(PacijentMenuTab.class.getResource("/view/icons/baseline_view_list_black_18dp.png")));
		add(btnPregledajSve, "cell 2 0 1 2, grow");
		
		btnPregledajGotove = new JButton("Pregledaj Zakazane");
		btnPregledajGotove.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPregledajGotove.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPregledajGotove.setIcon(new ImageIcon(PacijentMenuTab.class.getResource("/view/icons/baseline_pageview_black_18dp.png")));
		add(btnPregledajGotove, "cell 3 0 1 2,, grow");
		
		btnOdjaviSe = new JButton("Odjavi se");
		btnOdjaviSe.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOdjaviSe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnOdjaviSe.setIcon(new ImageIcon(PacijentMenuTab.class.getResource("/view/icons/sharp_face_black_18dp.png")));
		add(btnOdjaviSe, "cell 4 0, grow");
		
		btnIzmeni = new JButton("Izmeni");
		btnIzmeni.setIcon(new ImageIcon(PacijentMenuTab.class.getResource("/view/icons/baseline_edit_black_18dp.png")));
		btnIzmeni.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnIzmeni.setHorizontalTextPosition(SwingConstants.CENTER);
		
		add(btnIzmeni, "cell 1 1 1 1, grow");
		
		btnIzadji = new JButton("Izadji");
		btnIzadji.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnIzadji.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIzadji.setIcon(new ImageIcon(PacijentMenuTab.class.getResource("/view/icons/baseline_exit_to_app_black_18dp.png")));
		add(btnIzadji, "cell 4 1, grow");

	}

	
	
}
