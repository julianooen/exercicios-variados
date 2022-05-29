package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) throws DomainException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			System.out.println();

			Account cliente1 = new Account(number, holder, balance, withdrawLimit);

			System.out.print("Enter amount for withdraw: ");
			Double withdraw = sc.nextDouble();
			cliente1.withDraw(withdraw);

			System.out.println("New balance: " + cliente1.getBalance());
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
