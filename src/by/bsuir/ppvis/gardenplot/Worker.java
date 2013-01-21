package by.bsuir.ppvis.gardenplot;

/**  ласс рабочего, отвечает за перемещение по саду.
 * @author Oleg Beloglazov
 *
 */
public class Worker {
	
	private int mPosition = 0;
	private GardenPlot mGardenPlot;
	
	public Worker(GardenPlot gardenPlot) {
		mGardenPlot = gardenPlot;
	}
	
	/** ѕройти на один учаток вперЄд, при достижении последнего вернутьс€ на первый.
	 * 
	 */
	public void next() {
		mPosition++;
		if(mPosition >= mGardenPlot.getSize()) {
			mPosition = 0;
			mGardenPlot.refresh();
		}
	}
	
	/** ѕолучить положение рабочего.
	 * @return положение.
	 */
	public int getPosition() {
		return mPosition;
	}
}
