package graphics;

import javax.swing.*;

import main.SceneTree;
import math.*;

import java.awt.*;


@SuppressWarnings("serial")
public class Display extends JFrame{
		
	private final String title = "Game";
	private final int tileSize = 64;
	private int aspectRatioX = 16;
	private int aspectRatioY = 9;
	private int width = tileSize * aspectRatioX; // 64 * 16 = 1024
	private int height = tileSize * aspectRatioY; // 64 * 9 = 576
	
	private final Color backgroundColour = Color.black;
		
	@SuppressWarnings("unused")
	private SceneTree tree = null;
	
	private Vector3 eye = new Vector3(0, 0, 0);
	
	private Container pane;
	private JPanel renderPanel;
	
	public Display(SceneTree tree) {
		
		this.tree = tree;
		
		pane = getContentPane();
		pane.setLayout(new BorderLayout());
		renderPanel = new RenderPanel(tree, width, height, eye, backgroundColour);
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
}
