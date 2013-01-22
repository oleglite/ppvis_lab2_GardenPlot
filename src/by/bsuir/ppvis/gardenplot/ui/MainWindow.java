package by.bsuir.ppvis.gardenplot.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import by.bsuir.ppvis.gardenplot.GardenPlot;
import by.bsuir.ppvis.gardenplot.GardenPlot.BadInstrumentException;
import by.bsuir.ppvis.gardenplot.Plant;
import by.bsuir.ppvis.gardenplot.Worker;

/** Главное окно программы.
 * @author Oleg Beloglazov
 *
 */
public class MainWindow extends JFrame implements ActionListener {
	
	private static final String STARTUP_DIALOG_MESSAGE = "Отобразить информацию?";
	private static final String STARTUP_DIALOG_TITLE = "Запуск системы";
	private static final String MAIN_WINDOW_TITLE = "Садовый участок";
	
	private static final String NEXT_BUTTON_TEXT = "Проверить и пройти далее";
	private static final String NEXT_ACTION_COMMAND = "Next";
	private static final String EXIT_BUTTON_TEXT = "Выйти";
	private static final String EXIT_ACTION_COMMAND = "Exit";
	
	private static final String ACTION_DIALOG_TITLE = "Садовник";
	private static final String ACTION_WATER_MESSAGE = "Растение нуждается в поливке, выполнить действие?";
	private static final String ACTION_PICK_MESSAGE = "Необходимо собрать плоды, выполнить действие?";
	private static final String ACTION_REMOVE_MESSAGE = "Необходимо срезать сорняки, выполнить действие?";
	private static final String ACTION_BAD_INSTRUMENT_MESSAGE = "Выбран не подходящий для данного действия инструмент!";
	
	private GardenPlot mGardenPlot;
	private Worker mWorker;
	private JTable mTable;
	private GardenTableModel mGardenTableModel;

	public static void main(String[] args) {		
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				int option = JOptionPane.showConfirmDialog(null, STARTUP_DIALOG_MESSAGE, STARTUP_DIALOG_TITLE, JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					new MainWindow().setVisible(true);
				} else {
					System.exit(0);
				}
				
			}
		});

	}
	
	public MainWindow() {
		mGardenPlot = new GardenPlot(10);
		mWorker = new Worker(mGardenPlot);
		
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setTitle(MAIN_WINDOW_TITLE);
				
		// создаём таблицу, в которой будет отображена информация о системе		
		mGardenTableModel = new GardenTableModel(mGardenPlot, mWorker);
		JTable mTable = new JTable(mGardenTableModel);
		mTable.getColumnModel().getColumn(0).setMaxWidth(16);
		mTable.setColumnSelectionAllowed(false);
		JScrollPane tableScrollPane = new JScrollPane(mTable);
		tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		// создаём кнопку перехода на следующий участок
		JButton nextButton = new JButton(NEXT_BUTTON_TEXT);
		nextButton.setActionCommand(NEXT_ACTION_COMMAND);
		nextButton.addActionListener(this);
		
		// создаём кнопку выхода из программы
		JButton exitButton = new JButton(EXIT_BUTTON_TEXT);
		exitButton.setActionCommand(EXIT_ACTION_COMMAND);
		exitButton.addActionListener(this);
		
		// создаём панель c кнопками
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		buttonsPanel.add(Box.createHorizontalGlue());
		buttonsPanel.add(nextButton);
		buttonsPanel.add(Box.createHorizontalStrut(10));
		buttonsPanel.add(exitButton);
		
		// размещаем таблицу и панель кнопок в окне
		setLayout(new BorderLayout());
		add(tableScrollPane, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
		
		pack();
	}
	
	/** Закрыть.
	 * Вызывает закрытие всей программы.
	 * 
	 */
	public void close() {
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(NEXT_ACTION_COMMAND.equals(e.getActionCommand())) {
			moveNextPlant();
		} else if (EXIT_ACTION_COMMAND.equals(e.getActionCommand())) {
			close();
		}
	}
	
	/** Проверить растение в текущем участке и пройти на следующий.
	 * 
	 */
	private void moveNextPlant() {
		int plantNumber = mWorker.getPosition();
		checkNeed(plantNumber, Plant.Need.NEEDS_PICK_FRUITS);
		checkNeed(plantNumber, Plant.Need.NEEDS_REMOVE_WEEDS);
		checkNeed(plantNumber, Plant.Need.NEEDS_WATER);
		mWorker.next();
		mGardenTableModel.fireTableDataChanged();
	}
	
	/** Проверить указанную потребность растения.
	 * @param plantNumber номер растения.
	 * @param need потребность.
	 */
	private void checkNeed(int plantNumber, Plant.Need need) {
		// в зависимости от потребности выбирается сообщениние диалогового окна
		String actionMessage = null;
		if(need == Plant.Need.NEEDS_PICK_FRUITS) {
			actionMessage = ACTION_PICK_MESSAGE;
		} else if(need == Plant.Need.NEEDS_REMOVE_WEEDS) {
			actionMessage = ACTION_REMOVE_MESSAGE;
		} else if(need == Plant.Need.NEEDS_WATER) {
			actionMessage = ACTION_WATER_MESSAGE;
		}
		while(true) {
			try {
				// если потребность существует и подтверждено её устарнение
				if(mGardenPlot.checkPlantNeed(plantNumber, need) && showActionConfirmDialog(actionMessage)) {
					// получить название инструмента с помощью диалогового окна
					String instrumentName = ChooseInstrumentDialog.showDialog(this, mGardenPlot.getInstrumentsNames());
					// в зависимости от типа потребности выполнить действие
					if(need == Plant.Need.NEEDS_PICK_FRUITS) {
						mGardenPlot.pickFruits(plantNumber, instrumentName);
					} else if(need == Plant.Need.NEEDS_REMOVE_WEEDS) {
						mGardenPlot.removeWeeds(plantNumber, instrumentName);
					} else if(need == Plant.Need.NEEDS_WATER) {
						mGardenPlot.waterTree(plantNumber, instrumentName);
					}
					mGardenTableModel.fireTableDataChanged();
				}
				// если потребность отсутствует, или она успешно устранена, выйти из цикла
				return;
			}
			// выбран не верный инструмент, показать сообщение и попробовать ещё раз
			catch(BadInstrumentException e) {
				JOptionPane.showMessageDialog(this, ACTION_BAD_INSTRUMENT_MESSAGE, ACTION_DIALOG_TITLE, JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	private boolean showActionConfirmDialog(String message) {
		int answer = JOptionPane.showConfirmDialog(this, message, ACTION_DIALOG_TITLE, JOptionPane.YES_NO_OPTION);
		return answer == JOptionPane.YES_OPTION;
	}

}
