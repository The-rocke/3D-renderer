package graphics.graphics3d;

import java.util.ArrayList;
import math.Vector3;


public class Object3d {

	Vector3 position = new Vector3(0d, 0d, 0d);

	public ArrayList<Triangle> geometry = new ArrayList<Triangle>(0);

	public Object3d(Triangle[] faceList) {
		for (Triangle face: faceList) {
			geometry.add(face);
		}
	}
	
	public void addFace(Triangle newFace) {
		geometry.add(newFace);
	}
	
	public Triangle[] getGeometry() {
		Triangle[] triangleArray = new Triangle[geometry.size()];
		for (int i = 0; i < triangleArray.length; i++) {
			triangleArray[i] = geometry.get(i);
		}
		return triangleArray;
	}
}