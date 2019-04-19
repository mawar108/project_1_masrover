package rover;

import java.util.Random;


public class Mars {

	static int x = 80;
	static int y = 20;

	static char[][] mars = new char[x][y];
	static char hinderniss = '#';
	static Random random = new Random();

	public static char getSymbol(int[] postion) {
		char Sysmbol = mars[postion[0]][postion[1]];
		return Sysmbol;
	}

	public static int[] findRover() {
		for (int j = 0; j < y; j++) {
			for (int i = 0; i < x; i++) {
				if (mars[i][j] != ' ' && !"#".equals(mars[i][j])) {
					int[] position = {i, j};
					return position;
				}
			}
		}
		return null;
	}

	public void initMap() {
		int rx = x / 2;
		int ry = y / 2;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (random.nextDouble() < 0.25)
					mars[i][j] = hinderniss;
			}
		}
		mars[rx][ry] = '^';
	}

	public void outPrintMap() {
		for (int j = 0; j < y; j++) {
			for (int i = 0; i < x; i++) {
				int[] position = {i, j};
				System.out.print(mars[i][j]);


				/*if (getSymbol(position) == null) {
					System.out.print(" ");
					continue;
				}
				if ("#".equals(getSymbol(position)))
					System.out.print("#");
				else if ("n".equals(getSymbol(position)))
					System.out.print("^");
				else if ("s".equals(getSymbol(position)))
					System.out.print("V");
				else if ("e".equals(getSymbol(position)))
					System.out.print(">");
				if ("w".equals(getSymbol(position)))
					System.out.print("<");
			*/
			}
			System.out.println();
		}
		for (int i = 0; i < x; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
}



