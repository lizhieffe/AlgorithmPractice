package ParkingLot;

public abstract class Vehicle {
	PriceCalculator priceCalculator;
	String plateNumber;
	ParkingSpace parkingSpace;
	long enterTime;
	long leaveTime;
	
	public Vehicle(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public String getPlateNumber() {
		return plateNumber;
	}
	
	public void enterParkingSpace(ParkingSpace ps) {
		this.parkingSpace = ps;
		enterTime = System.currentTimeMillis() / 1000L;
	}
	
	public void leaveParkingSpace() {
		this.parkingSpace = null;
	}
	
	public void charge(int amount) {
		System.out.println(this + " is charged " + amount);
	}
	
	public int calculateFee() {
		return priceCalculator.calculate(leaveTime - enterTime);
	}
}
