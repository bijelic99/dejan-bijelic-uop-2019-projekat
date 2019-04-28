package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import model.CreateFromStringInterface;
import model.Identifiable;

public interface DAOInterface {

	public static String dataFolderPath = "./data/";

	public static String zdravstvenaKnjizicaPath = dataFolderPath + "zdravstvenaKnjizica.txt";
	public static String sobaPath = dataFolderPath + "soba.txt";
	public static String racunPath = dataFolderPath + "racun.txt";
	public static String pregledPath = dataFolderPath + "pregled.txt";
	public static String pacijentPath = dataFolderPath + "pacijent.txt";
	public static String medicinskaSestraPath = dataFolderPath + "medicinskaSestra.txt";
	public static String lekarPath = dataFolderPath + "lekar.txt";
	public static String domZdravljaPath = dataFolderPath + "domZdravlja.txt";
	public static String domZdravljaSluzbaPath = dataFolderPath + "domZdravljaSluzba.txt";
	
	public static boolean dodaj(Identifiable object, String path) {
		var file = new File(path);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file, true));
			writer.append(object.WriteToString());
			writer.newLine();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		} finally {
			try {
				writer.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				return false;
			}

		}
		return true;

	}

	public static boolean izmeni(Identifiable object, String path) {

		var original = new File(path);
		var temp = new File(path + "temp");

		BufferedReader reader = null;
		BufferedWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(original));
			writer = new BufferedWriter(new FileWriter(temp, true));
			String line = "";
			while ((line = reader.readLine()) != null) {
				if (object.getId() == getIdFromString(line)) {
					writer.write(object.WriteToString());
					writer.newLine();
				} else {
					writer.write(line);
					writer.newLine();
				}
			}

			reader.close();
			writer.close();
			original.delete();
			temp.renameTo(new File(path));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		} 

		return true;
	}

	public static boolean obrisi(Identifiable object, String path) {
		var original = new File(path);
		var temp = new File(path + "temp");

		BufferedReader reader = null;
		BufferedWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(original));
			writer = new BufferedWriter(new FileWriter(temp, true));
			String line = "";
			while ((line = reader.readLine()) != null) {
				if (object.getId() != getIdFromString(line)) {
					writer.write(line);
					writer.newLine();
				}
			}
			reader.close();
			writer.close();
			original.delete();
			temp.renameTo(new File(path));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}

		return true;
	}

	public static HashMap<Integer,Identifiable> ucitajSve(CreateFromStringInterface createFromString, String path) {
		var mapa = new HashMap<Integer,Identifiable>();
		var file = new File(path);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line ="";
			while((line = reader.readLine()) != null  ) {
				if(!line.equals("")) {
				line = line.replace("\n", "");
				var object = createFromString.CreateFromString(line);
				mapa.put(object.getId(), object);}
			}
			
			reader.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}
		return mapa;
	}

	public static Identifiable ucitaj(int id, CreateFromStringInterface createFromString, String path) {
		Identifiable i = null;
		var file = new File(path);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line ="";
			while((line = reader.readLine()) != null) {
				if(id == getIdFromString(line)) {
					line = line.replace("\n", "");
					i = createFromString.CreateFromString(line);
					reader.close();
					return i;
				}
			}
			
			reader.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}
		return null;
	}

	public static int getIdFromString(String text) throws NumberFormatException {
		int id = 0;
		String[] a = text.split("\\|");
		id = Integer.parseInt(a[0]);
		return id;
	}

}
