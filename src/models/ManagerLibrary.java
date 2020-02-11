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
		similationDo(numberPCs);
	}
	public void similationDo(int numberPCs) {
		for (int i = 0; i < 20; i++) {
						//computers.clear();
			simulationComputers(numberPCs);
			//System.out.println(i);
		
			
		}
		
	}
	
	private void generateComputers(int numberPCs) {
		for (int i = 0; i < numberPCs; i++) {
			computers.add(new Computer(i, defineQuantityStudents(),defineStateInit()));
		}
	}
	private void simulationComputers(int numberPCs) {
		for (int i = 0; i < numberPCs; i++) {
			Computer computer= computers.get(i);
			computer.setComputerState(defineState());
			
		}
		System.out.println("******************Inicio de cambio de estdos");
		paintPCs();
	}
	
	public void paintPCs() {
		for (Computer computer : computers) {
			System.out.println(computer.getId() + " - " + computer.getQuantityStudents()+"- "+ computer.getComputerState());
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
	private ComputerState defineStateInit() {
		int ran = (int) (Math.random() * 100);
		System.out.println();
		ComputerState state = null;
		if (ran <= 90) {
			state =ComputerState.FREE;
		}
		
		if (ran > 90){
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
