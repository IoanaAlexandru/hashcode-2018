package hashcode_2018;

import java.io.*;
import java.util.*;

public class Main {
	static int step;
	static List<Car> carlist = new ArrayList<>();
	static List<Ride> ridelist = new ArrayList<>();
	static int rows, col, fleet, rides, bonus, steps;

	public static Car minCar(Ride ride) {
		Car minCar = null;
		for (Car car : carlist) {
			if (ride.earlierStart - car.distanceTo(ride.start) < 0) { // doesn't arrive in time
				continue;
			}
			if (minCar == null || ((ride.earlierStart - car.distanceTo(ride.start)) < (ride.earlierStart
					- minCar.distanceTo(ride.start))) && ((car.distanceTo(ride.start) + ride.start.distance(ride.finish)) < ride.latestFinish)) {
				minCar = car;
			}
		}
				
		if (minCar == null) {
			for (Car car : carlist) {// no car can arrive to dest before finish
				if (minCar == null || ((car.distanceTo(ride.start) + ride.start.distance(ride.finish)) < ride.latestFinish)) {
					minCar = car;
				}
			}
		}
		
		if (minCar == null) {
			for (Car car : carlist) {// no car can arrive to dest before finish
				if (minCar == null || (ride.earlierStart - car.distanceTo(ride.start)) < (ride.earlierStart
						- minCar.distanceTo(ride.start))) {
					minCar = car;
				}
			}
		}

//		if (minCar == null) {
//			for (Car car : carlist) {// no car can arrive in time
//				if (minCar == null || (car.distanceTo(ride.start) < minCar.distanceTo(ride.start))) {
//					minCar = car;
//				}
//			}
//		}
		
		if (ride.start.distance(ride.finish) + minCar.distanceTo(ride.finish) > steps)
			minCar = null;

		return minCar;
	}

	public static void main(String[] args) {
		
		int a, b, x, y, s, f;
		Coordinates start, finish;

		try {
			Scanner in = new Scanner(new File("e_high_bonus.in"));
			rows = in.nextInt();
			col = in.nextInt();
			fleet = in.nextInt();
			rides = in.nextInt();
			bonus = in.nextInt();
			steps = in.nextInt();

			for (int i = 0; i < fleet; i++) {
				carlist.add(new Car());
			}

			for (int i = 0; i < rides; i++) {
				a = in.nextInt();
				b = in.nextInt();
				x = in.nextInt();
				y = in.nextInt();
				s = in.nextInt();
				f = in.nextInt();

				start = new Coordinates(a, b);
				finish = new Coordinates(x, y);
				ridelist.add(new Ride(start, finish, s, f, i));
			}

			in.close();
		} catch (IOException e) {
			System.out.println("File not found!");
		}

		for (Ride ride : ridelist) {
			Car minCar = minCar(ride);
			if (minCar != null)
				minCar.assignRide(ride);
		}

		try {
			PrintWriter out = new PrintWriter("e_high_bonus.out", "UTF-8");
			for (Car car : carlist) {
				out.print(car.rides.size() + " ");
				while (!car.rides.isEmpty()) {
					out.print(car.rides.poll().id + " ");
				}
				out.println();
			}

			out.close();
		} catch (IOException e) {
			System.out.println("Output file not found!");
		}

	}
}
