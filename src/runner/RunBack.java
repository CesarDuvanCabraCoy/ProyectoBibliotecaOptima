package runner;

import controllers.MainController;
import models.ManagerLibrary;

public class RunBack {

	public static void main(String[] args) {
		ManagerLibrary library= new ManagerLibrary();
		library.playSimulation(0, 0);
	}
}