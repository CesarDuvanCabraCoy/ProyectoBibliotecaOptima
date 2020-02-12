package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import controllers.MainController;
import models.Computer;

public class JPMain extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPData jpData;
	private JPBoard jpBoard;
	private MainController mainController;
	
	
	public JPMain(MainController mainController) {
		this.mainController = mainController;
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		init();
	}

	private void init() {
		jpData = new JPData(mainController);
		this.add(jpData, BorderLayout.NORTH);
		
		jpBoard = new JPBoard();
		JScrollPane jscp = new JScrollPane(jpBoard);
		jscp.setViewportView(jpBoard);
		this.add(jpBoard, BorderLayout.CENTER);
//		this.add(jpBoard, BorderLayout.CENTER);
	}

	public void updateBoard(ArrayList<Computer> computers) {
		jpBoard.updateBoard(computers);
		this.repaint();
	}

	public int getQuantityPcs() {
		return jpData.getDataPCs();
	}
	
	public void setValueDays() {
		jpData.setValueDays();
	}

	public void setValuePCs() {
		jpData.setValuePCs();
	}

	public void setValueServiceTime() {
		jpData.setValueServiceTime();		
	}

	public void disableButtonInitSim() {
		jpData.disableButtonInitSim();
		
	}

	public int getMaxTimeService() {
		return jpData.getDataServiceTime();
	}
	
	public void setValueCurrentDay(int currentDay) {
		jpData.setValueCurrentDay(currentDay);
	}
	
	public int getNumberOfDays() {
		return jpData.getDataDays();
	}
	
}
