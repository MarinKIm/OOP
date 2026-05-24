public class Engineer extends Employee {
    private int rate;

    public Engineer(String name, int employeeNum) {
        super(name, employeeNum, "Engineering");
        this.rate = 4;
    }

    public double getPaid() {
        return work * rate;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Engineer)) return false;
        return super.equals(obj);
    }

    public String toString() {
        return super.toString();
    }
}