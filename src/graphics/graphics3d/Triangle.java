package graphics.graphics3d;

import java.awt.Color;

import math.Vector3;


public class Triangle {

	public Vector3 vertex1;
	public Vector3 vertex2;
	public Vector3 vertex3;
	
	public Color color = Color.WHITE;
	
	public Triangle(Vector3 vert1, Vector3 vert2, Vector3 vert3, Color color) {
		vertex1 = vert1;
		vertex2 = vert2;
		vertex3 = vert3;
		
		this.color = color;
	}
}
