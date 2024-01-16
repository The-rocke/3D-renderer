package graphics.graphics3d;

import java.awt.Color;

import math.Vector3;


public class Triangle {

	public Vector3 vertex1;
	public Vector3 vertex2;
	public Vector3 vertex3;
	
	public int renderPriority;
	public Color color = Color.WHITE;
	
	public Triangle(Vector3 vert1, Vector3 vert2, Vector3 vert3, int renderPriority, Color color) {
		vertex1 = vert1;
		vertex2 = vert2;
		vertex3 = vert3;
		
		this.renderPriority = renderPriority;
		this.color = color;
	}
	
	// Gets average distance from the eye
	public double getMeanZ(Vector3 eye) {
		double v1Distance = eye.z - vertex1.z;
		double v2Distance = eye.z - vertex2.z;
		double v3Distance = eye.z - vertex3.z;
		
		double mean = (v1Distance + v2Distance + v3Distance) / 3;
		
		return mean;
	}
}
