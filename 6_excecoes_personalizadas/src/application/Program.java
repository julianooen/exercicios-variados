package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();

		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkin = LocalDate.from(dtf.parse(sc.next()));

		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkout = LocalDate.from(dtf.parse(sc.next()));

		if (ChronoUnit.DAYS.between(checkin, checkout) < 1) {
			System.out.println("Error in reservation: Check-out date must be after Check-in date");
		} else {

			Reservation reserva = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reserva);
			System.out.println("");

			System.out.println("Enter data to update reservation: ");

			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.from(dtf.parse(sc.next()));

			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.from(dtf.parse(sc.next()));

			LocalDate now = LocalDate.now();

			if (checkin.isAfter(checkout)) {
				System.out.println("Error in reservation: Check-out date must be after Check-in date");
			} else if (checkin.isBefore(now) || checkout.isBefore(now)) {
				System.out.println("Error in reservation: Reservation dates for updates must be future date");
			} else {

				reserva.updateDates(checkin, checkout);
				System.out.println(reserva);
			}
		}

		sc.close();
	}

}
