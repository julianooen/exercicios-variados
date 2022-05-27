package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Shape> listShape = new ArrayList<>();

		System.out.print("Enter the number of shapes: ");
		int numberShapes = sc.nextInt();

		for (int i = 1; i <= numberShapes; i++) {

			System.out.println("Shape #" + i + " data:");

			System.out.print("Rectangle or Circle (r/c)? ");
			String formType = sc.next();

			System.out.print("Color (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(sc.next());

			if (formType.equals("r")) {

				System.out.print("Width: ");
				Double width = sc.nextDouble();

				System.out.print("Height: ");
				Double height = sc.nextDouble();

				listShape.add(new Rectangle(color, width, height));

			} else if (formType.equals("c")) {

				System.out.print("Radius: ");
				Double radius = sc.nextDouble();

				listShape.add(new Circle(color, radius));
			}
		}

		System.out.println("");
		System.out.println("SHAPE AREAS:");

		for (Shape elemento : listShape) {
			System.out.println(elemento.area());
		}
	}

}
