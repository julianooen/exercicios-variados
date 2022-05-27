package entities;

import entities.enums.Color;

public abstract class Shape {
	private Color color;
	
	
	public Shape(Color color) {
		super();
		this.color = color;
	}


	public abstract Double area();
}
