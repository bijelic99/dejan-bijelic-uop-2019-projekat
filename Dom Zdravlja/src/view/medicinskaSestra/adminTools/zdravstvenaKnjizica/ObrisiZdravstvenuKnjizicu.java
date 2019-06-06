package view.medicinskaSestra.adminTools.zdravstvenaKnjizica;

import javax.swing.JPanel;

import controller.DataStore;
import model.Pacijent;
import model.ZdravstvenaKnjizica;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ObrisiZdravstvenuKnjizicu extends JPanel {
	private JComboBox<ZdravstvenaKnjizica> comboBox;

	/**
	 * Create the panel.
	 */
	public ObrisiZdravstvenuKnjizicu() {
		setLayout(new BorderLayout(0, 0));

		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Jeste li sigurni da zelite obrisati knjizicu?") == JOptionPane.YES_OPTION)
					obrisiKnjizicu();
			}
		});
		add(btnObrisi, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		comboBox = new JComboBox<ZdravstvenaKnjizica>(new DefaultComboBoxModel<ZdravstvenaKnjizica>(
				DataStore.zdravstveneKnjizice.values().toArray(ZdravstvenaKnjizica[]::new)));
		comboBox.setSelectedIndex(-1);
		panel.add(comboBox);

	}

	protected void obrisiKnjizicu() {
		if(comboBox.getSelectedIndex()!= -1) {
			
			try {
				var knjizica = (ZdravstvenaKnjizica)comboBox.getSelectedItem();
				DataStore.pacijenti.values().stream().map(i->(Pacijent)i).filter(p->p.getZdravstvenaKnjizicaId() == knjizica.getId()).forEach(p->{
					p.setZdravstvenaKnjizicaId(-5);
					try {
						DataStore.izmeni(p);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				DataStore.obrisi(knjizica);
				JOptionPane.showMessageDialog(null, "Uspesno!!!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Greska");
			}
		}
		
	}

}
