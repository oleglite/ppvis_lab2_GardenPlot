package by.bsuir.ppvis.gardenplot;

import by.bsuir.ppvis.gardenplot.Plant.Need;

/**  ласс, реализующий растение сорн€к.
 * @author Oleg Beloglazov
 *
 */
public class Weed extends Plant {
	
	// минимальна€ длина сорн€ка
	public static final int MIN_LENGTH = 1;
	// минимальна€ длина сорн€ка
	private static final int LIMIT_LENGTH = 10;
	// приращение сорн€ка	
	private static final int GROWTH_VALUE = 2;
	
	// длина сорн€ка
	private int mLength;
	
	
	/**  онструктор по умолчанию, устанавливает значение длины сорн€ка минимальной.
	 * 
	 */
	public Weed() {
		this(MIN_LENGTH);
	}
	
	/**  онструктор, устанавливающий заданное значение длины сорн€ка.
	 * @param length начальное значение длины.
	 */
	public Weed(int length) {
		setLength(length);
	}

	/**
	 * @see by.bsuir.ppvis.gardenplot.Plant#grow()
	 */
	@Override
	public void grow() {
		mLength += GROWTH_VALUE;
	}

	/**
	 * @see by.bsuir.ppvis.gardenplot.Plant#getInfo()
	 */
	@Override
	public String getInfo() {
		return String.format("—орн€к (длина %1$d)", mLength);
	}
	
	/** 
	 * @see by.bsuir.ppvis.gardenplot.Plant#checkState()
	 */
	@Override
	public boolean checkNeed(Need need) {
		if(need == Need.NEEDS_REMOVE_WEEDS && mLength >= LIMIT_LENGTH) {
			return true;
		}
		return false;
	}
	
	/** ѕолучить длину сорн€ка.
	 * @return длина сорн€ка.
	 */
	public int getLength() {
		return mLength;
	}
	
	/** ќбрезать сорн€к.
	 * Ќова€ длина должна быть не меньше минимального значени€ и не превышать текущую.
	 * @param length нова€ длина сорн€ка.
	 */
	public void cut(int length) {
		if(length >= MIN_LENGTH && length < mLength)
			mLength = length;
	}
	
	private void setLength(int length) {
		if(length < MIN_LENGTH) {
			mLength = MIN_LENGTH;
		} else {
			mLength = length;
		}
	}
}
