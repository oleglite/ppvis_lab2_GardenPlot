package by.bsuir.ppvis.gardenplot;

/** ����������� ����� ��������.
 * @author Oleg Beloglazov
 *
 */
public abstract class Plant {
	
	/** ������������ ������������ ��������.
	 *
	 */
	public enum Need { NEEDS_WATER, NEEDS_PICK_FRUITS, NEEDS_REMOVE_WEEDS }
	
	/** ��������.
	 * 
	 */
	abstract public void grow();
	
	/** �������� ���������� � ��������.
	 * @return ����������.
	 */
	abstract public String getInfo();
	
	/** ��������� ����������� ��������.
	 * @param need �����������.
	 * @return true, ���� ����������� ������������, ����� false.
	 */
	abstract public boolean checkNeed(Need need);
}
