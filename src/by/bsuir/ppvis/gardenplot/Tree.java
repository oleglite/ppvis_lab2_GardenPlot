package by.bsuir.ppvis.gardenplot;

/** �����, ����������� �������� ������.
 * @author Oleg Beloglazov
 *
 */
public class Tree extends Plant {
	
	// ����������� �������� ������� �������
	public static final double MIN_DRY_VALUE = 0.1;	
	// ����������� ���������� ������ ������
	public static final int MIN_RIPE_FRUITS_NUMBER = 5;
	// ���������� �������� ������� �������
	private static final double LIMIT_DRY_VALUE = 1.0;	
	// ���������� ���������� ������ ������
	private static final int LIMIT_RIPE_FRUITS_NUMBER = 20;
	
	// �������� ���������� �������
	private static final double DRY_INCREMENT_VALUE = 0.2;
	// �������� ���������� ������ ������
	private static final int RIPE_FRUITS_INCREMENT_NUMBER = 3;
	// �� ������� ���������� ������� ��� ������ ������ �������� ����
	private static final double DRY_FACTOR_WATER_DECREASING = 0.1;
	
	// ����������� �������
	private double mDryFactor;
	// ���������� ������ ������
	private int mRipeFruitsNumber;
	
	
	/** �����������, ��������������� ����������� �������� ������� � ���������� ������.
	 * 
	 */
	public Tree() {
		this(MIN_DRY_VALUE, MIN_RIPE_FRUITS_NUMBER);
	}
	
	/** �����������, ��������������� ��������� �������� ������� � ���������� ������.
	 * @param dryFactor ����������� �������.
	 * @param ripeFruitsNumber ���������� ������ ������.
	 */
	public Tree(double dryFactor, int ripeFruitsNumber) {
		setDryFactor(dryFactor);
		setRipeFruitsNumber(ripeFruitsNumber);
	}

	/**
	 * @see by.bsuir.ppvis.gardenplot.Plant#grow()
	 */
	@Override
	public void grow() {
		mDryFactor += DRY_INCREMENT_VALUE;
		mRipeFruitsNumber += RIPE_FRUITS_INCREMENT_NUMBER;
	}

	/**
	 * @see by.bsuir.ppvis.gardenplot.Plant#getInfo()
	 */
	@Override
	public String getInfo() {
		return String.format("������ (������� %1$.1f, ������ %2$d)", mDryFactor, mRipeFruitsNumber);
	}
	
	/** 
	 * @see by.bsuir.ppvis.gardenplot.Plant#checkState()
	 */
	@Override
	public boolean checkNeed(Need need) {
		if(need == Need.NEEDS_WATER && mDryFactor >= LIMIT_DRY_VALUE) {
			return true;
		}
		if(need == Need.NEEDS_PICK_FRUITS && mRipeFruitsNumber >= LIMIT_RIPE_FRUITS_NUMBER) {
			return true;
		}
		return false;
	}
	
	/** �������� ����������� �������.
	 * @return ����������� �������.
	 */
	public double getDryFactor() {
		return mDryFactor;
	}
	
	/** �������� ���������� ������ ������.
	 * @return
	 */
	public int getRipeFruitsNumber() {
		return mRipeFruitsNumber;
	}
	
	/** ������ ������.
	 * ��� ���������� ������������ �������� ������������ ������� �������� �� �����.
	 * @param waterAmount ���������� ����.
	 */
	public void water(int waterAmount) {
		mDryFactor -= waterAmount * DRY_FACTOR_WATER_DECREASING;
		if(mDryFactor < MIN_DRY_VALUE)
			mDryFactor = MIN_DRY_VALUE;
	}
	
	/** ������� �����.
	 * ��� ���������� ������������ �������� ���������� ������ ������ �������� ������ �� �����.
	 * @param ripeFruitsNumber ���������� ���������� ������.
	 */
	public void takeRipeFruits(int ripeFruitsNumber) {
		mRipeFruitsNumber -= ripeFruitsNumber;
		if(mRipeFruitsNumber < MIN_RIPE_FRUITS_NUMBER)
			mRipeFruitsNumber = MIN_RIPE_FRUITS_NUMBER;
	}
	
	private void setDryFactor(double dryFactor) {
		if(dryFactor < MIN_DRY_VALUE) {
			mDryFactor = MIN_DRY_VALUE;
		} else {
			mDryFactor = dryFactor;
		}		
	}
	
	private void setRipeFruitsNumber(int ripeFruitsNumber) {
		if(ripeFruitsNumber < MIN_RIPE_FRUITS_NUMBER) {
			mRipeFruitsNumber = MIN_RIPE_FRUITS_NUMBER;
		} else {
			mRipeFruitsNumber = ripeFruitsNumber;
		}
	}	

}
