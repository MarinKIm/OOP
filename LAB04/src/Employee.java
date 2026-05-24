public class Employee {

    private String name;
    private int age;
    private String position;
    private int salary;
    private int vacationDays;

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
        this.vacationDays = 20;
    }

    public Employee(String name, int age, String position, int salary){
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.vacationDays = 20;
    }

    public Employee(String name, int age, String position, int salary, int vacationDays){
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.vacationDays = vacationDays;
    }

    public int getAge(){
        return age;
    }

    public String getPosition(){
        return position;
    }

    public int getSalary(){
        return salary;
    }

    public int getVacationDays(){
        return vacationDays;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public Boolean isEqual(Employee e1){
        if(e1.name.equals(this.name) && e1.age == this.age && e1.position.equals(this.position)){
            return true;
        }
        else{
            return false;
        }
    }

    public void getInfo(){
        System.out.printf("My Name is %s\n",this.name);
        System.out.printf("My Age is %d\n",this.age);
        System.out.printf("My Position is %s\n",this.position);
        System.out.printf("My Salary is %d\n",this.salary);
        System.out.printf("My Vacation days is %d\n",this.vacationDays);
        System.out.println("\n");
    }

    public Boolean vacation(int i){
        System.out.printf("Employee %s will go on %d days vacation?\n",this.name, this.vacationDays);
        if(this.vacationDays > i){
            this.vacationDays  = this.vacationDays - i;
            return true;
        }
        else{
            return false;
        }
    }

}
