package events;

import java.lang.reflect.InvocationTargetException;


public class Signal {
	
	Connection[] connectionList = new Connection[0];
	
	// Emits signal to each connection
	public void emit(Object[] arguments) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, MissingFunctionException {
		for (Connection connection: connectionList) {
			connection.callMethod(arguments);
		}
	}
	// Emits signal to one object
	public void emitTo(Object target, Object[] arguments) throws MissingConnectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MissingFunctionException {
		
		for (Connection currentConnection: connectionList) {
			if (target == currentConnection.target) {
				currentConnection.callMethod(arguments);
				return;
			}
		}
		throw new MissingConnectionException("Connection to '" + target.toString() + "' not found");
	}

	public void connect(Connection newConnection) {
		
		Connection[] newArray = new Connection[connectionList.length + 1];
		
		int index = 0;
		for(Connection currentConnection: connectionList) {
			newArray[index] = currentConnection;
			index ++;
		}
		
		newArray[connectionList.length] = newConnection;
		connectionList = newArray;
	}
	// Creates a connection, then adds it to the list
	public void connectObject(Object object, String methodName) {
		Connection newConnection = new Connection(object, methodName);
		
		Connection[] newArray = new Connection[connectionList.length + 1];
		
		int index = 0;
		for(Connection currentConnection: connectionList) {
			newArray[index] = currentConnection;
			index ++;
		}
		
		newArray[connectionList.length] = newConnection; // Adds the connection
		connectionList = newArray;
	}
	public void disconnect(Connection connection) {
		
		Connection[] newArray = new Connection[connectionList.length - 1];
		
		int index = 0;
		int push = 0; // Number of spaces elements are pushed by

		for (Connection currentConnection: connectionList) {
			
			// Stops loop if current index equals length of newArr
			if (index == newArray.length) {
				break;
			}
			if (currentConnection == connection) {
				push++;
			}
			
			newArray[index] = connectionList[index + push];
			index ++;
		}
		connectionList = newArray;
	}
	public void disconnectObject(Object connectionTarget) {
		
		Connection[] newArray = new Connection[connectionList.length - 1];
		
		int index = 0;
		int push = 0; // Number of spaces elements are pushed by

		for (Connection currentConnection: connectionList) {
			
			// Stops loop if current index exceeds newArray length
			if (index == newArray.length - 1) {
				break;
			}
			if (currentConnection.target == connectionTarget) {
				push++;
			}
			
			newArray[index] = connectionList[index + push];
			index ++;
		}
		connectionList = newArray;
	}
}