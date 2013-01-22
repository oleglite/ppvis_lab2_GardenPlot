package by.bsuir.ppvis.gardenplot;

import java.util.Random;

/**  ласс дл€ создани€ случайных растений.
 * @author Oleg Beloglazov
 *
 */
public class RandomPlantsCreator {
	
	private static final int MAX_DRY_FACTOR_PERCENT = 100;
	private static final int MAX_RIPE_FRUITS = 25;
	private static final int MAX_WEEDS_LENGTH = 15;
	
	private Random mRandom;
	
	public RandomPlantsCreator() {
		mRandom = new Random();
	}
	
	/** —оздать и получить случайное растение.
	 * @return созданное растение.
	 */
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
		double dryFactor = (double)(mRandom.nextInt(MAX_DRY_FACTOR_PERCENT/10) + 1) / 10;
		int ripeFruitsNumber = mRandom.nextInt(MAX_RIPE_FRUITS);
		return new Tree(dryFactor, ripeFruitsNumber);
	}
	
	private Weed generateRandomWeed() {
		int length = mRandom.nextInt(MAX_WEEDS_LENGTH);
		return new Weed(length);
	}
}
