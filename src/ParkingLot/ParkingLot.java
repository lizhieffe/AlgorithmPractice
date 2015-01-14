package ParkingLot;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParkingLot {
	private static int SIZE = 10;
	List<ParkingSpace> available;
	List<ParkingSpace> unavailable;
	Map<String, ParkingSpace> relation;
	
	public ParkingLot() {
		available = new LinkedList<ParkingSpace>();
		for (int i = 0; i < SIZE; i++)
			available.add(new ParkingSpace());
		unavailable = new LinkedList<ParkingSpace>();
		relation = new HashMap<String, ParkingSpace>();
	}
	
	synchronized public boolean isAvailable() {
		return available.size() != 0 ? true : false;
	}
	
	synchronized public boolean enter(Vehicle vehicle) {
		if (!isAvailable() || relation.containsKey(vehicle.getPlateNumber()))
			return false;
		ParkingSpace space = findAvailable();
		space.enter(vehicle);
		unavailable.add(space);
		relation.put(vehicle.getPlateNumber(), space);
		return true;
	}
	
	synchronized public void leave(Vehicle vehicle) {
		ParkingSpace space = relation.get(vehicle.getPlateNumber());
		if (space == null)
			return;
		unavailable.remove(space);
		available.add(space);
		space.leave();
	}
	
	private ParkingSpace findAvailable() {
		return available.remove(0);
	}
}
