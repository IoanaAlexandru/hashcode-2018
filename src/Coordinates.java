package hashcode_2018;

public class Coordinates {
	public int x, y;

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int distance(Coordinates dest) {
		return Math.abs(dest.x - x) + Math.abs(dest.y - y);
	}
	
	
}
