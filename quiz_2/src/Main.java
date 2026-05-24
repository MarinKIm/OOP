public class Main {
    public static void main(String[] args) {
        ReminderApp reminder = new ReminderApp();
        reminder.addMemo(new Memo("Quiz", "Don't forget to study for Quiz 2.","24","05","2017"));
        reminder.addMemo(new Memo("Cat Food", "Don't forget to buy cat food.","15","05","2017"));
        reminder.addMemo(new Memo("Dog Food", "Don't forget to buy dog food.","18","05","2017"));
        reminder.addMemo(new Memo("Assignment 2", "Don't forget to do Assignment 2","05","05","2017"));

        System.out.println(reminder.toString());
    }
}
