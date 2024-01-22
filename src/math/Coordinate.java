package math;

import graphics.Triangle;


public class Coordinate {
	
	public static Vector2 pointOnTriangle(Vector2 pixel, Triangle screenTriangle, Triangle triangle) {
		int pixelsFromLeft = (int) (pixel.x - screenTriangle.getMinX());
		int pixelsFromTop = (int) (pixel.y - screenTriangle.getMinY());
		double xDistPerPixel = screenTriangle.getWidth() / triangle.getWidth();
		double yDistPerPixel = screenTriangle.getHeight() / triangle.getHeight();
		
		double x = pixelsFromLeft * xDistPerPixel;
		double y = pixelsFromTop * yDistPerPixel;

		return new Vector2(x, y);
	}
	
	// Real to screen space
	public static Vector2 toScreenSpace(Vector3 point, Vector3 eye) {
		double x = (eye.x - point.x) / (eye.z - point.z);
		double y = (eye.y - point.y) / (eye.z - point.z);		
		 // e.g (-50, -50, 1.5) -> (-50 / 1.5, -50 / 1.5) = (33.3, 33.3)

		return new Vector2(x, y);
	}
	
	// Screen to normal space
	public static Vector2 toRasterSpace(Vector2 point, int canvasWidth, int canvasHeight) {
		int x = (int) (point.x + canvasWidth / 2);
		int y = (int) (canvasHeight / 2 - point.y);
		// (33.3, 33.3) -> (33.3 + 1024/2, 576/2 - 33.3) = (33.3 + 512, 288 - 33.3)
		//                   = (545, 255)
		return new Vector2(x, y);
	}	
}