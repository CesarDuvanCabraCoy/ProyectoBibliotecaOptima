package models;

public class Student {

	private long id;
	private int consumptionTime;
	private boolean isWithCompanion;
	
	public Student(long id, int consumptionTime) {
		this.id = id;
		this.consumptionTime = consumptionTime;
		defineCompanion();
	}
	
	private void defineCompanion() {
		int val = (int)Math.random()*10 +1;
		if (val <= 8) {
			setWithCompanion(false);
		}else {
			setWithCompanion(true);
		}
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

	public boolean isWithCompanion() {
		return isWithCompanion;
	}

	public void setWithCompanion(boolean isWithCompanion) {
		this.isWithCompanion = isWithCompanion;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", consumptionTime=" + consumptionTime + "]";
	}	
}
