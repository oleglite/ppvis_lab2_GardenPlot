package by.bsuir.ppvis.gardenplot;

/** Класс, реализующий инструмент ведро.
 * @author Oleg Beloglazov
 *
 */
public class Bucket extends Instrument {
	
	// значение ёмкости ведра по-умолчанию
	private static final int DEFAULT_CAPACITY = 5;
	
	// ёмкость ведра
	private final int mCapacity;
	
	/** Конструктор, устанавливающий значение ёмкости по-умолчанию.
	 * 
	 */
	public Bucket() {
		this(DEFAULT_CAPACITY);
	}

	/** Конструктор, устанавливающий указанную ёмкость.
	 * @param capacity вместимость.
	 */
	public Bucket(int capacity) {
		super("Ведро");
		mCapacity = capacity;
	}
	
	/** Полить растение.
	 * Поливает только деревья.
	 * @param plant растение.
	 */
	public void water(Plant plant) {
		if(plant instanceof Tree) {
			Tree tree = (Tree) plant;
			while(tree.getDryFactor() > Tree.MIN_DRY_VALUE) {
				tree.water(mCapacity);
			}
		}
	}
	
	/** Собрать плоды.
	 * Собирает плоды только с деревьев.
	 * @param plant растение.
	 */
	public void pickFruits(Plant plant) {
		if(plant instanceof Tree) {
			Tree tree = (Tree) plant;
			while(tree.getRipeFruitsNumber() > Tree.MIN_RIPE_FRUITS_NUMBER) {
				tree.takeRipeFruits(mCapacity);
			}
		}
	}
}
