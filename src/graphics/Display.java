package graphics;

import javax.swing.*;

import graphics.graphics2d.Triangle2d;
import graphics.graphics3d.*;
import main.SceneTree;
import math.*;

import java.awt.*;
import java.awt.image.BufferedImage;


@SuppressWarnings("serial")
public class Display extends JFrame{
		
	final String title = "Game";
	final int tileSize = 64;
	final int aspectRatioX = 16;
	final int aspectRatioY = 9;
	final int width = tileSize * aspectRatioX; // 64 * 16 = 1024
	final int height = tileSize * aspectRatioY; // 64 * 9 = 576
	
	final Color backgroundColor = Color.black;
	
	final Vector3 eye = new Vector3(0, 0, 0);
	
	SceneTree tree = null;
	
	Container pane;
	JPanel renderPanel;
	
	public Display(SceneTree tree) {
		
		this.tree = tree;
		
		pane = getContentPane();
		pane.setLayout(new BorderLayout());
		renderPanel = new RenderPanel();
		renderPanel.setDoubleBuffered(true);
		pane.add(renderPanel, BorderLayout.CENTER);
		
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
	
	public void onUpdateEvent() {
		renderPanel.repaint();
	}
	
	private class RenderPanel extends JPanel {
		
		public void paintComponent(Graphics g) {
			
			this.setDoubleBuffered(true);
			
			Graphics2D g2 = (Graphics2D) g;
							
			g2.setColor(backgroundColor);
			g2.fillRect(0, 0, width, height);
				
			BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
			
			Object3d[] objectList = tree.getObjectList();
			for (Object3d object: objectList) {
				Triangle[] objectGeometry = object.getGeometry();
				for (Triangle face: objectGeometry) {
					
					//Path2D triangle = new Path2D.Double();
					
					Vector3 v1 = face.vertex1;
					Vector3 v2 = face.vertex2;
					Vector3 v3 = face.vertex3;
					System.out.println("");
					v1.printValues();
					v2.printValues();
					v3.printValues();
					System.out.println("--");
					
					Vector2 p1 = VectorUtils.toScreenSpace(v1, eye);
					Vector2 p2 = VectorUtils.toScreenSpace(v2, eye);
					Vector2 p3 = VectorUtils.toScreenSpace(v3, eye);
					p1.printValues();
					p2.printValues();
					p3.printValues();
					System.out.println("--");

					//triangle.moveTo(p1.x, p1.y);
					//triangle.lineTo(p2.x, p2.y);
					//triangle.lineTo(p3.x, p3.y);
					//triangle.lineTo(p1.x, p1.y);
					
					//g2.draw(triangle);
					
					// Vertices in normal space
					Vector2 n1 = VectorUtils.toNormalSpace(p1, width, height);
					Vector2 n2 = VectorUtils.toNormalSpace(p2, width, height);
					Vector2 n3 = VectorUtils.toNormalSpace(p3, width, height);
					Triangle2d outputTriangle = new Triangle2d(n1, n2, n3);
					
					n1.printValues();
					n2.printValues();
					n3.printValues();
					System.out.println("");
										
					// The dimensions of an imaginary rectangle around the triangle in raster space
                    int minX = (int) Math.max(0, 
                    		Math.ceil(Math.min(n1.x, Math.min(n2.x, n3.x))));
                    int maxX = (int) Math.min(width - 1,
                            Math.floor(Math.max(n1.x, Math.max(n2.x, n3.x))));
                    int minY = (int) Math.max(0, 
                    		Math.ceil(Math.min(n1.y, Math.min(n2.y, n3.y))));
                    int maxY = (int) Math.min(height - 1,
                            Math.floor(Math.max(n1.y, Math.max(n2.y, n3.y))));
                                        
					// Iterates through each pixel in the given area
					for(int x = minX; x <= maxX; x++) {
						for(int y = minY; y <= maxY; y++) {
							
							Vector2 pixelPosition = new Vector2(x, y);
							boolean hasColour = outputTriangle.containsPoint(pixelPosition);
							
							if(hasColour) {
								output.setRGB(x, y, face.color.getRGB());
							}
						}
					}
					g2.drawImage(output, 0, 0, null);
				}
			}
		}
	}
}
