package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		List<Product> listProduct = new ArrayList<>();
		System.out.print("Enter the number of products: ");
		int qty = sc.nextInt();

		for (int i = 1; i <= qty; i++) {
			System.out.println("Product #" + qty + " data:");

			System.out.print("Common, used or imported (c/u/i)? ");
			String typeP = sc.next();

			System.out.print("Name: ");
			String name = sc.next();

			System.out.print("Price: ");
			Double price = sc.nextDouble();

			if (typeP.equals("c")) {

				listProduct.add(new Product(name, price));

			} else if (typeP.equals("u")) {

				System.out.print("Manufacture date (DD/MM/YYYY): ");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				TemporalAccessor date = dtf.parse(sc.next());
				listProduct.add(new UsedProduct(name, price, LocalDate.from(date)));

			} else if (typeP.equals("i")) {

				System.out.print("Customs fee: ");
				Double fee = sc.nextDouble();
				listProduct.add(new ImportedProduct(name, price, fee));

			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product elemento:listProduct) {

			System.out.println(elemento.priceTag());
		}
		
		
	}
}
