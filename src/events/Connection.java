package events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Connection {

	public Object target = null; // Object attached to the event
	String methodName = null;
	
	public Connection(Object target, String methodName) {
		this.target = target;
		this.methodName = methodName;
	}
	
	public void callMethod(Object[] argList) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, MissingFunctionException {
		Method[] methodList = target.getClass().getMethods();
		
		for (Method method: methodList) {
			if (method.getName().equals(methodName)) {
				method.invoke(target, argList);
				return;
			}
		}
		throw new MissingFunctionException("Function '" + methodName + "' not found"); // If no method is found

	}
}