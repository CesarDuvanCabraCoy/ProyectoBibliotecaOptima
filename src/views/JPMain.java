package views;

import java.awt.BorderLayout;
import java.awt.Color;
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
	private JScrollPane jScrollBar;
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
//		this.add(jpBoard, BorderLayout.CENTER);
		JScrollPane scrollableTextArea = new JScrollPane(jpBoard); 
		scrollableTextArea.setSize(this.getWidth(), this.getHeight());
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jpBoard.repaint();
		this.add(scrollableTextArea);
		repaint();
	}

	public void updateBoard(ArrayList<Computer> computers) {
		jpBoard.updateBoard(computers);
		this.revalidate();
	}

	public int getQuantityPcs() {
		return jpData.getDataPCs();
	}
	
}
