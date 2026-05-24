public class Region implements Runnable {

    private String name;
    private int regionNum;
    private int population;
    private Candidate[] candidates;

    public Region(String name, int regionNum, int population, Candidate[] candidates){
        this.name = name;
        this.regionNum = regionNum;
        this.population = population;
        this.candidates = candidates;
    }

    public void generateVotes(){
        int ranIndex = (int)(Math.random()*candidates.length);
        candidates[ranIndex].addVote(regionNum);
    }

    public void run(){
        for(int i=0; i<population; i++){
            generateVotes();
        }
    }
}
