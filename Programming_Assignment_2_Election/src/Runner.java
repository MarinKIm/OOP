public class Runner {
    public static void main(String[] args) {
        if (args.length < 2) { System.err.println("Usage: Runner <input> <output>"); return; }
        ElectionSim eSim = new ElectionSim(args[0], args[1]);
        eSim.runSimulation();
    }
}
