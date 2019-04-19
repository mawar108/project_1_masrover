package rover;

public class Move {

	public static void make(char c) {
		if (c == 'f') {
			befehlAusfuehrenF();
		} else if (c == 'b') {
			befehlAusfeuhrenB();
		} else if (c == 'r') {
			befehlAusfeuhrenR();
		} else if (c == 'l') {
			befehlAusfuehrenL();
		}

	}


	public static void befehlAusfuehrenF() {
		if (Rover.state == '^' && Rover.yposition - 1 >= 0 && Mars.mars[Rover.xposition][Rover.yposition - 1] != '#') {
			Mars.mars[Rover.xposition][Rover.yposition - 1] = Rover.state;
			Mars.mars[Rover.xposition][Rover.yposition] = Mars.Luft;
			Rover.yposition--;
		} else if (Rover.state == 'v' && Rover.yposition + 1 < Mars.y && Mars.mars[Rover.xposition][Rover.yposition + 1] != '#') {
			Mars.mars[Rover.xposition][Rover.yposition + 1] = Rover.state;
			Mars.mars[Rover.xposition][Rover.yposition] = Mars.Luft;
			Rover.yposition++;
		} else if (Rover.state == '<' && Rover.xposition - 1 >= 0 && Mars.mars[Rover.xposition - 1][Rover.yposition] != '#') {
			Mars.mars[Rover.xposition - 1][Rover.yposition] = Rover.state;
			Mars.mars[Rover.xposition][Rover.yposition] = Mars.Luft;
			Rover.xposition--;
		} else if (Rover.state == '>' && Rover.xposition + 1 < Mars.x && Mars.mars[Rover.xposition + 1][Rover.yposition] != '#') {
			Mars.mars[Rover.xposition + 1][Rover.yposition] = Rover.state;
			Mars.mars[Rover.xposition][Rover.yposition] = Mars.Luft;
			Rover.xposition++;
		}

	}

	public static void befehlAusfeuhrenB() {
		if (Rover.state == '^' && Rover.yposition + 1 < Mars.y && Mars.mars[Rover.xposition][Rover.yposition + 1] != '#') {
			Mars.mars[Rover.xposition][Rover.yposition + 1] = Rover.state;
			Mars.mars[Rover.xposition][Rover.yposition] = Mars.Luft;
			Rover.yposition++;
		} else if (Rover.state == 'v' && Rover.yposition - 1 >= 0 && Mars.mars[Rover.xposition][Rover.yposition - 1] != '#') {
			Mars.mars[Rover.xposition][Rover.yposition - 1] = Mars.Luft;
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
			Rover.yposition--;
		} else if (Rover.state == '<' && Rover.xposition + 1 < Mars.x && Mars.mars[Rover.xposition + 1][Rover.yposition] != '#') {
			Mars.mars[Rover.xposition + 1][Rover.yposition] = Mars.Luft;
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
			Rover.xposition++;
		} else if (Rover.state == '>' && Rover.xposition - 1 >= 0 && Mars.mars[Rover.xposition - 1][Rover.yposition] != '#') {
			Mars.mars[Rover.xposition - 1][Rover.yposition] = Mars.Luft;
			Mars.mars[Rover.xposition][Rover.yposition] = Rover.state;
			Rover.xposition--;
		}
	}

	public static void befehlAusfeuhrenR() {
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

	public static void befehlAusfuehrenL() {
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

