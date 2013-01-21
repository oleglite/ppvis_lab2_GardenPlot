package by.bsuir.ppvis.gardenplot;

/** Абстрактный класс растения.
 * @author Oleg Beloglazov
 *
 */
public abstract class Plant {
	
	/** Перечисление потребностей растения.
	 *
	 */
	public enum Need { NEEDS_WATER, NEEDS_PICK_FRUITS, NEEDS_REMOVE_WEEDS }
	
	/** Подрасти.
	 * 
	 */
	abstract public void grow();
	
	/** Получить информацию о растении.
	 * @return информация.
	 */
	abstract public String getInfo();
	
	/** Проверить потребность растения.
	 * @param need потребность.
	 * @return true, если потребность присутствует, иначе false.
	 */
	abstract public boolean checkNeed(Need need);
}
