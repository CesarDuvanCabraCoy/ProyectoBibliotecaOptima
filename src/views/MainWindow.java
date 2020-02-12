package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controllers.MainController;
import models.Computer;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPMain jpMain;
	private JTBMain jtbMain;
	private MainController mainController;

	public MainWindow(MainController mainController) {
		this.mainController = mainController;
		this.setTitle(ConstantsGUI.TITLE_JF_MAIN);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.URL_IMAGE_ICON)).getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(700, 900));
		init();
		this.setVisible(true);
	}

	private void init() {
		jtbMain = new JTBMain(mainController);
		this.add(jtbMain, BorderLayout.NORTH);
		
		jpMain = new JPMain(mainController);
		this.add(jpMain);
	}
	
	public void updateBoard(ArrayList<Computer> computers) {
		jpMain.updateBoard(computers);
		this.repaint();
		this.revalidate();
	}

	public int getQuantityPcs() {
		return jpMain.getQuantityPcs();
	}
	
	public void setValueDays() {
		jpMain.setValueDays();
	}

	public void setValuePCs() {
		jpMain.setValuePCs();		
	}

	public void setValueServiceTime() {
		jpMain.setValueServiceTime();			
	}

	public void disableButtonInitSim() {
		jpMain.disableButtonInitSim();
		
	}

	public int getMaxTimeService() {
		return jpMain.getMaxTimeService();
	}
	
	public void setValueCurrentDay(int currentDay) {
		jpMain.setValueCurrentDay(currentDay);
	}
	
	public int getNumberOfDays() {
		return jpMain.getNumberOfDays();
	}
}
