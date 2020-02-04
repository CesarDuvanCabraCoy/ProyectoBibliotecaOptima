package models;

public class Student {

	private long id;
	private int consumptionTime;
	
	public Student(long id, int consumptionTime) {
		this.id = id;
		this.consumptionTime = consumptionTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getConsumptionTime() {
		return consumptionTime;
	}

	public void setConsumptionTime(int consumptionTime) {
		this.consumptionTime = consumptionTime;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", consumptionTime=" + consumptionTime + "]";
	}	
}
