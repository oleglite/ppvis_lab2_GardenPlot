package by.bsuir.ppvis.gardenplot;

/** �����, ����������� ������� �������.
 * @author Oleg Beloglazov
 *
 */
public class GardenPlot {
	
	// ������ �������
	private int mSize;
	// ���������� �������� (������)
	private Plant[] mPlants;
	// ����� � �������������
	private InstrumentsStore mInstrumentStore = new InstrumentsStore();
	
	/** �����������, ��������� ������� �� ���������� ����������.
	 * @param size ������ ������������ �������.
	 */
	public GardenPlot(int size) {
		mSize = size;
		mPlants = new Plant[mSize];
		RandomPlantsCreator creator = new RandomPlantsCreator();
		for(int i = 0; i < mSize; i++) {
			mPlants[i] = creator.generateRandomPlant();
		}
	}
	
	/** �������� �������.
	 * �������� ���� ���� ��������.
	 * 
	 */
	public void refresh() {
		for(Plant plant : mPlants) {
			plant.grow();
		}
	}
	
	/** �������� ���������� � ��������.
	 * @param plantNumber ����� ������.
	 * @return ����������.
	 */
	public String getPlantInfo(int plantNumber) {
		return mPlants[plantNumber].getInfo();
	}
	
	/** ��������� ����������� ��������.
	 * @param plantNumber ����� ��������.
	 * @return true, ���� ����������� ������������, ����� false.
	 */
	public boolean checkPlantNeed(int plantNumber, Plant.Need need) {
		return mPlants[plantNumber].checkNeed(need);
	}
	
	/** ������ ��������.
	 * @param plantNumber ����� ������.
	 * @param implementName �������� �����������.
	 * @throws BadInstrumentException ���� ��������� ���������� �� ��������.
	 */
	public void waterTree(int plantNumber, String instrumentName) throws BadInstrumentException {
		Bucket bucket = (Bucket) getInstrument(instrumentName, Bucket.class);
		bucket.water(mPlants[plantNumber]);
	}
	
	/** ������� �����.
	 * @param plantNumber ����� ������.
	 * @param implementName �������� �����������.
	 * @throws BadInstrumentException ���� ��������� ���������� �� ��������.
	 */
	public void pickFruits(int plantNumber, String instrumentName) throws BadInstrumentException {
		Bucket bucket = (Bucket) getInstrument(instrumentName, Bucket.class);
		bucket.pickFruits(mPlants[plantNumber]);
	}
	
	/** ������� ������.
	 * @param plantNumber ����� ������.
	 * @param implementName �������� �����������.
	 * @throws BadInstrumentException ���� ��������� ���������� �� ��������.
	 */
	public void removeWeeds(int plantNumber, String instrumentName) throws BadInstrumentException {
		Scissors scissors = (Scissors) getInstrument(instrumentName, Scissors.class);
		scissors.cut(mPlants[plantNumber]);
	}
	
	/** �������� �������� ������������.
	 * @return �������� ��������� ������������.
	 */
	public String[] getInstrumentsNames() {
		return mInstrumentStore.getInstrumentsNames();
	}
	
	/** �������� ������ ����.
	 * @return ������ ���� (���������� ��������).
	 */
	public int getSize() {
		return mSize;
	}
	
	public class BadInstrumentException extends Exception {
		public BadInstrumentException(String instrumentName) {
			super("�� ���������� ����������: " + instrumentName);
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
