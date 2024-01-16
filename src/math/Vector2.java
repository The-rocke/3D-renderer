package math;


public class Vector2 extends Vector {
	
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
		this.z = 0;
	}
	
	public static Vector2 subtract(Vector2 v1, Vector2 v2) {
		Vector2 result = new Vector2(v1.x - v2.x, v1.y - v2.y);
		return result;
	}
	
	// Returns a scalar
	public static double getCrossProduct(Vector2 vec1, Vector2 vec2) {
		double scalar = vec1.x * vec2.y - vec1.y * vec2.x;
		return scalar;
	}
}
