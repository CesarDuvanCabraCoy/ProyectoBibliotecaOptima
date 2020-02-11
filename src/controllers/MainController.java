package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import models.ManagerLibrary;
import views.MainWindow;

public class MainController implements ActionListener, ChangeListener{

	private MainWindow mainWindow;
	private ManagerLibrary managerLibrary;
	private Timer timerStudents;
	private boolean playing;
	
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
		int maxTimeService = mainWindow.getMaxTimeService();
		managerLibrary.playSimulation(pcs, maxTimeService);
		mainWindow.updateBoard(managerLibrary.getComputers());
		mainWindow.disableButtonInitSim();
		playing = true;
		managerLibrary.start();
		paintBoard();
		generateStudents();
	}
	
	private void paintBoard() {
		SwingWorker<Void, Void> refreshBoard = new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				while (playing) {
					System.out.println("Entra al paint");
					mainWindow.updateBoard(managerLibrary.getComputers());
					mainWindow.setValueCurrentDay(1);
					Thread.sleep(20);
				}
				return null;
			}
			
		};
		refreshBoard.execute();
	}
	
	private void generateStudents() {
		//TO DO Cambiar los valores del random
		timerStudents = new Timer(((int)(Math.random() * 600) + 10), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (playing) {
					managerLibrary.generateStudents();
				}
			}
		});
		timerStudents.start();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		switch (JSActions.valueOf(((JSlider)(e.getSource())).getName())) {
		case DAYS:
			System.out.println("Modificaci�n de hora");
			mainWindow.setValueDays();
			break;
		case PCS:
			System.out.println("Modificaci�n de pcs");
			mainWindow.setValuePCs();
			break;
		case SERVICE_TIME:
			System.out.println("Modificaci�n de service");
			mainWindow.setValueServiceTime();
			break;
		default:
			break;
		}
		
	}

	
	
}
