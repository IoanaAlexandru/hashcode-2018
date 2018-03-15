package hashcode_2018;

import java.util.*;

public class Car {
	public boolean isRiding;
	public Coordinates coord;
	public int distanceLeft;
	public Queue<Ride> rides;
	
	public Car() {
		rides = new LinkedList<Ride>();
		isRiding = false;
		coord = new Coordinates(0,0);
		distanceLeft = 0;
	}
	
	public void assignRide(Ride ride) {
		this.rides.add(ride);
		this.isRiding = true;
		distanceLeft += ride.start.distance(ride.finish);
		if (rides.isEmpty() == false) {
			distanceLeft += ride.start.distance(((LinkedList<Ride>) rides).peekLast().finish);
		}
	}
	
	
	public int distanceTo(Coordinates start) {
		if (isRiding == true)
			return distanceLeft + start.distance(((LinkedList<Ride>) rides).peekLast().finish);
		return coord.distance(start);
	}
	
	public boolean move(Coordinates dest) {
		if(coord.x < dest.x) {
			coord.x++;
			distanceLeft--;
		} else if (coord.x > dest.x) {
			coord.x--;
			distanceLeft--;
		} else if (coord.y < dest.y) {
			coord.y++;
			distanceLeft--;
		} else if (coord.y > dest.y) {
			coord.y--;
			distanceLeft--;
		} else { //destination reached;
						
			isRiding = false;
		}
		return isRiding;
	}
}
