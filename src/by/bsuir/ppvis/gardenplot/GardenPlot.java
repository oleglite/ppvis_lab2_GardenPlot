/**
 * 
 */
package by.bsuir.ppvis.gardenplot;

/**
 * @author Oleg Beloglazov
 *
 */
public class GardenPlot {
	
	private String mSize;
	
	private Plant[] mPlants;
	
	public void refresh() {
		
	}
	
	/** Полить растение.
	 * @param plantNumber номер грядки
	 * @param implementName название инструмента
	 */
	public void waterTree(int plantNumber, String implementName) {
		
	}
	
	/** Получить информацию о растении
	 * @param plantNumber номер грядки
	 * @return информация
	 */
	public String getPlantInfo(int plantNumber) {
		
		return null;
	}
	
	/** Собрать плоды
	 * @param plantNumber номер грядки
	 * @param implementName название инструмента
	 */
	public void pickFruits(int plantNumber, String implementName) {
		
	}
	
	/** Удалить сорняк
	 * @param plantNumber номер грядки
	 * @param implementName навзание инструмента
	 */
	public void removeWeeds(int plantNumber, String implementName) {
		
	}
}
