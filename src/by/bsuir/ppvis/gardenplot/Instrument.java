package by.bsuir.ppvis.gardenplot;

/** Абстрактный класс инструмента.
 * @author Oleg Beloglazov
 *
 */
public abstract class Instrument {
	
	// название инструмента
	private final String mImplementName;
	
	/** Конструктор с указанием названия инструмента.
	 * @param name название инструмента.
	 */
	public Instrument(String name) {
		mImplementName = name;
	}
	
	/** Получить название инструмента.
	 * @return название инструмента.
	 */
	public String getName() {
		return mImplementName;
	}
}
