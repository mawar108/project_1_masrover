package rover;

import java.util.Random;


public class Mars {

	static int x = 80;
	static int y = 20;

	static char[][] mars = new char[x][y];
	static char hinderniss = '#';
	static Random random = new Random();


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



