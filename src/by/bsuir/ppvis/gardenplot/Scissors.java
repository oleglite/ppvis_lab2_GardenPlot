package by.bsuir.ppvis.gardenplot;

/** Класс, реализующий инструмент ножницы.
 * @author Oleg Beloglazov
 *
 */
public class Scissors extends Instrument {
	
	// состояние: false закрыты, true открыты
	private boolean mState = false;
	// сорняк, который нужно срезать
	private Weed mWeed = null;

	/** Основной конструктор.
	 * 
	 */
	public Scissors() {
		super("Ножницы");
	}
	
	/** Срезать растение.
	 * Срезает только сорняки.
	 * @param plant растение.
	 */
	public void cut(Plant plant) {
		if(plant instanceof Weed) {
			mWeed = (Weed) plant;			
		}
		open();
		close();
	}
	
	/** Открыть ножницы.
	 * Устанавливает новую длину сорняка.
	 * 
	 */
	private void open() {
		if(mWeed != null && mState == false) {
			mWeed.cut(Weed.MIN_LENGTH);
			mState = true;
		}
	}
	
	/** Закрыть ножницы.
	 * 
	 */
	private void close() {
		if(mWeed != null) {
			mWeed = null;
		}
		mState = false;
	}

}
