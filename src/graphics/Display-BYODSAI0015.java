package graphics;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class Display extends JFrame{
		
	final String title = "Game";
	final int tileSize = 64;
	final int aspectRatioX = 16;
	final int aspectRatioY = 9;
	final int width = tileSize * aspectRatioX;
	final int height = tileSize * aspectRatioY;
	
	public Display() {
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.black);
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setFocusable(false);
		add(canvas);
		pack();
		
		setLocationRelativeTo(null);
	}

	public void paint(Graphics2D graphics, Shape[] shapes, Image[] images, String[] text) {
		
	}
}
