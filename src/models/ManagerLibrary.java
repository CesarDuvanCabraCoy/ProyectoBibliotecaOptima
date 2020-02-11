package models;

import java.util.ArrayList;

public class ManagerLibrary extends MyThread{

	private ArrayList<Computer> computers;
	private ArrayList<Student> queueStudents;
	private ArrayList<Student> currentStudents;
	private ArrayList<Student> allStudents;
	private int maxTimeConsumption;

	
	public ManagerLibrary() {
		super(10);
		computers = new ArrayList<Computer>();
		queueStudents = new ArrayList<Student>();
		currentStudents = new ArrayList<Student>();
		allStudents = new ArrayList<Student>();
	}
	
	public void playSimulation(int numberPCs, int maxTimeConsumption) {
		
		computers.clear();
		generateComputers(numberPCs);
//		similationDo(numberPCs);
		this.maxTimeConsumption = maxTimeConsumption;
	}
	public void similationDo(int numberPCs) {
		
		this.start();
		simulationComputers(numberPCs);
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
		System.out.println("****************** Cambio de estados");
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
	
	private int defineTimeConsumptionForStudent() {
		return (int)(Math.random() * maxTimeConsumption)+20;
	}

	public void generateStudents() {
		Student st = new Student(allStudents.size(), defineTimeConsumptionForStudent());
		allStudents.add(st);
		queueStudents.add(st);
		System.out.println("Se agrego un estudiante: " + st.getId());
	}
	
	public void occupyPC() {
		if (!queueStudents.isEmpty()) {
			Student st = queueStudents.get(0);
			Computer com = choosePcFree();
			if (com != null) {
				com.setCurrentStudent(st);
				queueStudents.remove(0);
			}
		}
	}
	
	private Computer choosePcFree() {
		for (Computer computer : computers) {
			if (computer.getComputerState() == ComputerState.FREE) {
				return computer;
			}
		}
		return null;
	}

	@Override
	void executeTask() {
		occupyPC();
	}
}
