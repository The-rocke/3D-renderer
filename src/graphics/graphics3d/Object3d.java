package graphics.graphics3d;

import java.util.ArrayList;

import graphics.Triangle3d;
import math.Vector3;


public class Object3d {

	public Vector3 position = new Vector3(0d, 0d, 0d);

	public ArrayList<Triangle3d> geometry = new ArrayList<>(0);

	public Object3d(Triangle3d[] faceList) {
		for (Triangle3d face: faceList) {
			geometry.add(face);
		}
	}
	
	public void addFace(Triangle3d newFace) {
		geometry.add(newFace);
	}
	
	public Triangle3d[] getGeometry() {
		Triangle3d[] triangleArray = new Triangle3d[geometry.size()];
		for (int i = 0; i < triangleArray.length; i++) {
			triangleArray[i] = geometry.get(i);
		}
		return triangleArray;
	}
}