package rover;

public class Rover {
	static int[] position = {Mars.x / 2, Mars.y / 2};
	char state = '^';

	public static int[] findRover() {
		return position;
	}
}
