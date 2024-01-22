package graphics;

import java.awt.Color;


public class ZSorter {

	public Pixel[] pixelList;
	
	public ZSorter(int width, int height, Color defaultColour) {
		pixelList = new Pixel[width * height];
		for(int i = 0; i < pixelList.length; i++) {
			pixelList[i] = new Pixel(-1, Double.POSITIVE_INFINITY, defaultColour);
		}
	}
	
	public boolean closerToEye(int position, int renderPriority, double z, Color color) {
		boolean isCloser = pixelList[position].isBelow(renderPriority, z);
		
		// If new pixel is above the old one, the old pixel is overwritten
		if(isCloser) {
			pixelList[position].overwritePixel(renderPriority, z, color);
		}
		return isCloser;
	}
	
	// Output of a pixel at a specific position 
	class Pixel {
		
		int renderPriority;
		double z;
		Color outputColour;
		
		public Pixel(int priority, double z, Color colour) {
			renderPriority = priority;
			this.z = z;
			outputColour = colour;
		}
		
		public boolean isBelow(int pixelPriority, double pixelZ) {
			if(pixelPriority > renderPriority ) {
				return true;
			}
			if(pixelPriority == renderPriority) {
				if(pixelZ < 0) {
					return false;
				}
				if(pixelZ <= z) {
					return true;
				}
			}
			return false;
		}
		
		public void overwritePixel(int renderPriority, double z, Color colour) {
			this.renderPriority = renderPriority;
			this.z = z;
			outputColour = colour;
		}
	}
}
