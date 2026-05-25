public class SimTest {
    private static final String INPUTFILE = "/Users/marinkim/OOP/Programming_Assignment_2_Election/inputfile.txt";
    private static final String OUTPUTFILE = "/Users/marinkim/OOP/Programming_Assignment_2_Election/outputfile.txt";
    public static void main(String[] args){

        ElectionSim eSim = new ElectionSim(INPUTFILE, OUTPUTFILE);
        eSim.runSimulation();
    }
}
