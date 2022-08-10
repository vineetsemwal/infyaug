package com.trainingapps.canvasapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CanvasApplication {

	public static void main(String[] args) {
	ApplicationContext context	=SpringApplication.run(CanvasApplication.class, args);
	Canvas canvas=context.getBean(Canvas.class);
	canvas.drawShape();
	}

}
