package by.bsuir.ppvis.gardenplot;

/** �����, ����������� ���������� �����.
 * @author Oleg Beloglazov
 *
 */
public class Bucket extends Instrument {
	
	private final int mCapacity;

	/** �������� �����������.
	 * @param capacity �����������.
	 */
	public Bucket(int capacity) {
		super("�����");
		mCapacity = capacity;
	}
	
	/** ������ ��������.
	 * @param plant ��������.
	 */
	public void water(Plant plant) {
		
	}
	
	private int calculateWaterAmount() {
		return 0;
	}
}
