package by.bsuir.ppvis.gardenplot;

/** Класс, реализующий склад с инструментами.
 * @author Oleg Beloglazov
 *
 */
public class InstrumentsStore {
	
	private String[] mInstrumentsNames;
	private Instrument[] mInstruments;
	
	public InstrumentsStore() {
		mInstruments = new Instrument[2];
		mInstruments[0] = new Bucket(5);
		mInstruments[1] = new Scissors();	
		
		updateInstrumentsNames();
	}
	
	/** Получить инструмент.
	 * @param instrumentName название инструмента.
	 * @return инструмент или null если инстумент с таким именем не найден.
	 */
	public Instrument getInstrument(String instrumentName) {
		for(Instrument instrument : mInstruments) {
			if(instrument.getName().equals(instrumentName))
				return instrument;
		}
		return null;
	}
	
	/** Получить названия всех инструментов.
	 * @return массив с названиями инструментов.
	 */
	public String[] getInstrumentsNames() {
		return mInstrumentsNames;
	}
	
	private void updateInstrumentsNames() {
		mInstrumentsNames = new String[mInstruments.length];
		for(int i = 0; i < mInstruments.length; i++) {
			mInstrumentsNames[i] = mInstruments[i].getName();
		}
	}
}
