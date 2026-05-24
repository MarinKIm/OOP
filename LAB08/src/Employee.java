public abstract class Employee {
    private String name;
    private int employeeNum;
    private String department;
    protected int work;

    public Employee(String name, int employeeNum, String department) {
        this.name = name;
        this.employeeNum = employeeNum;
        this.department = department;
        this.work = 0;
    }

    public void doWork(int hrs) {
        work += hrs;
    }

    public abstract double getPaid();

    public boolean equalPay(Employee emp) {
        return this.getPaid() == emp.getPaid();
    }


    public boolean equals(Object obj) {
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return this.name.equals(other.name) && this.employeeNum == other.employeeNum;
    }


    public String toString() {
        return "Name: " + name + "\nEmp#: " + employeeNum + "\nDept: " + department;
    }

    public String getName() { return name; }
    public int getEmployeeNum() { return employeeNum; }
}