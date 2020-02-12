package models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Computer {

	private int id;
	private int quantityStudents;
	private int quantityTimesRequested;
	private ComputerState computerState;
	private long serviceTime;
	private Student currentStudent;
	
	public Computer(int id, int quantityStudents,ComputerState computerState) {
		this.id = id;
		this.quantityStudents = quantityStudents;
		this.quantityTimesRequested = 0;
		this.computerState = computerState;
		this.serviceTime = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantityStudents() {
		return quantityStudents;
	}

	public void setQuantityStudents(int quantityStudents) {
		this.quantityStudents = quantityStudents;
	}

	public int getQuantityTimesRequested() {
		return quantityTimesRequested;
	}

	public void setQuantityTimesRequested(int quantityTimesRequested) {
		this.quantityTimesRequested = quantityTimesRequested;
	}

	public ComputerState getComputerState() {
		return computerState;
	}

	public void setComputerState(ComputerState computerState) {
		this.computerState = computerState;
	}

	public long getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(long serviceTime) {
		this.serviceTime = serviceTime;
	}
	

	public Student getCurrentStudent() {
		return currentStudent;
	}

	public void setCurrentStudent(Student currentStudent) {
		this.currentStudent = currentStudent;
		this.computerState=ComputerState.OCCUPIED;
		quantityTimesRequested++;
		serviceTime+=currentStudent.getConsumptionTime();
		occupy();
	}
	
	private void occupy() {
		Timer timer = new Timer(500 * currentStudent.getConsumptionTime(), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				unSetStudent();
			}
		});
		timer.start();
	}

	public void unSetStudent() {
		this.currentStudent = null;
		this.computerState=defineState();
	}
	
	private ComputerState defineState() {
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

	@Override
	public String toString() {
		return "Computer [id=" + id + ", quantityStudents=" + quantityStudents + ", quantityTimesRequested="
				+ quantityTimesRequested + ", computerState=" + computerState + ", serviceTime=" + serviceTime + "]";
	}
}
