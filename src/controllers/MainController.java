package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import models.ManagerLibrary;
import views.JBoardStadisticas;
import views.MainWindow;

public class MainController implements ActionListener, ChangeListener{

	private MainWindow mainWindow;
	private ManagerLibrary managerLibrary;
	private JBoardStadisticas boardStadisticas;
	private Timer timerStudents;
	private boolean playing;
	
	public MainController() {
		managerLibrary = new ManagerLibrary();
		this.mainWindow = new MainWindow(this);
		boardStadisticas = new JBoardStadisticas();
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
		int numberOfDays = mainWindow.getNumberOfDays();
		managerLibrary.playSimulation(pcs, maxTimeService, numberOfDays);
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
					mainWindow.updateBoard(managerLibrary.getComputers());
					mainWindow.setValueStudentsAttended(managerLibrary.getAllStudents().size());
					mainWindow.setValueCurrentDay(managerLibrary.getNumberCurrentDay());
					Thread.sleep(20);
				}
				return null;
			}			
		};
		refreshBoard.execute();
	}
	
	private void validateNumberDays() {
		int students= 0;
		if (managerLibrary.getNumberCurrentDay() == managerLibrary.getNumberOfDays()) {
			playing = false;
			managerLibrary.stop();
			students=managerLibrary.getAllStudents().size()/managerLibrary.getNumberOfDays();
			boardStadisticas.paintStadistics(students, 121, 12, 12);
		}else {
			managerLibrary.initNewDay();
			//boardStadisticas.paintStadistics(students, 121, 12, 12);
			

			
			
			
		}
	}
	
	private void generateStudents() {
		timerStudents = new Timer(((int)(Math.random() * 700) + 70), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (playing) {
					managerLibrary.generateStudents();
					if (managerLibrary.getCurrentDayStudents().size() >= managerLibrary.getNumberMaxStudentsByDay()) {
						try {
							validateNumberDays();
							Thread.sleep(2000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
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
