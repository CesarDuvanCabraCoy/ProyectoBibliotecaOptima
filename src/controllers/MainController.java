package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import models.ManagerLibrary;
import views.MainWindow;

public class MainController implements ActionListener, ChangeListener{

	private MainWindow mainWindow;
	private ManagerLibrary managerLibrary;
	
	public MainController() {
		managerLibrary = new ManagerLibrary();
		this.mainWindow = new MainWindow(this);
		mainWindow.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (JBActions.valueOf(event.getActionCommand())) {
		case PLAY_SIMULATION:
			playSimulation();
			break;

		default:
			break;
		}
		
	}

	private void playSimulation() {
		int pcs = mainWindow.getQuantityPcs();
		managerLibrary.playSimulation(pcs);
		mainWindow.updateBoard(managerLibrary.getComputers());
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		switch (JSActions.valueOf(((JSlider)(e.getSource())).getName())) {
		case HOUR:
			System.out.println("Modificacion de hora");
			break;
		case PCS:
			System.out.println("Modificacion de pcs");
			break;
		case SERVICE_TIME:
			System.out.println("Modificacion de service");
			break;
		default:
			break;
		}
		
	}

	
	
}
