package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import main.SceneTree;
import math.*;

@SuppressWarnings("serial")
public class RenderPanel extends JPanel {
	
	SceneTree tree;
	
	private int width;
	private int height;
		
	Color skyColour;
	
	Vector3 eye;
	
	public RenderPanel(SceneTree tree, int width, int height, Vector3 eye, Color skyColour) {
		this.tree = tree;
		this.width = width;
		this.height = height;
		this.eye = eye;
		this.skyColour = skyColour;
	}
	
	public void paintComponent(Graphics g) {
		
		this.setDoubleBuffered(true);
		
		Graphics2D g2 = (Graphics2D) g;
						
		g2.setColor(skyColour);
		g2.fillRect(0, 0, width, height);
		
		ZSorter zSorter  = new ZSorter(width, height, skyColour);
		
		BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		
		Triangle3d[] sceneGeometry = tree.compileTriangleList();
		for (Triangle3d face: sceneGeometry) {
			
			double z = face.getMeanZ(eye); // Depth of face
			
			Vector3 v1 = (Vector3) face.vertex1;
			Vector3 v2 = (Vector3) face.vertex2;
			Vector3 v3 = (Vector3) face.vertex3;
			System.out.println("");

			v1.printValues();
			v2.printValues();
			v3.printValues();
			System.out.println("--");
				
			Vector2 p1 = Coordinate.toScreenSpace(v1, eye);
			Vector2 p2 = Coordinate.toScreenSpace(v2, eye);
			Vector2 p3 = Coordinate.toScreenSpace(v3, eye);
			p1.printValues();
			p2.printValues();
			p3.printValues();
			System.out.println("--");
			
			// Vertices in pixel coordinates space
			Vector2 r1 = Coordinate.toRasterSpace(p1, width, height);
			Vector2 r2 = Coordinate.toRasterSpace(p2, width, height);
			Vector2 r3 = Coordinate.toRasterSpace(p3, width, height);
			Triangle2d outputTriangle = new Triangle2d(r1, r2, r3);
				
			r1.printValues();
			r2.printValues();
			r3.printValues();
			System.out.println("---");
			
			Vector2 w = Coordinate.pointOnTriangle(r1, outputTriangle, face);
			w.printValues();
			System.out.println("---");
									
			// The dimensions of an imaginary rectangle around the triangle in raster space
			int minX = (int) Math.max(0,
					Math.ceil(Math.min(r1.x, Math.min(r2.x, r3.x))));
			int maxX = (int) Math.min(width - 1,
            		Math.floor(Math.max(r1.x, Math.max(r2.x, r3.x))));
			int minY = (int) Math.max(0,
					Math.ceil(Math.min(r1.y, Math.min(r2.y, r3.y))));
			int maxY = (int) Math.min(height - 1,
					Math.floor(Math.max(r1.y, Math.max(r2.y, r3.y))));
                                    
			// Iterates through each pixel in the given area
			for(int x = minX; x <= maxX; x++) {
				for(int y = minY; y <= maxY; y++) {
					
					Vector2 pixelPosition = new Vector2(x, y);
					boolean isInTriangle = outputTriangle.containsPoint(pixelPosition);
					
					if(isInTriangle) {
						if(zSorter.closerToEye(width*(y-1)+x, face.renderPriority, z, face.color)) {
							output.setRGB(x, y, face.color.getRGB());
						}
					}
				}
			}
			g2.drawImage(output, 0, 0, null);
		}
	}
}