public class Candidate implements Comparble<Candidate> {

    public class Vote{
        int regionNum;
        Vote(int regionNum)
        {
            this.regionNum = regionNum;
        }
    }

    String name;
    int numVotes;
    Vote [] votes;

    public Candidate(String name, int maxVotes){
        this.name = name;
        this.numVotes = 0;
        votes = new Vote[maxVotes];
    }

    public synchronized void addVote(int regionNum){
        votes[numVotes++] = new Vote(regionNum);
    }



    public String toString(){
        return "------------Candidate-----------\n"
                + "Name: " + name + "\n"
                + "Votes: " + numVotes + "\n\n"
                + "==============================";
    }

}
