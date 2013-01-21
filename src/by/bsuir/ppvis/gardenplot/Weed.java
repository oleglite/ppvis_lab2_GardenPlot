package by.bsuir.ppvis.gardenplot;

import by.bsuir.ppvis.gardenplot.Plant.Need;

/** �����, ����������� �������� ������.
 * @author Oleg Beloglazov
 *
 */
public class Weed extends Plant {
	
	// ����������� ����� �������
	public static final int MIN_LENGTH = 1;
	// ����������� ����� �������
	private static final int LIMIT_LENGTH = 10;
	// ���������� �������	
	private static final int GROWTH_VALUE = 2;
	
	// ����� �������
	private int mLength;
	
	
	/** ����������� �� ���������, ������������� �������� ����� ������� �����������.
	 * 
	 */
	public Weed() {
		this(MIN_LENGTH);
	}
	
	/** �����������, ��������������� �������� �������� ����� �������.
	 * @param length ��������� �������� �����.
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
		return String.format("������ (����� %1$d)", mLength);
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
	
	/** �������� ����� �������.
	 * @return ����� �������.
	 */
	public int getLength() {
		return mLength;
	}
	
	/** �������� ������.
	 * ����� ����� ������ ���� �� ������ ������������ �������� � �� ��������� �������.
	 * @param length ����� ����� �������.
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
