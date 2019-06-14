package view;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface Utility {
	public static void resetForm(JPanel panel) {
		for (Component component : panel.getComponents()) {
			if (component instanceof JTextField)
				((JTextField) component).setText("");

			else if(component instanceof JTextArea)
				((JTextArea) component).setText("");

			else if(component instanceof JComboBox<?>)
				((JComboBox<?>) component).setSelectedIndex(-1);
			else if(component instanceof JPanel) resetForm((JPanel)component);

		}
	}

}
