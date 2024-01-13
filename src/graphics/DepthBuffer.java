package graphics;

import java.awt.Color;
import java.util.ArrayList;


public class DepthBuffer {

	public PixelDepthList[] pixelList;
	
	public DepthBuffer(int screenWidth, int screenHeight) {
		pixelList = new PixelDepthList[screenWidth * screenHeight];
		for(int i = 0; i < pixelList.length; i++) {
			pixelList[i] = new PixelDepthList();
		}
	}
	
	
	
	// List of PixelData
	class PixelDepthList {
		ArrayList<Color> pixelDepthList = new ArrayList<>();
	}
	class PixelData {
		Color color = Color.BLACK;
	}
}
