package firstCoursework;
import firstCoursework.Employees.*;
import java.util.Objects;

public class Console {

    //Вывод всей информации о всех сотрудниках
    public static void printFullInfo(Employee[] staff) {
        for (Employee employee : staff) {
            if (employee != null) System.out.print(employee);
        }
        System.out.println();
    }
    public static void printWithoutDepartment(Employee[] staff) {
        for (Employee employee : staff) {
            if (employee != null) employee.toStringWithoutDepartment();
        }
    }
    //Вывод имен сотрудников
    public static void printNames(Employee[] staff) {
        System.out.println("Employees names: ");
        for (Employee employee : staff) {
            if (employee != null)
                System.out.printf("ID: %-6s Employee: %-25s\n", employee.getId(), employee.getName());
        }
        System.out.println();
    }
    //Вывод минимальной ЗП
    public static void printMinSalary(Employee[] staff) {
        double minSalary = Double.POSITIVE_INFINITY;
        String department = null;
        String name = null;
        for (Employee employee : staff) {
            if (employee != null && minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
                department = employee.getDepartment();
                name = employee.getName();
            }
        }
        System.out.printf("%-10s Employee's Min salary. Department: %s. Name:  %s\n\n", minSalary, department, name);
    }
    public static void printMinSalary(Employee[] staff, String department) {
        double minSalary = Double.POSITIVE_INFINITY;
        String name = null;
        for (Employee employee : staff) {
            if (employee != null && Objects.equals(employee.getDepartment(), department)
                    && minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
                department = employee.getDepartment();
                name = employee.getName();
            }
        }
        System.out.printf("%-10s Employee's Min salary. Department: %s. Name:  %s\n\n", minSalary, department, name);
    }
    //Вывод максимальной ЗП
    public static void printMaxSalary(Employee[] staff) {
        double maxSalary = 0;
        String department = null;
        String name = null;
        for (Employee employee : staff) {
            if (employee != null && maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
                department = employee.getDepartment();
                name = employee.getName();
            }
        }
        System.out.printf("%-10s Employee's Max salary. Department: %s. Name:  %s\n\n", maxSalary, department, name);
    }
    public static void printMaxSalary(Employee[] staff, String department) {
        double maxSalary = 0;
        String name = null;
        for (Employee employee : staff) {
            if (employee != null && Objects.equals(employee.getDepartment(), department)
                    && maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
                department = employee.getDepartment();
                name = employee.getName();
            }
        }
        System.out.printf("%-10s Employee's Max salary. Department: %s. Name:  %s\n\n", maxSalary, department, name);
    }
    //вывод суммы затрат на зарплаты в месяц
    public static void printMonthSalarySum(Employee[] staff) {
        double employeesSalarySum = 0;
        for (Employee employee : staff) {
            if (employee != null) employeesSalarySum = employeesSalarySum + employee.getSalary();
        }
        System.out.printf("%-10s Sum of all Employee's salary.\n\n", employeesSalarySum);
    }
    //вывод средней зарплаты в месяц
    public static void printAverageSalary(Employee[] staff) {
        double employeesAverageSalary = 0;
        double employeesSalarySum = 0;
        for (Employee employee : staff) {
            if (employee != null) employeesSalarySum = employeesSalarySum + employee.getSalary();
            employeesAverageSalary = employeesSalarySum / (staff.length);
        }
        System.out.printf("%-10s Average Employee's salary.\n\n", Math.ceil(employeesAverageSalary));
    }
    //вывод сотрудников с зарплатой, меньше заданной
    public static void printLessThenSalary(Employee[] staff, final double salaryLessThen) {
        System.out.printf("\nEmployees with salary less then %.1f:\n", salaryLessThen);
        for (Employee employee : staff) {
            if (employee != null && employee.getSalary() <= salaryLessThen)
                employee.toStringWithoutDepartment();
        }
    }
    //вывод сотрудников с зарплатой, больше заданной
    public static void printMoreThenSalary(Employee[] staff, final double salaryMoreThen) {
        System.out.printf("\nEmployees with salary more then %.1f:\n", salaryMoreThen);
        for (Employee employee : staff) {
            if (employee != null && employee.getSalary() >= salaryMoreThen)
                employee.toStringWithoutDepartment();
        }
        System.out.println();
    }
    // Поиск сотрудника по имени
    public static void findByName(Employee[] staff, String name) {
        boolean foundByName = false;
        for (Employee employee : staff) {
            if (employee != null && Objects.equals(employee.getName(), name)) {
                foundByName = true;
                System.out.printf("Employee %s found:\n", name);
                System.out.print(employee);
            }
        }
        if (!foundByName) System.out.printf("Employee %s not found", name);
    }
    // Поиск сотрудника по ID
    public static void findByID (Employee[] staff, int ID) {
        boolean foundByID = false;
        for (Employee employee : staff) {
            if (employee != null && employee.getId() == ID) {
                foundByID = true;
                System.out.printf("Employee with ID № %d found:\n", ID);
                System.out.print(employee);
            }
        }
        System.out.println();
        if (!foundByID) System.out.printf("Employee with ID № %d not found\n\n", ID);
    }
    // Поиск сотрудника по отделу
    public static void findByDepartment(Employee[] staff, String department) {
        System.out.println("Find employees by department: \n" + department);
        for (Employee employee : staff) {
            if (employee != null && Objects.equals(employee.getDepartment(), department))
                System.out.print(employee);
        }
        System.out.println();
    }
}