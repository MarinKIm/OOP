public class Candidate implements Comparable<Candidate> {

    private class Vote{
        private int regionNum;
        public Vote(int regionNum)
        {
            this.regionNum = regionNum;
        }
    }

    private String name;
    private int numVotes;
    private Vote [] votes;

    public Candidate(String name, int maxVotes){
        this.name = name;
        this.numVotes = 0;
        votes = new Vote[maxVotes];
    }

    public synchronized void addVote(int regionNum){
        votes[numVotes++] = new Vote(regionNum);
    }


    public int compareTo(Candidate other) {
        return Integer.compare(other.numVotes, this.numVotes);
    }

    public String toString(){
        return "------------Candidate------------\n"
                + "Name: " + name + "\n"
                + "Votes: " + numVotes + "\n\n"
                + "==============================";
    }

}
