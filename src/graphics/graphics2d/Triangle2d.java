package graphics.graphics2d;

import java.awt.Color;

import math.Vector2;
import math.VectorUtils;

public class Triangle2d {

	public Vector2 vertex1;
	public Vector2 vertex2;
	public Vector2 vertex3;
	
	public Triangle2d(Vector2 vert1, Vector2 vert2, Vector2 vert3) {
		vertex1 = vert1;
		vertex2 = vert2;
		vertex3 = vert3;
	}
	
	public double getArea() {
		double area = VectorUtils.getCrossProduct(VectorUtils.subtract(vertex2, vertex1),
				VectorUtils.subtract(vertex3, vertex1)) / 2;
		return area;
	}
	public int getOrient() {
		Vector2 v1v2 = new Vector2(vertex2.x - vertex1.x, vertex2.y - vertex1.y);
		Vector2 v1v3 = new Vector2(vertex3.x - vertex1.x, vertex3.y - vertex1.y);
		double cross = VectorUtils.getCrossProduct(v1v2, v1v3);
		
		if (cross > 0) {
			return 1;
		}
		return -1;
	}
	
	public boolean containsPoint(Vector2 point) {
		//Vector2 vertex1vertex2 = new Vector2(vertex2.x - vertex1.x, vertex2.y - vertex1.y);
		//Vector2 vertex1vertex3 = new Vector2(vertex3.x - vertex1.x, vertex3.y - vertex1.y);
		//Vector2 vertex1Point = new Vector2(point.x - vertex2.x, point.y - vertex1.y);
		
		//double vertex1vertex2Crossvertex1vertex3 = VectorUtils.getCrossProduct(vertex1vertex2, vertex1vertex3);
		//double vertex1vertex2Crossvertex1Point = VectorUtils.getCrossProduct(vertex1vertex2, vertex1Point);
		
		//boolean insideTriangle = vertex1vertex2Crossvertex1vertex3 * vertex1vertex2Crossvertex1Point >= 0;
		//System.out.println(insideTriangle);
		
		//int triangleArea = (int) getArea();
		
		Triangle2d subTri1 = new Triangle2d(vertex1, vertex2, point);
		Triangle2d subTri2 = new Triangle2d(vertex2, vertex3, point);
		Triangle2d subTri3 = new Triangle2d(vertex3, vertex1, point);
		
		int turns = Math.abs(subTri1.getOrient() + subTri2.getOrient() + subTri3.getOrient());
		
		boolean insideTriangle = turns == 3;
		
		return insideTriangle;
	}
}
