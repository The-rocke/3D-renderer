package math;

public class VectorUtils {
	
	public static Vector2 subtract(Vector2 v1, Vector2 v2) {
		Vector2 result = new Vector2(v1.x - v2.x, v1.y - v2.y);
		return result;
	}
	
	// Returns a scalar
	public static double getCrossProduct(Vector2 vec1, Vector2 vec2) {
		double scalar = vec1.x * vec2.y - vec1.y * vec2.x;
		return scalar;
	}

	// SPACE CONVERSIONS
	
	// Real to screen space
	public static Vector2 toScreenSpace(Vector3 point, Vector3 eye) {
		double x = (eye.x - point.x) / (eye.z - point.z);
		double y = (eye.y - point.y) / (eye.z - point.z);
		
		 // e.g (-50, -50, 1.5) -> (-50 / 1.5, -50 / 1.5) = (33.3, 33.3)

		return new Vector2(x, y);
	}
	
	// Screen to normal space
	public static Vector2 toNormalSpace(Vector2 point, int canvasWidth, int canvasHeight) {
		int x = (int) (point.x + canvasWidth / 2);
		int y = (int) (canvasHeight / 2 - point.y);
		// (33.3, 33.3) -> (33.3 + 1024/2, 576/2 - 33.3) = (33.3 + 512, 288 - 33.3)
		//                   = (545, 255)
		return new Vector2(x, y);
	}
	
	// Screen space coordinate to raster space
	public static Vector2 toRasterSpace(Vector2 point, int canvasWidth, int canvasHeight) {
		Vector2 normalPoint = VectorUtils.toNormalSpace(point, canvasWidth, canvasHeight);
		
		int rasterX = (int) normalPoint.x * canvasWidth;
		int rasterY = (int) normalPoint.y * canvasHeight;
		if (rasterX == canvasWidth) {
			rasterX--;
		}
		if (rasterY == canvasHeight) {
			rasterY--;
		}
		
		return new Vector2(rasterX, rasterY);
	}
}
