package rover;


public class Start {
	public static void main(String[] args) {
		Mars world = new Mars();
		if (args.length > 1) {
			long seed = Long.parseLong(args[1]);
			world.random.setSeed(seed);
			// System.out.println("Seed: " + seed);
		}

		world.initMap();
		String befehl = args[0];
		world.outPrintMap();
		for (int i = 0; i < befehl.length(); i++) {

			world.outPrintMap();
		}
		//Mars.mars[40][10] = " ";
		//World.outPrintMap();
		int[] a = Rover.findRover();
		System.out.println(a[0] + "" + a[1]);
	}

}

/*
package rover;

public class Start {

	static Random random = new Random();
	static LinkedHashMap<int[], String> mars;

	public static void initMap() { // Hashs werden auf der Map random generiert
		mars = new LinkedHashMap<>();
		int x = 80;
		int y = 20;
		int rx = x / 2;
		int ry = y / 2;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				int[] p = new int[] { i, j };
				if (random.nextDouble() < 0.25 && !(rx == i && ry== j))
					mars.put(p, "#");
			}
		}
		mars.put(new int[] { rx, ry }, "n");    // Startposition des rovers
	}

	public static int[] maximum(Set<int[]> set) { // Gibt die Größe der Map an
		int[] x = new int[2];
		for (int[] e : set) {
			if (e[0] > x[0])
				x[0] = e[0];
			if (e[1] > x[1])
				x[1] = e[1];
		}
		return x;
	}

	public static String getSymbol(Map<int[], String> kloetze, int[] p) {
		Set<Entry<int[], String>> entrySet = kloetze.entrySet();
		for (Entry<int[], String> entry : entrySet) {
			if (entry.getKey()[0] == p[0] && entry.getKey()[1] == p[1])
				return entry.getValue();
		}
		return null;
	}

	public static void outPrintMap() {  // Umseetzung von Buchstaben zum Pfeil
		// Set<int[]> keySet = mars.keySet();
		// for (int[] e : keySet) {
		// if (e[0] == 39 && e[1] == 10)
		// System.err.println(mars.get(e) + " " + e.hashCode());
		// }

		int[] max = maximum(mars.keySet());
		for (int j = 0; j <= max[1]; j++) {
			for (int i = 0; i <= max[0]; i++) {
				// System.out.println(i + "," + j + ": " + get(mars, new int[] { i, j }));

				if (getSymbol(mars, new int[] { i, j }) == null) {
					System.out.print(" ");
					continue;
				}
				if ("#".equals(getSymbol(mars, new int[] { i, j })))
					System.out.print("#");
				else if ("n".equals(getSymbol(mars, new int[] { i, j })))
					System.out.print("^");
				else if ("s".equals(getSymbol(mars, new int[] { i, j })))
					System.out.print("V");
				else if ("e".equals(getSymbol(mars, new int[] { i, j })))
					System.out.print(">");
				if ("w".equals(getSymbol(mars, new int[] { i, j })))
					System.out.print("<");

			}
			System.out.println();
		}
		for (int i = 0; i < max[0]; i++) {
			System.out.print("=");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		if (args.length > 1) {
			long seed = Long.parseLong(args[1]);
			random.setSeed(seed);
			// System.out.println("Seed: " + seed);
		}
		initMap();
		String pg = args[0];
		outPrintMap();
		for (int i = 0; i < pg.length(); i++) {
			move(pg.charAt(i));
			navigate(pg.charAt(i));
			outPrintMap();
		}
		//int [] position= maximum(mars.keySet());
		//System.out.println(position [0]+ "," + position [1]);
		//System.out.println(getSymbol(mars,position));

	}

	public static boolean FrontWestCrashTest(int [] position) {
		position[0]--;
		if (("#".equals(getSymbol(mars, position)))) {
			position[0]++;
			return true;
		} else {
			position[0]++;
			return false;
		}
	}

	public static boolean FrontNordCrashTest(int  [] position) {
		position[1]--;
		if (("#".equals(getSymbol(mars, position)))) {
			position[1]++;
			return true;
		} else {
			position[1]++;
			return false;
		}
	}

	public static boolean FrontSouthCrashTest(int  [] position) {
		position[1]++;
		if (("#".equals(getSymbol(mars, position)))) {
			position[1]--;
			return true;
		} else {
			position[1]--;
			return false;
		}
	}


	public static boolean FrontEastCrashTest(int [] position){
		position[0]++;
		if (("#".equals(getSymbol(mars, position)))) {
			position[0]--;
			return true;
		} else {
			position[0]--;
			return false;
		}
	}

	public static boolean BackNordCrashTest(int [] position){
		position[1]++;
		if (("#".equals(getSymbol(mars, position)))) {
			position[1]--;
			return true;
		} else {
			position[1]--;
			return false;
		}
	}

	public static boolean BackSouthCrashTest(int [] position){
		position[1]--;
		if (("#".equals(getSymbol(mars, position)))) {
			position[1]++;
			return true;
		} else {
			position[1]++;
			return false;
		}
	}

	public static boolean BackEastCrashTest(int [] position){
		position[0]--;
		if (("#".equals(getSymbol(mars, position)))) {
			position[0]++;
			return true;
		} else {
			position[0]++;
			return false;
		}
	}

	public static boolean BackWestCrashTest(int [] position){
		position[0]++;
		if (("#".equals(getSymbol(mars, position)))) {
			position[0]--;
			return true;
		} else {
			position[0]--;
			return false;
		}
	}

	public static void move(char c) { //make wurde auf move und navigate aufgeteilt um die Übersicht zu erhöhen
		if (c == 'f') {
			int[] position = findRover();
			if ("n".equals(getSymbol(mars, position)) && !FrontNordCrashTest(position))
				position[1]--;
			else if ("s".equals(getSymbol(mars, position)) && !FrontSouthCrashTest(position))
				position[1]++;
			else if ("e".equals(getSymbol(mars, position)) && !FrontEastCrashTest(position))
				position[0]++;
			else if ("w".equals(getSymbol(mars, position)) && !FrontWestCrashTest(position))
				position[0]--;
		} else if (c == 'b') {
			int[] position = findRover();
			if ("s".equals(getSymbol(mars, position)) && !BackSouthCrashTest(position))
				position[1]--;
			else if ("n".equals(getSymbol(mars, position)) && !BackNordCrashTest(position))
				position[1]++;
			else if ("w".equals(getSymbol(mars, position)) && !BackWestCrashTest(position))
				position[0]++;
			else if ("e".equals(getSymbol(mars, position)) && !BackEastCrashTest(position))
				position[0]--;
		}
	}


	public static void navigate(char c){
		if (c == 'l') {
			int[] position = findRover();
			if ("n".equals(getSymbol(mars, position)))
				mars.put(position, "w");
			else if ("s".equals(getSymbol(mars, position)))
				mars.put(position, "e");
			else if ("e".equals(getSymbol(mars, position)))
				mars.put(position, "n");
			else if ("w".equals(getSymbol(mars, position)))
				mars.put(position, "s");
		} else if (c == 'r') {
			int[] position = findRover();
			if ("w".equals(getSymbol(mars, position)))
				mars.put(position, "n");
			else if ("e".equals(getSymbol(mars, position)))
				mars.put(position, "s");
			else if ("n".equals(getSymbol(mars, position)))
				mars.put(position, "e");
			else if ("s".equals(getSymbol(mars, position)))
				mars.put(position, "w");
		}

	}

	private static int[] findRover() {
		Set<Entry<int[], String>> entrySet = mars.entrySet();
		for (Entry<int[], String> entry : entrySet) {
			if (entry.getValue() != null && !entry.getValue().equals("#")) {
				int [] foo= entry.getKey();
				if(foo [0] >= 0 && foo [0] <= 79 && foo[1] >= 0 && foo[1] <= 19)
					return entry.getKey();
			}
		}
		throw new IllegalStateException("Rover missing in action");
	}

}
*/