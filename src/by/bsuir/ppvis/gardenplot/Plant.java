/**
 * 
 */
package by.bsuir.ppvis.gardenplot;

/**
 * @author Oleg Beloglazov
 *
 */
public abstract class Plant {
	
	/** Подрасти
	 * 
	 */
	abstract public void grow();
	
	/** Получить информацию о растении
	 * @return информация
	 */
	abstract public String getInfo();
}
