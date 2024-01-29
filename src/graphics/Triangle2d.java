package graphics;

import math.*;

public class Triangle2d {
	
	Vector2 vertex1;
	Vector2 vertex2;
	Vector2 vertex3;	
	
	public Triangle2d(Vector2 vert1, Vector2 vert2, Vector2 vert3) {
		vertex1 = vert1;
		vertex2 = vert2;
		vertex3 = vert3;
	}

	public int getOrient() {
		Vector2 v1v2 = new Vector2(vertex2.x - vertex1.x, vertex2.y - vertex1.y);
		Vector2 v1v3 = new Vector2(vertex3.x - vertex1.x, vertex3.y - vertex1.y);
		double cross = Vector2.getCrossProduct(v1v2, v1v3);
		
		if (cross > 0) {
			return 1;
		}
		return -1;
	}
	
	public boolean containsPoint(Vector2 point) {
		Triangle2d subTri1 = new Triangle2d((Vector2) vertex1, (Vector2) vertex2, point);
		Triangle2d subTri2 = new Triangle2d((Vector2) vertex2, (Vector2) vertex3, point);
		Triangle2d subTri3 = new Triangle2d((Vector2) vertex3, (Vector2) vertex1, point);
		
		int turns = Math.abs(subTri1.getOrient() + subTri2.getOrient() + subTri3.getOrient());
		
		boolean insideTriangle = turns == 3;
		
		return insideTriangle;
	}
}
