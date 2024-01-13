package graphics.graphics3d;

import java.awt.Color;

import math.Vector3;

public class Cube {
	
	public static Triangle[] createCube() {
		// Front
		Triangle tri1 = new Triangle(
				new Vector3(-50, -50, -1),
				new Vector3(-50, 50, -1),
				new Vector3(50, 50, -1),
				Color.WHITE);
		Triangle tri2 = new Triangle(
				new Vector3(-50, -50, -1),
				new Vector3(50, -50, -1),
				new Vector3(50, 50, -1),
				Color.WHITE);
		// Right face
		Triangle tri3 = new Triangle(
				new Vector3(50, -50, -1.5f),
				new Vector3(50, -50, -1),
				new Vector3(50, 50, -1),
				Color.GREEN);
		Triangle tri4 = new Triangle(
				new Vector3(50, -50, -1.5f),
				new Vector3(50, 50, -1.5f),
				new Vector3(50, 50, -1),
				Color.GREEN);
		// Left face
		Triangle tri5 = new Triangle(
				new Vector3(-50, -50, -1.5f),
				new Vector3(-50, -50, -1),
				new Vector3(-50, 50, -1),
				Color.PINK);
		Triangle tri6 = new Triangle(
				new Vector3(-50, -50, -1.5f),
				new Vector3(-50, 50, -1.5f),
				new Vector3(-50, 50, -1),
				Color.PINK);
		// Up
		Triangle tri7 = new Triangle(
				new Vector3(-50, -50, -1.5f),
				new Vector3(-50, -50, -1),
				new Vector3(50, -50, -1),
				Color.LIGHT_GRAY);
		Triangle tri8 = new Triangle(
				new Vector3(-50, -50, -1.5f),
				new Vector3(50, -50, -1),
				new Vector3(50, -50, -1),
				Color.LIGHT_GRAY);
		// Bottom
		Triangle tri9 = new Triangle(
				new Vector3(-50, 50, -1.5f),
				new Vector3(-50, 50, -1),
				new Vector3(50, 50, -1),
				Color.BLUE);
		Triangle tri10 = new Triangle(
				new Vector3(-50, 50, -1.5f),
				new Vector3(50, 50, -1.5f),
				new Vector3(50, 50, -1),
				Color.CYAN);
		// Back
		Triangle tri11 = new Triangle(
				new Vector3(50, -50, -1.5f),
				new Vector3(50, 50, -1.5f),
				new Vector3(-50, 50, -1.5f),
				Color.DARK_GRAY);
		Triangle tri12 = new Triangle(
				new Vector3(50, -50, -1.5f),
				new Vector3(-50, -50, -1.5f),
				new Vector3(-50, 50, -1.5f),
				Color.GRAY);
		
		Triangle[] mesh = {tri1, tri2, tri3, tri4, tri5, tri6, tri7, tri8, tri9, tri10, tri11, tri12};
		return mesh;
	}
}
