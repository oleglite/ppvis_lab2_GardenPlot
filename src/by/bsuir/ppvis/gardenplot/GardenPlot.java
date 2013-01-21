package by.bsuir.ppvis.gardenplot;

/**  ласс, реализующий садовый участок.
 * @author Oleg Beloglazov
 *
 */
public class GardenPlot {
	
	// размер участка
	private int mSize;
	// количество растений (гр€док)
	private Plant[] mPlants;
	// склад с инструментами
	private InstrumentsStore mInstrumentStore = new InstrumentsStore();
	
	/**  онструктор, создающий участок со случайными растени€ми.
	 * @param size размер создаваемого участка.
	 */
	public GardenPlot(int size) {
		mSize = size;
		mPlants = new Plant[mSize];
		RandomPlantsCreator creator = new RandomPlantsCreator();
		for(int i = 0; i < mSize; i++) {
			mPlants[i] = creator.generateRandomPlant();
		}
	}
	
	/** ќбновить участок.
	 * ¬ызывает рост всех растений.
	 * 
	 */
	public void refresh() {
		for(Plant plant : mPlants) {
			plant.grow();
		}
	}
	
	/** ѕолучить информацию о растении.
	 * @param plantNumber номер гр€дки.
	 * @return информаци€.
	 */
	public String getPlantInfo(int plantNumber) {
		return mPlants[plantNumber].getInfo();
	}
	
	/** ѕроверить потребность растени€.
	 * @param plantNumber номер растени€.
	 * @return true, если потребность присутствует, иначе false.
	 */
	public boolean checkPlantNeed(int plantNumber, Plant.Need need) {
		return mPlants[plantNumber].checkNeed(need);
	}
	
	/** ѕолить растение.
	 * @param plantNumber номер гр€дки.
	 * @param implementName название инструмента.
	 * @throws BadInstrumentException если выбранный инструмент не подходит.
	 */
	public void waterTree(int plantNumber, String instrumentName) throws BadInstrumentException {
		Bucket bucket = (Bucket) getInstrument(instrumentName, Bucket.class);
		bucket.water(mPlants[plantNumber]);
	}
	
	/** —обрать плоды.
	 * @param plantNumber номер гр€дки.
	 * @param implementName название инструмента.
	 * @throws BadInstrumentException если выбранный инструмент не подходит.
	 */
	public void pickFruits(int plantNumber, String instrumentName) throws BadInstrumentException {
		Bucket bucket = (Bucket) getInstrument(instrumentName, Bucket.class);
		bucket.pickFruits(mPlants[plantNumber]);
	}
	
	/** ”далить сорн€к.
	 * @param plantNumber номер гр€дки.
	 * @param implementName навзание инструмента.
	 * @throws BadInstrumentException если выбранный инструмент не подходит.
	 */
	public void removeWeeds(int plantNumber, String instrumentName) throws BadInstrumentException {
		Scissors scissors = (Scissors) getInstrument(instrumentName, Scissors.class);
		scissors.cut(mPlants[plantNumber]);
	}
	
	/** ѕолучить названи€ инструментов.
	 * @return названи€ доступных инструментов.
	 */
	public String[] getInstrumentsNames() {
		return mInstrumentStore.getInstrumentsNames();
	}
	
	/** ѕолучить размер сада.
	 * @return размер сада (количество участков).
	 */
	public int getSize() {
		return mSize;
	}
	
	public class BadInstrumentException extends Exception {
		public BadInstrumentException(String instrumentName) {
			super("Ќе подход€щий инструмент: " + instrumentName);
		}
	}
	
	private Instrument getInstrument(String instrumentName, Class instumentClass) throws BadInstrumentException {
		Instrument instrument = mInstrumentStore.getInstrument(instrumentName);
		if(instumentClass.isInstance(instrument)) {
			return instrument;
		} else {
			throw new BadInstrumentException(instrumentName);
		}
	}
}
