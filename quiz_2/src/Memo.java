public class Memo implements Comparable{

    public class Date implements Comparable{
        private String day;
        private String month;
        private String year;
        public Date(String day, String month, String year){
            this.day = day;
            this.month = month;
            this.year = year;
        }
        public String toString(){
            return day+"/"+month+"/"+year;
        }

        public int compareTo(Object o){
            return ((Date)o).day.compareTo(day);
        }
    }

    private String title;
    private String memo;
    private Date rDate;

    public Memo(String title, String memo, String day, String month, String year){
        this.title = title;
        this.memo = memo;
        this.rDate = new Date(day,month,year);
    }

    public String toString(){
        return "-----------"+"Memo"+"-----------\n"+"Title: "+title+"\n"+"Memo: "+memo+"\n"+"Date: "+rDate.toString()+"\n===========================\n";
    }

    public int compareTo(Object o){
        return ((Memo)o).rDate.compareTo(rDate);
    }

}
