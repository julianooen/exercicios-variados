package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Reservation teste = new Reservation(1, LocalDate.from(dtf.parse("01/04/2000")), LocalDate.from(dtf.parse("01/05/2000")));
		
		System.out.println(teste);
	}

}
