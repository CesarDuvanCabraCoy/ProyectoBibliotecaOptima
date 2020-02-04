package views;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.MainController;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPData jpData;
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
		init();
		this.setVisible(true);
	}

	private void init() {
		jtbMain = new JTBMain(mainController);
		this.add(jtbMain, BorderLayout.NORTH);
		
		jpMain = new JPMain(mainController);
		this.add(jpMain, BorderLayout.CENTER);
	}
	
}
