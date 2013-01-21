package by.bsuir.ppvis.gardenplot;

/** �����, ����������� ���������� �������.
 * @author Oleg Beloglazov
 *
 */
public class Scissors extends Instrument {
	
	// ���������: false �������, true �������
	private boolean mState = false;
	// ������, ������� ����� �������
	private Weed mWeed = null;

	/** �������� �����������.
	 * 
	 */
	public Scissors() {
		super("�������");
	}
	
	/** ������� ��������.
	 * ������� ������ �������.
	 * @param plant ��������.
	 */
	public void cut(Plant plant) {
		if(plant instanceof Weed) {
			mWeed = (Weed) plant;			
		}
		open();
		close();
	}
	
	/** ������� �������.
	 * ������������� ����� ����� �������.
	 * 
	 */
	private void open() {
		if(mWeed != null && mState == false) {
			mWeed.cut(Weed.MIN_LENGTH);
			mState = true;
		}
	}
	
	/** ������� �������.
	 * 
	 */
	private void close() {
		if(mWeed != null) {
			mWeed = null;
		}
		mState = false;
	}

}
