package view.lekar;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LekarMenuTab extends JPanel {
	public JButton btnPregledajZakazane;
	public JButton btnOdjaviSe;
	public JButton btnOtkaziPregled;
	public JButton btnIzadji;
	public JButton btnPregledajPacijenta;

	/**
	 * Create the panel.
	 */
	public LekarMenuTab() {
		setLayout(new MigLayout("fill", "[33%][33%][33%]", "[][]"));
		
		var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		var minPanelSize = new Dimension(screenSize.width/5, screenSize.height/5);
		this.setMinimumSize(minPanelSize);
		
		btnPregledajPacijenta = new JButton("Pregledaj Pacijenta");
		btnPregledajPacijenta.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPregledajPacijenta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPregledajPacijenta.setIcon(new ImageIcon(LekarMenuTab.class.getResource("/view/icons/baseline_accessibility_new_black_18dp.png")));
		add(btnPregledajPacijenta, "cell 0 0, grow");
		
		btnPregledajZakazane = new JButton("Pregledaj Zakazane");
		btnPregledajZakazane.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPregledajZakazane.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPregledajZakazane.setIcon(new ImageIcon(LekarMenuTab.class.getResource("/view/icons/baseline_pageview_black_18dp.png")));
		add(btnPregledajZakazane, "cell 1 0 1 2, grow");
		
		btnOtkaziPregled = new JButton("Otkazi Pregled");
		btnOtkaziPregled.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnOtkaziPregled.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOtkaziPregled.setIcon(new ImageIcon(LekarMenuTab.class.getResource("/view/icons/baseline_highlight_off_black_18dp.png")));
		add(btnOtkaziPregled, "cell 0 1, grow");
		
		btnOdjaviSe = new JButton("Odjavi Se");
		btnOdjaviSe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnOdjaviSe.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOdjaviSe.setIcon(new ImageIcon(LekarMenuTab.class.getResource("/view/icons/sharp_face_black_18dp.png")));
		add(btnOdjaviSe, "cell 2 0, grow");
		
		btnIzadji = new JButton("Izadji");
		btnIzadji.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnIzadji.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIzadji.setIcon(new ImageIcon(LekarMenuTab.class.getResource("/view/icons/baseline_exit_to_app_black_18dp.png")));
		add(btnIzadji, "cell 2 1, grow");
		
	}

	
}
