package by.bsuir.ppvis.gardenplot.ui;

import javax.swing.table.AbstractTableModel;

import by.bsuir.ppvis.gardenplot.GardenPlot;
import by.bsuir.ppvis.gardenplot.Worker;

/** Модель таблицы сада.
 * @author Oleg Beloglazov
 *
 */
public class GardenTableModel extends AbstractTableModel {
	
	private GardenPlot mGardenPlot;
	private Worker mWorker;
	private String[] mColumnNames = {"", "Растение"};
	
	public GardenTableModel(GardenPlot gardenPlot, Worker worker) {
		mGardenPlot = gardenPlot;
		mWorker = worker;
	}

	@Override
	public int getRowCount() {
		return mGardenPlot.getSize();
	}

	@Override
	public int getColumnCount() {
		return mColumnNames.length;
	}
	
	public String getColumnName(int columnIndex) {
        return mColumnNames[columnIndex];
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				if(rowIndex == mWorker.getPosition()) {
					return " ∙";
				} else {
					return "";
				}
			case 1:
				return mGardenPlot.getPlantInfo(rowIndex);
	
			default:
				return "";
		}
	}

}
