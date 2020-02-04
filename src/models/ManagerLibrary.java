package models;

import java.util.ArrayList;

public class ManagerLibrary {

	private ArrayList<Computer> computers;
	
	public ManagerLibrary() {
		computers = new ArrayList<Computer>();
	}
	
	public void playSimulation(int numberPCs) {
		computers.clear();
		generateComputers(numberPCs);
	}
	
	private void generateComputers(int numberPCs) {
		for (int i = 0; i < numberPCs; i++) {
			computers.add(new Computer(i, defineQuantityStudents()));
		}
	}
	
	public void paintPCs() {
		for (Computer computer : computers) {
			System.out.println(computer.getId() + " - " + computer.getQuantityStudents());
		}
	}
	
	
	private byte defineQuantityStudents() {
		int ran = (int) (Math.random() * 10);
		if (ran <= 8) {
			return 1;
		}
		return 2;
	}
	
	public ArrayList<Computer> getComputers() {
		return computers;
	}
}
