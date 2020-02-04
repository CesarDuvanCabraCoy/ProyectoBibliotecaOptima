package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import controllers.MainController;

public class JPMain extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPData jpData;
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
	}

}
