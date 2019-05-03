package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Miscellaneous {
	public static boolean validateDate(String text) {
		try {
			LocalDate.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static boolean validateDateTime(String text) {
		try {
			LocalDateTime.parse(text, DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"));
			
			} catch (Exception e) {
			return false;
		}
		return true;
	}
}
