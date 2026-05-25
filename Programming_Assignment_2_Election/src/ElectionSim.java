import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ElectionSim {

    private String outputFile;
    private int population;
    private Candidate[] candidates;
    private Region[] regions;

    public ElectionSim(String inputFile, String outputFile) {
        this.outputFile = outputFile;

        try (Scanner sc = new Scanner(new File(inputFile))) {

            sc.next();
            population = sc.nextInt();

            sc.next();
            int numCandidates = sc.nextInt();
            candidates = new Candidate[numCandidates];
            for (int i = 0; i < numCandidates; i++) {
                candidates[i] = new Candidate(sc.next(), population);
            }

            sc.next();
            int numRegions = sc.nextInt();
            regions = new Region[numRegions];
            for (int i = 0; i < numRegions; i++) {
                String rName = sc.next();
                int    rNum  = sc.nextInt();
                int    rPop  = sc.nextInt();
                regions[i] = new Region(rName, rNum, rPop, candidates);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + inputFile);
            e.printStackTrace();
        }
    }

    public void saveData() {
        Arrays.sort(candidates);

        try (PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {
            for (Candidate c : candidates) {
                pw.println(c.toString());
            }
        } catch (IOException e) {
            System.err.println("Failed to write output file: " + outputFile);
            e.printStackTrace();
        }
    }

    public void runSimulation() {
        Thread[] threads = new Thread[regions.length];

        for (int i = 0; i < regions.length; i++) {
            threads[i] = new Thread(regions[i]);
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        saveData();
    }
}

