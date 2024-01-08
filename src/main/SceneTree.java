package main;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import events.*;
import graphics.*;
import graphics.graphics3d.*;


public class SceneTree {
	
	Signal updateSignal = new Signal();
	
	Display display = null;

	private ArrayList<Object3d> objectList = new ArrayList<Object3d>();
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		SceneTree tree = new SceneTree();
	}
	
	public SceneTree( ) {
		
		displayWindow();
		addTestObject();
		
		runGameLoop();
	}
	
	public void addTestObject() {
		Object3d object = new Object3d(Cube.createCube());
		objectList.add(object);
	}
	
	private void runGameLoop() {
		long previousTime = System.nanoTime();
		double updateRate = 1; // Per second
		double nanoseconds = 1000000000; // nanoseconds per second
		float delta = 0;
		
		boolean running = true;

		while(running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - previousTime) / nanoseconds;
			//System.out.println(delta);
			while (delta >= 1 / updateRate) {
				//System.out.println(delta);
				try {
					updateSignal.emit(new Object[0]);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| MissingFunctionException e) {
					e.printStackTrace();
				}
				delta = 0;
			}
			previousTime = currentTime;	
		}
	}
	
	public void displayWindow() {
		display = new Display(this);
		updateSignal.connectObject(display, "onUpdateEvent");
		display.setVisible(true);
	}
	
	public Object3d[] getObjectList() {
		Object3d[] objectArray = new Object3d[objectList.size()];
		for(int i = 0; i < objectArray.length; i++) {
			objectArray[i] = objectList.get(i);
		}
		return objectArray;
	}
}
