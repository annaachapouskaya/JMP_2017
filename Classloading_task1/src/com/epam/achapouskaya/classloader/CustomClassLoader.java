package com.epam.achapouskaya.classloader;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {
	
	private String loadingPackage;
	
	public CustomClassLoader(ClassLoader parent, String loadingPackage) {
		super(parent);
		this.loadingPackage = loadingPackage;
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		System.out.println("Starting loading class " + name);
		
		Class<?> c = findLoadedClass(name);
			
		if (c == null) {
			if (this.getParent() != null && !name.startsWith(this.loadingPackage)) {
				try {
					c = this.getParent().loadClass(name);
				} catch (ClassNotFoundException e) {
					
				}
			}
			if (c == null) {
				c = getClass(name);
				if (c != null) {
					System.out.println("Class " + name +" was loaded by CustomClassLoader");
				}
			} else {
				System.out.println("Class " + name + " was loaded by parent class loader");
			}
			
		} else {
			System.out.println("Class " + name + " was found in cache");
		}
		return c;
	}
	
	public Class<?> reloadClass(String name) throws ClassNotFoundException {
		ClassLoader newLoader = new CustomClassLoader(this.getParent(), this.loadingPackage);
		return newLoader.loadClass(name);
	}
	
	private Class<?> getClass(String name) throws ClassNotFoundException {
		String fileName = name.replace('.', '/') + ".class";
	
		Class<?> c = null;
	
		try {
			byte[] b = loadClassFileData(fileName);
			if (b != null) {
				c = defineClass(name, b, 0, b.length);
				resolveClass(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return c;
	}
	
	private byte[] loadClassFileData(String name) throws IOException {
		InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
		if (stream != null) {
			int size = stream.available();
			byte buff[] = new byte[size];
			DataInputStream in = new DataInputStream(stream);
			in.readFully(buff);
			in.close();
			return buff;
		} else {
			System.out.println("Class path is incorrect");
			return null;
		}
	}
	
	
}
