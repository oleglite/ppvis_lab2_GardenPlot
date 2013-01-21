package by.bsuir.ppvis.gardenplot;

/** ����� ��������, �������� �� ����������� �� ����.
 * @author Oleg Beloglazov
 *
 */
public class Worker {
	
	private int mPosition = 0;
	private GardenPlot mGardenPlot;
	
	public Worker(GardenPlot gardenPlot) {
		mGardenPlot = gardenPlot;
	}
	
	/** ������ �� ���� ������ �����, ��� ���������� ���������� ��������� �� ������.
	 * 
	 */
	public void next() {
		mPosition++;
		if(mPosition >= mGardenPlot.getSize()) {
			mPosition = 0;
			mGardenPlot.refresh();
		}
	}
	
	/** �������� ��������� ��������.
	 * @return ���������.
	 */
	public int getPosition() {
		return mPosition;
	}
}
