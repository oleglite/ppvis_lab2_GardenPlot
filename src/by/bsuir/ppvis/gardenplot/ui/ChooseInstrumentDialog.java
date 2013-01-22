package by.bsuir.ppvis.gardenplot.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Spring;
import javax.swing.SpringLayout;

/**  ласс диалога выбора инструмента.
 * @author Oleg Beloglazov
 *
 */
public class ChooseInstrumentDialog extends JDialog implements ActionListener {
	
	private static final String OPTION_BUTTON_TEXT = "¬ыбрать";
	private static final String CONFIRM_BUTTON_TEXT = "ѕрименить";
	private static final String DIALOG_TITLE = "¬ыбор инструмента";
	private static final String EMPTY_INSTRUMENT_LABEL = "¬ыберите инструмент:";
	private static final String SELECTED_INSTRUMENT_LABEL = "¬ыбрано: ";
	private static final String CONFIRM_ACTION_COMMAND = "Confirm";
	
	private static ChooseInstrumentDialog mDialog;
	
	// названи€ инстументов
	private String[] mInstrumentsNames;
	// выбранный инструмент
	private static String mSelectedInstrument;
	
	private JLabel mSelectedInstrumentLabel;
	
	/** ѕоказать диалог выбора инструмента.
	 * @param owner владелец.
	 * @param instrumentsNames названи€ доступных инструментов.
	 * @return название выбранного инструмента или null, если ничего не выбрано.
	 */
	public static String showDialog(JFrame owner, String[] instrumentsNames) {
		mDialog = new ChooseInstrumentDialog(owner, instrumentsNames);
		mDialog.setLocation(owner.getLocation().x + 40, owner.getLocation().y + 40);
		mDialog.setVisible(true);
		return mSelectedInstrument;
	}
	
	/** ѕриватный конструктор, устанавливающий названи€ инструментов.
	 * @param owner владелец.
	 * @param instrumentsNames названи€ инструментов.
	 */
	private ChooseInstrumentDialog(JFrame owner, String[] instrumentsNames) {
		super(owner, DIALOG_TITLE, true);
		
		mInstrumentsNames = instrumentsNames;
		mSelectedInstrumentLabel = new JLabel(EMPTY_INSTRUMENT_LABEL);
		mSelectedInstrumentLabel.setAlignmentX(1);
		
		// создаЄм панель выбора инструмента
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		topPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		topPanel.add(mSelectedInstrumentLabel);
		topPanel.add(Box.createVerticalStrut(10));
		topPanel.add(createInstrumentsPanel());

		// создаЄм панель c кнопками
		JPanel buttonsPanel = new JPanel();
		JButton confirmButton = new JButton(CONFIRM_BUTTON_TEXT);
		confirmButton.addActionListener(this);
		confirmButton.setActionCommand(CONFIRM_ACTION_COMMAND);
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		buttonsPanel.add(Box.createHorizontalGlue());
		buttonsPanel.add(confirmButton);
		buttonsPanel.add(Box.createHorizontalGlue());

		// помещаем панели на contentPane
		Container contentPane = getContentPane();
		contentPane.add(topPanel, BorderLayout.CENTER);
		contentPane.add(buttonsPanel, BorderLayout.PAGE_END);
		
		pack();
		setResizable(false);		
	}
	
	/** —оздать панель инструментов.
	 * @return панель инструментов.
	 */
	private JPanel createInstrumentsPanel() {		
		GridLayout layout = new GridLayout(mInstrumentsNames.length, 2, 5, 5);
		JPanel panel = new JPanel(layout);
		
		for(int i = 0; i < mInstrumentsNames.length; i++) {
			panel.add(new JLabel(mInstrumentsNames[i]));
			JButton button = new JButton(OPTION_BUTTON_TEXT);
	        button.addActionListener(new InstrumentSelectedListener(mInstrumentsNames[i]));
	        panel.add(button);
		}
		
		return panel;
	}
	
	/** ¬ызывает изменение отображени€ выбранного инструмента.
	 * @param instrumentName название выбранного инструмента.
	 */
	private void selectInstrument(String instrumentName) {
		mSelectedInstrumentLabel.setText(SELECTED_INSTRUMENT_LABEL.concat(instrumentName));
	}
	
	private class InstrumentSelectedListener implements ActionListener {
		
		private String mInstrumentName;
		
		public InstrumentSelectedListener(String instrumentName) {
			mInstrumentName = instrumentName;			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			mSelectedInstrument = mInstrumentName;
			mDialog.selectInstrument(mInstrumentName);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(CONFIRM_ACTION_COMMAND.equals(e.getActionCommand())) {
			setVisible(false);
		}
	}

}
