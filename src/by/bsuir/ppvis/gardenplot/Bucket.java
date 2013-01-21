package by.bsuir.ppvis.gardenplot;

/** �����, ����������� ���������� �����.
 * @author Oleg Beloglazov
 *
 */
public class Bucket extends Instrument {
	
	// �������� ������� ����� ��-���������
	private static final int DEFAULT_CAPACITY = 5;
	
	// ������� �����
	private final int mCapacity;
	
	/** �����������, ��������������� �������� ������� ��-���������.
	 * 
	 */
	public Bucket() {
		this(DEFAULT_CAPACITY);
	}

	/** �����������, ��������������� ��������� �������.
	 * @param capacity �����������.
	 */
	public Bucket(int capacity) {
		super("�����");
		mCapacity = capacity;
	}
	
	/** ������ ��������.
	 * �������� ������ �������.
	 * @param plant ��������.
	 */
	public void water(Plant plant) {
		if(plant instanceof Tree) {
			Tree tree = (Tree) plant;
			while(tree.getDryFactor() > Tree.MIN_DRY_VALUE) {
				tree.water(mCapacity);
			}
		}
	}
	
	/** ������� �����.
	 * �������� ����� ������ � ��������.
	 * @param plant ��������.
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
