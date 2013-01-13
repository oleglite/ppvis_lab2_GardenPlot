package by.bsuir.ppvis.gardenplot;

/** Класс, реализующий инструмент ведро.
 * @author Oleg Beloglazov
 *
 */
public class Bucket extends Instrument {
	
	private final int mCapacity;

	/** Основной конструктор.
	 * @param capacity вместимость.
	 */
	public Bucket(int capacity) {
		super("Ведро");
		mCapacity = capacity;
	}
	
	/** Полить растение.
	 * @param plant растение.
	 */
	public void water(Plant plant) {
		
	}
	
	private int calculateWaterAmount() {
		return 0;
	}
}
