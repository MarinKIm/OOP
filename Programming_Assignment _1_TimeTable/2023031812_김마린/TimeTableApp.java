import java.util.Scanner;

public class TimeTableApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimeTable timetable = new TimeTable();
        int option;

        do {
            System.out.println("\n===== TIMETABLE APP =====");
            System.out.println("(1) Add a class to my time table");
            System.out.println("(2) View the class at a specific period");
            System.out.println("(3) Print the entire time table");
            System.out.println("(4) Exit the program");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Day (MONDAY/TUESDAY/WEDNESDAY/THURSDAY/FRIDAY): ");
                    String dayInput = scanner.nextLine().toUpperCase();

                    System.out.print("Enter Period (1-10): ");
                    int period = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Subject Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Tutor Name: ");
                    String tutor = scanner.nextLine();

                    System.out.print("Enter Room Name: ");
                    String room = scanner.nextLine();

                    TimeTable.DAYS day;
                    try {
                        day = TimeTable.DAYS.valueOf(dayInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid day entered.");
                        break;
                    }

                    boolean success = timetable.setSchedule(day, period, name, tutor, room);
                    if (success) {
                        System.out.println("Class successfully added!");
                    } else {
                        System.out.println("Class was NOT successfully added");
                    }
                    break;

                case 2:
                    System.out.print("Enter Day (MONDAY-FRIDAY) to view: ");
                    String dayView = scanner.nextLine().toUpperCase();

                    System.out.print("Enter Period (1-10) to view: ");
                    int periodView = scanner.nextInt();
                    scanner.nextLine();

                    TimeTable.DAYS viewDay;
                    try {
                        viewDay = TimeTable.DAYS.valueOf(dayView);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid day entered.");
                        break;
                    }

                    Subject s = timetable.getSchedule(viewDay, periodView);
                    System.out.println("\nAt that time you have ...");
                    System.out.println(s.getDetails());
                    break;

                case 3:
                    System.out.println(timetable.toString());
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option. Please select 1-4.");
            }

        } while (option != 4);

        scanner.close();
    }
}