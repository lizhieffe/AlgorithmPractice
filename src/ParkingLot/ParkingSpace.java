package ParkingLot;

public class ParkingSpace {
	Vehicle vehicle;
	
	synchronized public boolean enter(Vehicle vehicle) {
		if (vehicle == null)
			return false;
		this.vehicle = vehicle;
//		enterTime = System.currentTimeMillis() / 1000L;
		vehicle.enterParkingSpace(this);
		System.out.println(vehicle + " is enterting parking space " + this);
		return true;
	}
	
	synchronized public void leave() {
		this.vehicle = null;
//		leaveTime = System.currentTimeMillis() / 1000L;
		vehicle.leaveParkingSpace();
		System.out.println(vehicle + " is leaving parking space " + this);
	}
	
	synchronized public void charge() {
		this.vehicle.calculateFee();
	}
}
