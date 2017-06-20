package com.epam.achapouskaya;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		List<List<DummyObject>> listOfLists = new ArrayList<List<DummyObject>>();
		int batchSize = 500;
		double cleaningPercentage = 1;
	
		int recordsToRemove = (int) (batchSize * cleaningPercentage);
		
		while (true) {
			List<DummyObject> batch = new ArrayList<DummyObject>(batchSize); 
			//create objects
			for (int i = 0; i < batchSize; i++) {
				DummyObject dummy = DummyObject.generateDummyObject(1, 100);
				batch.add(dummy);
				//System.out.println("DummyObject with lenght of String " + dummy.getData().length +
						//" was created");
			}
			
			//create references
			for (int i = 0; i < batchSize; i++) {
				batch.get(i).setDummyObject(batch.get(
						ThreadLocalRandom.current().nextInt(0, batchSize)));
			}
			listOfLists.add(batch);
			
			//clean some references
			for (int i = 0; i < recordsToRemove; i++) {
				int firstIndex;
				do {
					firstIndex = ThreadLocalRandom.current().nextInt(0, listOfLists.size());
				} while (listOfLists.get(firstIndex).size() <= 0);
				int secondIndex = ThreadLocalRandom.current().nextInt(0, listOfLists.get(firstIndex).size());
				listOfLists.get(firstIndex).remove(secondIndex);
				//System.out.println("Record " + firstIndex + " " + secondIndex + " was removed");
				
			}
			
		}

	}
	

}
