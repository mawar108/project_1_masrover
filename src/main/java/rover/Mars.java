package rover;

import java.util.Random;


public class Mars {

	static int x = 80;
	static int y = 20;

	static char[][] mars = new char[x][y];
	static char barrier = '#';
	static char air = ' ';
	Random random = new Random();


	public void initMap() {
		int halfX = x / 2;
		int halfY = y / 2;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				mars[i][j] = air;
				if (random.nextDouble() < 0.25) {
					mars[i][j] = barrier;
				}
			}
		}
		mars[halfX][halfY] = '^';
	}

	public void outPrintMap() {
		for (int j = 0; j < y; j++) {
			for (int i = 0; i < x; i++) {
				System.out.print(mars[i][j]);
			}
			System.out.println();
		}
		for (int i = 0; i < x; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
}