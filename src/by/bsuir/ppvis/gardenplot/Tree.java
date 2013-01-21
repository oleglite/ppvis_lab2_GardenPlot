package by.bsuir.ppvis.gardenplot;

/**  ласс, реализующий растение дерево.
 * @author Oleg Beloglazov
 *
 */
public class Tree extends Plant {
	
	// минимальное значение сухости деревва
	public static final double MIN_DRY_VALUE = 0.1;	
	// минимальное количество зрелых плодов
	public static final int MIN_RIPE_FRUITS_NUMBER = 5;
	// предельное значение сухости деревва
	private static final double LIMIT_DRY_VALUE = 1.0;	
	// предельное количество зрелых плодов
	private static final int LIMIT_RIPE_FRUITS_NUMBER = 20;
	
	// значение приращени€ сухости
	private static final double DRY_INCREMENT_VALUE = 0.2;
	// значение приращени€ зрелых плодов
	private static final int RIPE_FRUITS_INCREMENT_NUMBER = 3;
	// на сколько уменьшитс€ сухость при поливе дерева единицей воды
	private static final double DRY_FACTOR_WATER_DECREASING = 0.1;
	
	// коэффициент сухости
	private double mDryFactor;
	// количество зрелых плодов
	private int mRipeFruitsNumber;
	
	
	/**  онструктор, устанавливающий минимальные значени€ сухости и количества плодов.
	 * 
	 */
	public Tree() {
		this(MIN_DRY_VALUE, MIN_RIPE_FRUITS_NUMBER);
	}
	
	/**  онструктор, устанавливающий указанные значени€ сухости и количества плодов.
	 * @param dryFactor коэффициент сухости.
	 * @param ripeFruitsNumber количество зрелых плодов.
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
		return String.format("ƒерево (сухость %1$.1f, плодов %2$d)", mDryFactor, mRipeFruitsNumber);
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
	
	/** ѕолучить коэффициент сухости.
	 * @return коэффициент сухости.
	 */
	public double getDryFactor() {
		return mDryFactor;
	}
	
	/** ѕолучить количество зрелых плодов.
	 * @return
	 */
	public int getRipeFruitsNumber() {
		return mRipeFruitsNumber;
	}
	
	/** ѕолить дерево.
	 * ѕри достижении минимального значени€ коэффициента сухости поливать не нужно.
	 * @param waterAmount количество воды.
	 */
	public void water(int waterAmount) {
		mDryFactor -= waterAmount * DRY_FACTOR_WATER_DECREASING;
		if(mDryFactor < MIN_DRY_VALUE)
			mDryFactor = MIN_DRY_VALUE;
	}
	
	/** —обрать плоды.
	 * ѕри достижении минимального значени€ количества зрелых плодов собирать больше не нужно.
	 * @param ripeFruitsNumber количество собираемых плодов.
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
