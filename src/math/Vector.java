package math;


public class Vector {
	
	// SPACE CONVERSIONS
	
	// Real to screen space
	public static Vector2 toScreenSpace(Vector3 point, Vector3 eye) {
		double x = (point.x - eye.x) / (point.z - eye.z);
		double y = (point.y - eye.y) / (point.z - eye.z);
		
		 // e.g (-50, -50, 1.5) -> (-50 / 1.5, -50 / 1.5) = (33.3, 33.3)

		return new Vector2(x, y);
	}
	
	// Screen to normal space
	public static Vector2 toNormalSpace(Vector2 point, int canvasWidth, int canvasHeight) {
		double x = (point.x + canvasWidth / 2);
		double y = (canvasHeight / 2 - point.y);
		// (33.3, 33.3) -> (33.3 + 1024/2, 576/2 - 33.3) = (33.3 + 512, 288 - 33.3)
		//                   = (545, 255)
		return new Vector2(x, y);
	}
	
	// Screen space coordinate to raster space
	public static Vector2 toRasterSpace(Vector2 point, int canvasWidth, int canvasHeight) {
		Vector2 normalPoint = Vector.toNormalSpace(point, canvasWidth, canvasHeight);
		
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
