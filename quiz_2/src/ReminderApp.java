import java.util.Arrays;

public class ReminderApp {
    private Memo[] memos;
    int memoCount;
    public ReminderApp() {
        this.memos = new Memo[10];
        this.memoCount = 0;
    }
    public void addMemo(Memo memo){
        memos[memoCount++]=memo;
    }

    public void removeMemo(){
        memos[memoCount--]=null;
    }

    public String toString(){
        String ans="";
        Arrays.sort(memos,0,memoCount);
        for(int i=0;i<memoCount;i++){
            ans = ans + memos[i].toString();
        }
        return ans;
    }
}
