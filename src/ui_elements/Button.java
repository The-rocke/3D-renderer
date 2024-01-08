package ui_elements;

import java.awt.Color;
import math.*;
import events.*;
//import graphics.*;
import main.*;
import math.Vector2;


public class Button {
	
	Signal onPressEvent = new Signal();
	
	SceneTree tree = null;
	
	Vector2 position = new Vector2(0, 0);
	String text = "";
	
	//Rectangle2D shape = null;

	boolean visible = false;
	
	boolean hasBackground = true;
	boolean grabbable = true;

	public Button(SceneTree tree) {
		this.tree = tree;
	}
	
	public void setPosition(Vector2 newPosition) {
		position = newPosition;
	}
	public void setText(String newText) {
		text = newText;
	}

	public void setShape(Vector2 endPosition, Color color) {
		//Rectangle2D oldShape = shape;
		//shape = new Rectangle2D(position, color, hasBackground, endPosition);
		if (hasBackground) {
		//	tree.shapeList.remove(oldShape);
		//	tree.shapeList.add(shape);
		}		
	}
	
	public void setVisibility(boolean isVisible) {
		visible = isVisible;
	}
}
