package firstCoursework.Employees;
import java.util.Objects;

public class Employee {
    private String name;
    private final int id;
    private double salary;
    private String department;
    private static int nextId;
    public Employee() {}
    public Employee (String firstName, double salary, String department) {
        this.name = firstName;
        this.salary = salary;
        this.department = department;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getDepartment() {
        return department;
    }
    public int getId() {
        return id;
    }
    public void setID(int nextId) {
        Employee.nextId = nextId;
    }
    // новый ID новому сотруднику
    {
        id = nextId;
        nextId++;
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
    public void toStringWithoutDepartment() {
        System.out.printf("ID: %-6s Employee: %-25s  Salary: %-10s\n",
                id, name, salary);
    }
    @Override
    public String toString() {
        return String.format("ID: %-6s Employee: %-25s  Salary: %-10s Department: %-10s\n",
                id, name, salary, department);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(employee.salary, salary) == 0
                && Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, id, salary, department);
    }
}
