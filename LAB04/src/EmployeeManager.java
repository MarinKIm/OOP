public class EmployeeManager {
    public static void main(String[] args) {

        Employee james = new Employee("James Wright", 42, "Manager", 20000);
        Employee amy = new Employee("Amy Smith", 27, "Design Coordinator", 8000, 15);
        Employee peter = new Employee("Peter Coolidge", 32, "Assistant Manager", 12000, 7);
        Employee john = new Employee("John Doe", 22, "Engineer", 10000, 10);

        james.getInfo();
        amy.getInfo();
        peter.getInfo();
        john.getInfo();

        System.out.println("------");

        Employee newAmy = new Employee("Amy Smith", 27, "Design Coordinator", 18000);

        amy.getInfo();
        newAmy.getInfo();

        System.out.println("Amy vs newAmy equal? " + amy.isEqual(newAmy));

        System.out.println("------");

        boolean jamesVacation = james.vacation(10);
        System.out.println("James vacation success? " + jamesVacation);
        System.out.println("Remaining days: " + james.getVacationDays());

        System.out.println("------");

        boolean peterVacation = peter.vacation(10);
        System.out.println("Peter vacation success? " + peterVacation);
        System.out.println("Remaining days: " + peter.getVacationDays());
    }
}