package rover;

public class Move {

	public static void doCommands(char c) {
		if (c == 'f') {
			doForward();
		} else if (c == 'b') {
			doBack();
		} else if (c == 'r') {
			doRight();
		} else if (c == 'l') {
			doLeft();
		}

	}


	public static void doForward() {
		if (Rover.state == '^' && Rover.yposition - 1 >= 0 && Mars.mars[Rover.xposition][Rover.yposition - 1] != '#') {
			Mars.mars[Rover.xposition][Rover.yposition - 1] = Rover.state;
			Mars.mars[Rover.xposition][Rover.yposition] = Mars.air;
			Rover.yposition--;
		} else if (Rover.state == 'v' && Rover.yposition + 1 < Mars.y && Mars.mars[Rover.xposition][Rover.yposition + 1] != '#') {
			Mars.mars[Rover.xposition][Rover.yposition + 1] = Rover.state;
			Mars.mars[Rover.xposition][Rover.yposition] = Mars.air;
			Rover.yposition++;
		} else if (Rover.state == '<' && Rover.xposition - 1 >= 0 && Mars.mars[Rover.xposition - 1][Rover.yposition] != '#') {
			Mars.mars[Rover.xposition - 1][Rover.yposition] = Rover.state;
			Mars.mars[Rover.xposition][Rover.yposition] = Mars.air;
			Rover.xposition--;
		} else if (Rover.state == '>' && Rover.xposition + 1 < Mars.x && Mars.mars[Rover.xposition + 1][Rover.yposition] != '#') {
			Mars.mars[Rover.xposition + 1][Rover.yposition] = Rover.state;
			Mars.mars[Rover.xposition][Rover.yposition] = Mars.air;
			Rover.xposition++;
		}

	}

	public static void doBack() {
		if (Rover.state == '^' && Rover.yposition + 1 < Mars.y && Mars.mars[Rover.xposition][Rover.yposition + 1] != '#') {
			Mars.mars[Rover.xposition][Rover.yposition + 1] = Rover.state;
			Mars.mars[Rover.xposition][Rover.yposition] = Mars.air;
			Rover.yposition++;
		} else if (Rover.state == 'v' && Rover.yposition - 1 >= 0 && Mars.mars[Rover.xposition][Rover.yposition - 1] != '#') {
			Mars.mars[Rover.xposition][Rover.yposition - 1] = Mars.air;
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
			Rover.yposition--;
		} else if (Rover.state == '<' && Rover.xposition + 1 < Mars.x && Mars.mars[Rover.xposition + 1][Rover.yposition] != '#') {
			Mars.mars[Rover.xposition + 1][Rover.yposition] = Mars.air;
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
			Rover.xposition++;
		} else if (Rover.state == '>' && Rover.xposition - 1 >= 0 && Mars.mars[Rover.xposition - 1][Rover.yposition] != '#') {
			Mars.mars[Rover.xposition - 1][Rover.yposition] = Mars.air;
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
			Rover.xposition--;
		}
	}

	public static void doRight() {
		if (Rover.state == '^') {
			Rover.state = '>';
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
		} else if (Rover.state == 'v') {
			Rover.state = '<';
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
		} else if (Rover.state == '<') {
			Rover.state = '^';
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
		} else if (Rover.state == '>') {
			Rover.state = 'v';
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
		}
	}

	public static void doLeft() {
		if (Rover.state == '^') {
			Rover.state = '<';
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
		} else if (Rover.state == 'v') {
			Rover.state = '>';
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
		} else if (Rover.state == '<') {
			Rover.state = 'v';
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
		} else if (Rover.state == '>') {
			Rover.state = '^';
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
		}
	}
}

