package hashcode_2018;

public class Ride {
	Coordinates start, finish;
	int earlierStart, latestFinish;
	int id;
	
	public Ride(Coordinates start, Coordinates finish, int earlierStart, int latestFinish, int id) {
		this.start = start;
		this.finish = finish;
		this.earlierStart = earlierStart;
		this.latestFinish = latestFinish;
		this.id = id;
	}
	
	
}