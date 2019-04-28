package view;

import controller.DataStore;
import controller.Router;

public class Main {

	public static void main(String[] args) {
		DataStore.initialLoad();
		//System.out.println(DataStore.pacijenti);
		//System.out.println(DataStore.medicinskeSestre);
		//System.out.println(DataStore.lekari);
		Router.userRoute();
		

	}

}
