package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();

			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkin = LocalDate.from(dtf.parse(sc.next()));

			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkout = LocalDate.from(dtf.parse(sc.next()));

			Reservation reserva = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reserva);

			System.out.println();
			System.out.println("Enter data to update reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.from(dtf.parse(sc.next()));
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.from(dtf.parse(sc.next()));

			reserva.updateDates(checkin, checkout);
			System.out.println(reserva);
		} catch (DateTimeParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();
	}

}
