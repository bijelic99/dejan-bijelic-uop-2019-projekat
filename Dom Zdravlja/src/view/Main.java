package view;

import controller.Router;
import localDataStore.DataStore;

public class Main {

	public static void main(String[] args) {
		DataStore.initialLoad();
		Router.userRoute();
		

	}

}
