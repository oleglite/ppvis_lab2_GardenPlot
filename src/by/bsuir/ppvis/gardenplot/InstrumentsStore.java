package by.bsuir.ppvis.gardenplot;

/** �����, ����������� ����� � �������������.
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
	
	/** �������� ����������.
	 * @param instrumentName �������� �����������.
	 * @return ���������� ��� null ���� ��������� � ����� ������ �� ������.
	 */
	public Instrument getInstrument(String instrumentName) {
		for(Instrument instrument : mInstruments) {
			if(instrument.getName().equals(instrumentName))
				return instrument;
		}
		return null;
	}
	
	/** �������� �������� ���� ������������.
	 * @return ������ � ���������� ������������.
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
