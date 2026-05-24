public class TimeTable {

    public enum DAYS {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    }

    private Subject[][] timeTable;

    private void initialize() {
        timeTable = new Subject[10][5];

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 5; col++) {
                if (row == 3) {
                    timeTable[row][col] = new Subject("BREAK");
                } else if (row == 7) {
                    timeTable[row][col] = new Subject("LUNCH");
                } else {
                    timeTable[row][col] = new Subject("----");
                }
            }
        }
    }

    public TimeTable() {
        initialize();
    }

    public Subject getSchedule(DAYS day, int period) {
        int col = day.ordinal();
        int row = period - 1;
        return timeTable[row][col];
    }

    public boolean setSchedule(DAYS day, int period, String name, String tutor, String room) {
        int col = day.ordinal();
        int row = period - 1;

        if (row < 0 || row >= 10) return false;

        String current = timeTable[row][col].getName();
        if (current.equals("BREAK") || current.equals("LUNCH")) {
            return false;
        }

        timeTable[row][col] = new Subject(name, tutor, room);
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-10s %-12s %-12s %-12s %-12s %-12s%n",
                "PERIOD", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"));
        sb.append("-".repeat(72)).append("\n");

        for (int row = 0; row < 10; row++) {
            sb.append(String.format("%-10s", "Period " + (row + 1)));
            for (int col = 0; col < 5; col++) {
                sb.append(String.format("%-12s", timeTable[row][col].getName()));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}