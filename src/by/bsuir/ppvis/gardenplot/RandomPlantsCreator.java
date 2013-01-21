package by.bsuir.ppvis.gardenplot;

import java.util.Random;

public class RandomPlantsCreator {
	
	private Random mRandom;
	
	public RandomPlantsCreator() {
		mRandom = new Random();
	}
	
	public Plant generateRandomPlant() {
		Plant plant = null;
		int plantType = mRandom.nextInt(2);
		
		switch(plantType) {
			case 0:
				plant = generateRandomTree();
				break;
			case 1:
				plant = generateRandomWeed();
				break;
		}
		
		return plant;
	}
	
	private Tree generateRandomTree() {
		double dryFactor = (double)(mRandom.nextInt(10) + 1) / 10;
		int ripeFruitsNumber = mRandom.nextInt(25);
		return new Tree(dryFactor, ripeFruitsNumber);
	}
	
	private Weed generateRandomWeed() {
		int length = mRandom.nextInt(15);
		return new Weed(length);
	}
}
