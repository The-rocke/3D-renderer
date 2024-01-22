package graphics;

import math.*;


public class Triangle {
	
	public Vector vertex1;
	public Vector vertex2;
	public Vector vertex3;
	
	public Triangle(Vector2 vert1, Vector2 vert2, Vector2 vert3) {
		vertex1 = vert1;
		vertex2 = vert2;
		vertex3 = vert3;
	}
	public Triangle(Vector3 vert1, Vector3 vert2, Vector3 vert3) {
		vertex1 = new Vector2(vert1.x, vert1.y);
		vertex2 = new Vector2(vert2.x, vert2.y);
		vertex3 = new Vector2(vert3.x, vert3.y);
	}
	
	public double getMinX() {
		return Math.min(vertex1.x, Math.min(vertex2.x, vertex3.x));
	}
	public double getMaxX() {
		return Math.max(vertex1.x, Math.max(vertex2.x, vertex3.x));
	}
	public double getMinY() {
		return Math.min(vertex1.y, Math.min(vertex2.y, vertex3.y));
	}
	public double getMaxY() {
		return Math.max(vertex1.y, Math.max(vertex2.y, vertex3.y));
	}
	
	public double getWidth() {
		double width = Math.abs(getMaxX() - getMinX());
		return width;
	}
	public double getHeight() {
		double height = Math.abs(getMaxY() - getMinY());
		return height;
	}
}
