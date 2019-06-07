package view.medicinskaSestra;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MedicinskaSestraMenuTab extends JPanel {
	public JButton btnIzadji;
	public JButton btnSviPregledi;
	public JButton btnZakaziNoviPregled;
	public JButton btnPrikaziSveRacune;
	public JButton btnOdjaviSe;
	public JButton btnZakaziZatrazenPregled;

	/**
	 * Create the panel.
	 */
	public MedicinskaSestraMenuTab() {
		setLayout(new MigLayout("fill", "[33%][][33%]", "[16%][16%][16%][16%][16%][16%]"));
		
		var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		var minPanelSize = new Dimension(screenSize.width/5, screenSize.height/5);
		this.setMinimumSize(minPanelSize);
		
		btnZakaziNoviPregled = new JButton("Zakazi Novi Pregled");
		btnZakaziNoviPregled.setHorizontalTextPosition(SwingConstants.CENTER);
		btnZakaziNoviPregled.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnZakaziNoviPregled.setIcon(new ImageIcon(MedicinskaSestraMenuTab.class.getResource("/view/icons/baseline_add_circle_outline_black_18dp.png")));
		add(btnZakaziNoviPregled, "cell 0 0 1 2, grow");
		
		btnPrikaziSveRacune = new JButton("Prikazi Sve Racune");
		btnPrikaziSveRacune.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPrikaziSveRacune.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPrikaziSveRacune.setIcon(new ImageIcon(MedicinskaSestraMenuTab.class.getResource("/view/icons/baseline_view_list_black_18dp.png")));
		add(btnPrikaziSveRacune, "cell 1 0 1 6, grow");
		
		btnOdjaviSe = new JButton("Odjavi se");
		btnOdjaviSe.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOdjaviSe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnOdjaviSe.setIcon(new ImageIcon(MedicinskaSestraMenuTab.class.getResource("/view/icons/sharp_face_black_18dp.png")));
		add(btnOdjaviSe, "cell 2 0 1 3, grow");
		
		btnZakaziZatrazenPregled = new JButton("Zakazi Zatrazen Pregled");
		btnZakaziZatrazenPregled.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnZakaziZatrazenPregled.setHorizontalTextPosition(SwingConstants.CENTER);
		btnZakaziZatrazenPregled.setIcon(new ImageIcon(MedicinskaSestraMenuTab.class.getResource("/view/icons/baseline_calendar_today_black_18dp.png")));
		add(btnZakaziZatrazenPregled, "cell 0 2 1 2, grow");
		
		btnIzadji = new JButton("Izadji");
		btnIzadji.setIcon(new ImageIcon(MedicinskaSestraMenuTab.class.getResource("/view/icons/baseline_exit_to_app_black_18dp.png")));
		btnIzadji.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIzadji.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(btnIzadji, "cell 2 3 1 3, grow");
		
		btnSviPregledi = new JButton("Svi Pregledi");
		btnSviPregledi.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSviPregledi.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSviPregledi.setIcon(new ImageIcon(MedicinskaSestraMenuTab.class.getResource("/view/icons/baseline_view_list_black_18dp.png")));
		add(btnSviPregledi, "cell 0 4 1 2, grow");

	}

	
}
