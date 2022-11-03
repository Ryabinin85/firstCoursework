package firstCoursework.Employees;
import java.util.Objects;

public class EmployeeBook extends Employee {
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
    private final Employee[] staff = new Employee[] {null, director, tester1, null, tester2, tester3, tester4, tester5,
            engineer1, engineer2, engineer3, developer1, developer2, null, null, null, null};
    private final Tester[] testers = new Tester[] {tester1, tester2, tester3, tester4, tester5};

    public Employee[] getAllEmployees(){
        return staff;
    }

    public Employee[] getAllTesters(){
        return testers;
    }

    public Employee[] findByDepartment(Employee[] staff, String department) {
        System.out.println("Find employees by department: \n" + department);
        int j = 0;
        int k = 0;

        for (Employee employee : staff) {
            if (employee == null) continue;
            if (Objects.equals(employee.getDepartment(), department)) {
                j++;
            }
        }
        Employee[] foundStaff = new Employee[j];
        for (Employee employee : staff) {
            if (employee == null) continue;
            if (Objects.equals(employee.getDepartment(), department)) {
                foundStaff[k] = employee;
                k++;
            }
        }
        return foundStaff;
    }
    public Employee[] add(Employee[] staff, String name, double salary, String department) {
        for(int i = 0; i < staff.length-1; i++) {
            if (staff[i] == null) {
                staff[i] = staff[i+1];
                staff[i+1] = null;
            }

        }
        for(int i = 0; i < staff.length; i++) {
            if (staff[i] == null) {
                staff[i] = new Employee(name, salary, department);
                break;
            }
        }
        return staff;
    }
}
