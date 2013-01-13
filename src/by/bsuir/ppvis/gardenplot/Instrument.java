package by.bsuir.ppvis.gardenplot;

/** јбстрактный класс инструмента.
 * @author Oleg Beloglazov
 *
 */
public abstract class Instrument {
	
	private final String mImplementName;
	
	/** ќсновной конструктор
	 * @param name название инструмента
	 */
	public Instrument(String name) {
		mImplementName = name;
	}
	
	/** ѕолучить название инструмента
	 * @return название инструмента
	 */
	public String getName() {
		return mImplementName;
	}
}
