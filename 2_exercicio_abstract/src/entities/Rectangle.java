package entities;

import entities.enums.Color;

public class Rectangle extends Shape {
	private Double width;
	private Double Height;

	
	
	public Rectangle(Color color, Double width, Double height) {
		super(color);
		this.width = width;
		Height = height;
	}



	@Override
	public Double area() {

		return width * Height;
	}
	
	
}
