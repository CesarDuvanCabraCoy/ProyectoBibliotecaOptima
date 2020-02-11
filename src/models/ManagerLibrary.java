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
		//paintPCs();
		//simulationComputers(numberPCs);
//		similationDo(numberPCs);
	}
//	public void similationDo(int numberPCs) {
//		for (int i = 0; i < 20; i++) {
//			generateComputers(numberPCs);
//			computers.clear();
////			paintPCs();
////			simulationComputers(numberPCs);
//		
//			
//		}
//		
//	}
	
	private void generateComputers(int numberPCs) {
		for (int i = 0; i < numberPCs; i++) {
			computers.add(new Computer(i, defineQuantityStudents(),ComputerState.FREE));
		}
	}
	private void simulationComputers(int numberPCs) {
		for (int i = 0; i < numberPCs; i++) {
			computers.add(new Computer(i, defineQuantityStudents(),defineState()));
		}
	}
	
	public void paintPCs() {
		for (Computer computer : computers) {
			System.out.println(computer.getId() + " - " + computer.getQuantityStudents());
		}
	}
	private ComputerState defineState() {
		int ran = (int) (Math.random() * 100);
		System.out.println();
		ComputerState state = null;
		if (ran < 60) {
			state =ComputerState.FREE;
		}
		if (ran >= 60 && ran <=80) {
			state= ComputerState.OCCUPIED;
		}
		if (ran > 80){
			state= ComputerState.DAMAGED;
		}
		return state;
		
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
