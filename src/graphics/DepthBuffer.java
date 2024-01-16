package graphics;

import java.awt.Color;
import java.util.ArrayList;


public class DepthBuffer {

	public PixelData[] pixelList;
	
	public DepthBuffer(int screenWidth, int screenHeight) {
		pixelList = new PixelData[screenWidth * screenHeight];
		for(int i = 0; i < pixelList.length; i++) {
			pixelList[i] = new PixelData();
		}
	}
	
	public boolean drawPixel(int position, double depth, Color color) {
		return true;
	}
	
	class PixelData {
		ArrayList<Pixel> pixelDatalist = new ArrayList<>();	// List of every pixel drawn at a position
		Color finalColor = Color.BLACK;
	}
	class Pixel {
		double depth;
		Color color;
		
		public Pixel(double depth, Color color) {
			this.depth = depth;
			this.color = color;
		}
	}
}
