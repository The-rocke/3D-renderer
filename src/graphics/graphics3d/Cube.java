package graphics.graphics3d;

import java.awt.Color;

import graphics.Triangle3d;
import math.Vector3;

public class Cube {
	
	public static Triangle3d[] createCube() {
		// Front
		Triangle3d tri1 = new Triangle3d(
				new Vector3(-50, -50, -1),
				new Vector3(-50, 50, -1),
				new Vector3(50, 50, -1),
				0,
				Color.WHITE);
		Triangle3d tri2 = new Triangle3d(
				new Vector3(-50, -50, -1),
				new Vector3(50, -50, -1),
				new Vector3(50, 50, -1),
				0,
				Color.WHITE);
		// Right face
		Triangle3d tri3 = new Triangle3d(
				new Vector3(50, -50, -1.5f),
				new Vector3(50, -50, -1),
				new Vector3(50, 50, -1),
				0,
				Color.GREEN);
		Triangle3d tri4 = new Triangle3d(
				new Vector3(50, -50, -1.5f),
				new Vector3(50, 50, -1.5f),
				new Vector3(50, 50, -1),
				0,
				Color.GREEN);
		// Left face
		Triangle3d tri5 = new Triangle3d(
				new Vector3(-50, -50, -1.5f),
				new Vector3(-50, -50, -1),
				new Vector3(-50, 50, -1),
				0,
				Color.CYAN);
		Triangle3d tri6 = new Triangle3d(
				new Vector3(-50, -50, -1.5f),
				new Vector3(-50, 50, -1.5f),
				new Vector3(-50, 50, -1),
				0,
				Color.CYAN);
		// Up
		Triangle3d tri7 = new Triangle3d(
				new Vector3(-50, -50, -1.5f),
				new Vector3(-50, -50, -1),
				new Vector3(50, -50, -1),
				0,
				Color.PINK);
		Triangle3d tri8 = new Triangle3d(
				new Vector3(-50, -50, -1.5f),
				new Vector3(50, -50, -1.5f),
				new Vector3(50, -50, -1),
				0,
				Color.PINK);
		// Bottom
		Triangle3d tri9 = new Triangle3d(
				new Vector3(-50, 50, -1.5f),
				new Vector3(-50, 50, -1),
				new Vector3(50, 50, -1),
				0,
				Color.MAGENTA);
		Triangle3d tri10 = new Triangle3d(
				new Vector3(-50, 50, -1.5f),
				new Vector3(50, 50, -1.5f),
				new Vector3(50, 50, -1),
				0,
				Color.MAGENTA);
		// Back
		Triangle3d tri11 = new Triangle3d(
				new Vector3(50, -50, -1.5f),
				new Vector3(50, 50, -1.5f),
				new Vector3(-50, 50, -1.5f),
				0,
				Color.ORANGE);
		Triangle3d tri12 = new Triangle3d(
				new Vector3(50, -50, -1.5f),
				new Vector3(-50, -50, -1.5f),
				new Vector3(-50, 50, -1.5f),
				0,
				Color.ORANGE);
		
		Triangle3d[] mesh = {tri1, tri2, tri3, tri4, tri5, tri6, tri7, tri8, tri9, tri10, tri11, tri12};
		return mesh;
	}
}
