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
		String commands = args[0];
		world.outPrintMap();
		for (int i = 0; i < commands.length(); i++) {
			Move.doCommands(commands.charAt(i));
			world.outPrintMap();
		}
	}

}
