package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	private static DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) throws DomainException {
		super();
		if (checkin.isAfter(checkout)) {
			throw new DomainException("Check-out date must be after Check-in date");
		}

		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public long duration() {
		return ChronoUnit.DAYS.between(checkin, checkout);
	}

	public void updateDates(LocalDate checkin, LocalDate checkout) throws DomainException {
		LocalDate now = LocalDate.now();
		if (checkin.isAfter(checkout)) {
			throw new DomainException("Check-out date must be after Check-in date");
		}
		if (checkin.isBefore(now) || checkout.isBefore(now)) {
			throw new DomainException("Reservation dates for updates must be future date");
		}

		setCheckin(checkin);
		setCheckout(checkout);

	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	private void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	private void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Reservation: Room " + this.roomNumber + ", Check-in: " + sdf.format(checkin) + ", Check-out: "
				+ sdf.format(checkout) + ", " + duration() + " nights";
	}

}
