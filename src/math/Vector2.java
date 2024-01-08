package math;


public class Vector2 {

	public double x = 0;
	public double y = 0;
	
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// Returns a scalar
	public static double getCrossProduct(Vector2 vec1, Vector2 vec2) {
		double scalar = vec1.x * vec2.y - vec1.y * vec2.x;
		return scalar;
	}
	
	public static boolean isInTriangle(Vector2 v1, Vector2 v2, Vector2 v3, Vector2 point) {
		Vector2 v1v2 = new Vector2(v2.x - v1.x, v2.y - v1.y);
		Vector2 v1v3 = new Vector2(v3.x - v1.x, v3.y - v1.y);
		Vector2 v1Point = new Vector2(point.x - v2.x, point.y - v1.y);
		
		double v1v2Crossv1v3 = Vector2.getCrossProduct(v1v2, v1v3);
		double v1v2Crossv1Point = Vector2.getCrossProduct(v1v2, v1Point);
		
		return v1v2Crossv1v3 * v1v2Crossv1Point >= 0;
	}
}
