package graphics;

import java.awt.Color;


public class ZSorter {

	public Pixel[] pixelList;
	
	public ZSorter(int width, int height) {
		pixelList = new Pixel[width * height];
		for(int i = 0; i < pixelList.length; i++) {
			pixelList[i] = new Pixel(-1, Double.POSITIVE_INFINITY, Color.BLACK);
		}
	}
	
	public boolean isClosest(int position, int renderPriority, double z, Color color, boolean print) {
		boolean isCloser = pixelList[position].isBelow(renderPriority, z, print);
		// If new pixel is above the old one, the old pixel is overwritten
		if(isCloser) {
			if(print) {
				System.out.println("o");
			}
			pixelList[position] = new Pixel(renderPriority, z, color);
		}
		if(print) {
			System.out.println(isCloser);
			System.out.println("");
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
		
		public boolean isBelow(int pixelPriority, double pixelZ, boolean print) {
			if(print) {
				System.out.println(pixelZ);
				System.out.println(z);
				System.out.println(outputColour.toString());
			}
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
	}
}
