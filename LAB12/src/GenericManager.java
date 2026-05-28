import java.util.ArrayList;
import java.util.Collections;

public class GenericManager <T extends Comparable>{
    private ArrayList<T> cList;

    public GenericManager() {
        cList = new ArrayList<>();
    }

    public void add(T obj){
        cList.add(obj);
    }

    public void sort(){
        Collections.sort(cList);
    }

    public String find(T obj){
        String result = "";
        for(T st : cList){
            if(st.equals(obj)){
                result += st.toString();
            }
        }
        return result;
    }

    public String toString(){
        String result = "";
        for(T st : cList){
            result += st.toString();
        }
        return result;
    }

}
