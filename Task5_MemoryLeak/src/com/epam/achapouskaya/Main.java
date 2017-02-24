package com.epam.achapouskaya;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static String FILEPATH = "src/data.txt";

	public static void main(String[] args) {
		//readFileWithOOM();
		readFileWithoutOOM();

	}
	
	private static void readFileWithOOM() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILEPATH));
			String tmp = reader.readLine();
			List<String> stringsList = new ArrayList<String>();
			while (tmp != null) {
				stringsList.add(tmp.substring(0, 3));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
	
	private static void readFileWithoutOOM() {
		Scanner scanner;
		try {
			scanner = new Scanner(new File(FILEPATH));
			scanner.useDelimiter("");
			List<String> stringsList = new ArrayList<String>();
			while (scanner.hasNextLine()) {
				//System.out.println(scanner.next() + scanner.next() + scanner.next());
				stringsList.add(scanner.next() + scanner.next() + scanner.next());
				scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
