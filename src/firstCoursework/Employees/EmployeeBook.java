package firstCoursework.Employees;
import java.util.Objects;

public class EmployeeBook extends Employee{
    private final Manager director = new Manager("Sergei Ivanovich", 350000, "Director");
    private final Tester tester1 = new Tester("Mikhalich", 40000, "Testing");
    private final Tester tester2 = new Tester("Petrovihc", 50000, "Testing");
    private final Tester tester3 = new Tester("Petrov", 60000, "Testing");
    private final Tester tester4 = new Tester("Ivanov", 70000,"Testing");
    private final Tester tester5 = new Tester("Petya", 80000, "Testing");
    private final Engineer engineer1 = new Engineer("Evgenii Victorovich", 90000, "Engineering");
    private final Engineer engineer2 = new Engineer("Aleksandr Sergeevich", 100000, "Engineering");
    private final Engineer engineer3 = new Engineer("Sergei Vitalievich", 110000, "Engineering");
    private final Developer developer1 = new Developer("Igor Valentinovich", 130000, "Development");
    private final Developer developer2 = new Developer("Victor Nikolaevich", 150000, "Development");
    private final Employee[] stuff = new Employee[] {director, tester1, tester2, tester3, tester4, tester5,
            engineer1, engineer2, engineer3, developer1, developer2};
    private final Tester[] testers = new Tester[] {tester1, tester2, tester3, tester4, tester5};

    public Employee[] getAllEmployees(){
        return stuff;
    }

    public Employee[] getAllTesters(){
        return testers;
    }

    public Employee[] findByDepartment(Employee[] stuff, String department) {
        System.out.println("Find employees by department: \n" + department);
        int j = 0;
        int k = 0;

        for (int i = 0; i < this.stuff.length; i++) {
            if (Objects.equals(stuff[i].getDepartment(), department)) {
                j++;
            }
        }
        Employee[] foundStuff = new Employee[j];
        for (int i = 0; i < this.stuff.length; i++) {
            if (Objects.equals(stuff[i].getDepartment(), department)) {
                foundStuff[k] = stuff[i];
                k++;
            }
        }
        return foundStuff;
    }
    public Employee[] add(Employee[] stuff, String name, double salary, String department) {
        Employee[] newStuff = new Employee[stuff.length + 1];
        for(int i = 0; i < stuff.length; i++) {
            if (stuff[i] != null) {
                System.arraycopy(stuff, 0, newStuff, 0, stuff.length);
                newStuff[stuff.length] = new Employee(name, salary, department);
                newStuff[stuff.length].setID(stuff.length+1);
            }
            else {
                stuff[i] = new Employee(name, salary, department);
                newStuff[stuff.length].setID(i+1);
            }
        }
        return newStuff;
    }
}
