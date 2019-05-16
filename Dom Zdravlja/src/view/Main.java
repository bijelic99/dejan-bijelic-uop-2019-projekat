package view;

import javax.swing.UnsupportedLookAndFeelException;

import controller.DataStore;
import controller.Router;

public class Main {

	public static void main(String[] args) {
		try {
			javax.swing.UIManager.setLookAndFeel( javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataStore.initialLoad();
		//System.out.println(DataStore.pacijenti);
		//System.out.println(DataStore.medicinskeSestre);
		//System.out.println(DataStore.lekari);
		Router.userRoute();
		

	}

}
