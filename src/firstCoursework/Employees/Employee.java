package firstCoursework.Employees;
import java.util.Objects;

public class Employee {
    private String name;
    private final int id;
    private double salary;
    private String department;

    public void setID(int nextId) {
        Employee.nextId = nextId;
    }

    private static int nextId;
    public Employee() {}
    public Employee (String firstName, double salary, String department) {
        this.name = firstName;
        this.salary = salary;
        this.department = department;
    }

    //увеличивает ЗП на определенный процент
    public void raiseSalary(Employee[] stuff, final double raiseSalaryByPercent) {
        System.out.println("Employees salary raise by " + raiseSalaryByPercent + "%\n");
        for (Employee e : stuff){
            if (raiseSalaryByPercent != 0) {
                double raise = e.getSalary() * raiseSalaryByPercent / 100;
                e.salary = e.getSalary() + raise;
            }
        }
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public double getSalary() {
        return salary;
    }
    public String getDepartment() {
        return department;
    }

    // новый ID новому сотруднику
    {
        id = nextId;
        nextId++;
    }

    //устанавливает ЗП сотруднику
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Изменение зарплаты и отдела сотрудника, найденного по имени
    public void changeEmployeeByName(Employee[] stuff, String name, double newSalary, String newDepartment) {
        boolean foundByName = false;
        for (Employee e : stuff){
            if (Objects.equals(e.name, name)) {
                foundByName = true;
                e.setSalary(newSalary);
                e.department = newDepartment;
            }
        }
        if (foundByName)
            System.out.printf("%s's salary changed to %.1f, new department: %s\n\n", name, newSalary, newDepartment);
        else
            System.out.printf("Employee %s not found\n\n", name);
    }
}
