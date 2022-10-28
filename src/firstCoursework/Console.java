package firstCoursework;
import firstCoursework.Employees.*;
import java.util.Objects;

public class Console extends EmployeeBook {
    private static final Employee employee = new Employee();

    //Вывод всей информации о всех сотрудниках
    public static void printFullInfo(Employee[] stuff) {
        for (Employee e : stuff) {
            if (e.getId() != 0 && e.getName() != null  && e.getSalary() != 0 && e.getDepartment() != null) {
                System.out.printf("ID: %-6s Employee: %-25s  Salary: %-10s Department: %-10s\n",
                        e.getId(),
                        e.getName(),
                        e.getSalary(),
                        e.getDepartment());
            }
            else break;
        }
        System.out.println();
    }

    public static void printWithoutDepartment(Employee[] stuff) {
        for (Employee e : stuff) {
            System.out.printf("ID: %-6s Employee: %-25s  Salary: %-10s\n",
                    e.getId(),
                    e.getName(),
                    e.getSalary()
            );
        }
    }

    //Вывод имен сотрудников
    public static void printNames(Employee[] stuff) {
        System.out.println("Employees names: ");
        for (Employee e : stuff)
            System.out.printf("ID: %-6s Employee: %-25s\n", e.getId(), e.getName());
        System.out.println();
    }

    //Вывод минимальной ЗП
    public static void printMinSalary(Employee[] stuff) {
        double minSalary = Double.POSITIVE_INFINITY;
        String department = "";
        String name = "";
        for (Employee e : stuff) {
            if (minSalary > e.getSalary()) {
                minSalary = e.getSalary();
                department = e.getDepartment();
                name = e.getName();
            }
        }
        System.out.printf("%-10s Employee's Min salary. Department: %s. Name:  %s\n\n", minSalary, department, name);
    }

    //Вывод максимальной ЗП
    public static void printMaxSalary(Employee[] stuff) {
        double maxSalary = 0;
        String department = "";
        String name = "";
        for (Employee e : stuff) {
            if (maxSalary < e.getSalary()) {
                maxSalary = e.getSalary();
                department = e.getDepartment();
                name = e.getName();
            }
        }
        System.out.printf("%-10s Employee's Max salary. Department: %s. Name:  %s\n\n", maxSalary, department, name);
    }

    //вывод суммы затрат на зарплаты в месяц
    public static void printMonthSalarySum(Employee[] stuff) {
        double employeesSalarySum = 0;
        for (Employee e : stuff) {
            employeesSalarySum = employeesSalarySum + e.getSalary();
        }
        System.out.printf("%-10s Sum of all Employee's salary.\n\n", employeesSalarySum);
    }

    //вывод средней зарплаты в месяц
    public static void printAverageSalary(Employee[] stuff) {
        double employeesAverageSalary = 0;
        double employeesSalarySum = 0;
        for (Employee e : stuff) {
            employeesSalarySum = employeesSalarySum + e.getSalary();
            employeesAverageSalary = employeesSalarySum / (stuff.length);
        }
        System.out.printf("%-10s Average Employee's salary.\n\n", Math.ceil(employeesAverageSalary));
    }

    //вывод сотрудников с зарплатой, меньше заданной
    public static void printLessThenSalary(Employee[] stuff, final double salaryLessThen) {
        System.out.printf("\nEmployees with salary less then %.1f:\n", salaryLessThen);
        for (Employee e : stuff) {
            if (e.getSalary() <= salaryLessThen) {
                System.out.printf("ID: %-6s Employee: %-25s  Salary: %-10s\n",
                        e.getId(),
                        e.getName(),
                        e.getSalary());
            }
        }
    }

    //вывод сотрудников с зарплатой, больше заданной
    public static void printMoreThenSalary(Employee[] stuff, final double salaryMoreThen) {
        System.out.printf("\nEmployees with salary more then %.1f:\n", salaryMoreThen);
        for (Employee e : stuff) {
            if (e.getSalary() >= salaryMoreThen) {
                System.out.printf("ID: %-6s Employee: %-25s  Salary: %-10s\n",
                        e.getId(),
                        e.getName(),
                        e.getSalary());
            }
        }
        System.out.println();
    }
    // Поиск сотрудника по имени
    public static void findByName(Employee[] stuff, String name) {
        boolean foundByName = false;
        for (Employee e : stuff) {
            if (Objects.equals(e.getName(), name)) {
                foundByName = true;
                System.out.printf("Employee %s found:\nID: %-6s Employee: %-25s  Salary: %-10s Department: %-10s\n\n",
                        name,
                        e.getId(),
                        e.getName(),
                        e.getSalary(),
                        e.getDepartment());
            }

        }
        if (!foundByName) System.out.printf("Employee %s not found", name);
    }
    // Поиск сотрудника по ID
    public static void findByID (Employee[] stuff, int ID) {
        boolean foundByID = false;
        for (Employee e : stuff) {
            if (e.getId() == ID) {
                foundByID = true;
                System.out.printf("Employee with ID № %d found:\nID: %-6s Employee: %-25s  Salary: %-10s Department: %-10s\n\n",
                        ID,
                        e.getId(),
                        e.getName(),
                        e.getSalary(),
                        e.getDepartment());
            }

        }
        if (!foundByID) System.out.printf("Employee with ID № %d not found\n\n", ID);
    }
}
