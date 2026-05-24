
public class Manager extends Employee {
    private double rate;
    private double overtimeRate;

    public Manager(String name, int employeeNum) {
        super(name, employeeNum, "Management");
        this.rate = 5.0;
        this.overtimeRate = 8.0;
    }

    public double getPaid() {
        int overtimeHrs = Math.max(work - 40, 0);
        int regularHrs = work - overtimeHrs;
        return regularHrs * rate + overtimeHrs * overtimeRate;
    }


    public boolean equals(Object obj) {
        if (!(obj instanceof Manager)) return false;
        return super.equals(obj);
    }

    public String toString() {
        return super.toString();
    }
}