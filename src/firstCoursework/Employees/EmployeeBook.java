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


    private final Employee[] staff = new Employee[] {null, director, tester1, null, null, tester2, tester3, tester4, tester5,
            engineer1, engineer2, engineer3, developer1, developer2, null, null, null, null};
    private final Tester[] testers = new Tester[] {tester1, tester2, tester3, tester4, tester5};

    public Employee[] getAllEmployees(){
        return staff;
    }

    public Employee[] getAllTesters(){
        return testers;
    }

    // сортировка массива (все null вправо)
    public void nullSorter(Employee[] staff) {
        int count = 0;
        for (int i = 0; i < staff.length; i++) {
            if (staff[i] != null) {
                staff[count] = staff[i];
                count++;
            }
        }
        while (count < staff.length - 1) {
            staff[count] = null;
            count++;
        }
    }
    // добавить работника
    public Employee[] add(Employee[] staff, String name, double salary, String department) {
        nullSorter(staff);
        for(int i = 0; i < staff.length; i++) {
            if (staff[i] == null) {
                staff[i] = new Employee(name, salary, department);
                break;
            }
        }
        return staff;
    }
    // удалить работника
    public void del(Employee[] staff, int id) {
        for (int i = 0; i < staff.length; i++) {
            if (staff[i] == null) continue;
            if (staff[i].getId() == id) {
                staff[i] = null;
            }
        }
        nullSorter(staff);
    }
}
