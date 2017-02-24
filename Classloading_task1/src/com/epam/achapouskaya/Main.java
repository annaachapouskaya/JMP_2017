package com.epam.achapouskaya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.epam.achapouskaya.classloader.CustomClassLoader;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		String classPath = args[0];
		CustomClassLoader customClassLoader = new CustomClassLoader(Main.class.getClassLoader(), "com.epam.achapouskaya.classes");
		
		testClassLoader(customClassLoader, classPath);
		
		//now class should be loaded from cache
		testClassLoader(customClassLoader, classPath);
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				String newClassPath = askForClassPath(reader);
				testClassReload(customClassLoader, newClassPath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void testClassLoader (ClassLoader classLoader, String className) throws ClassNotFoundException,
	InstantiationException, IllegalAccessException, NoSuchMethodException,
	SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<? extends Object> clas;
		clas = classLoader.loadClass(className);
		if (clas != null) {
			Object object = clas.newInstance();
			Method lever = clas.getMethod("lever");
			lever.invoke(object);
		}
		
	}
	
	private static void testClassReload (CustomClassLoader classLoader, String className) throws ClassNotFoundException,
		InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<? extends Object> clas;
		clas = classLoader.reloadClass(className);
		if (clas != null) {
			Object object = clas.newInstance();
			Method lever = clas.getMethod("lever");
			lever.invoke(object);
		}
	
	}
	
	private static String askForClassPath(BufferedReader reader) throws IOException {
		while (true) {
			System.out.print("Enter new classpath: ");
			String newClassPath = reader.readLine();
			if (newClassPath.isEmpty()) {
				System.out.println("Class path shouldn't be empty!");
			} else {
				return newClassPath;
			}
		}
	}
}
