package com.trainingapps.canvasapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Canvas {

	@Autowired
	private Rectangle rectangle;

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	public void drawShape() {
		int area=rectangle.getLength()*rectangle.getBreadth();
		System.out.println("area drawn="+area);
	}
	
}
