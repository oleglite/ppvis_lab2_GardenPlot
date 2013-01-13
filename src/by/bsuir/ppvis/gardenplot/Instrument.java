package by.bsuir.ppvis.gardenplot;

/** ����������� ����� �����������.
 * @author Oleg Beloglazov
 *
 */
public abstract class Instrument {
	
	private final String mImplementName;
	
	/** �������� �����������
	 * @param name �������� �����������
	 */
	public Instrument(String name) {
		mImplementName = name;
	}
	
	/** �������� �������� �����������
	 * @return �������� �����������
	 */
	public String getName() {
		return mImplementName;
	}
}
