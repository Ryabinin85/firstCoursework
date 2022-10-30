package firstCoursework;
import firstCoursework.Employees.*;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        System.out.println("\n--------- **Базовая сложность** ---------\n");

        // 1. список всех сотрудников
        Console.printFullInfo(employeeBook.getAllEmployees());

        // 2. вывод суммы затрат на зарплаты в месяц
        Console.printMonthSalarySum(employeeBook.getAllEmployees());

        // 3. вывод минимальной зарплаты среди всех сотрудников
        Console.printMaxSalary(employeeBook.getAllEmployees());

        // 4. вывод максимальной зарплаты среди всех сотрудников
        Console.printMinSalary(employeeBook.getAllEmployees());

        // 5. вывод средней зарплаты среди всех сотрудников
        Console.printAverageSalary(employeeBook.getAllEmployees());

        // 6. список имен всех сотрудников
        Console.printNames(employeeBook.getAllEmployees());

        System.out.println("\n--------- **Повышенная сложность** ---------\n");

        // 1. увеличение зарплаты всем testers на процент
        employeeBook.raiseSalary(employeeBook.getAllTesters(), 20);

        // 2.1. список всех testers
        Console.printFullInfo(employeeBook.getAllTesters());

        // 2.2, 2,3 вывод минимальной и максимальной зарплаты среди testers
        Console.printMaxSalary(employeeBook.getAllTesters());
        Console.printMinSalary(employeeBook.getAllTesters());

        // 2.4. вывод суммы затрат на зарплаты в месяц среди testers
        Console.printMonthSalarySum(employeeBook.getAllTesters());

        // 2.5. вывод средней зарплаты среди testers
        Console.printAverageSalary(employeeBook.getAllTesters());

        // 2.6. список всех testers (без отдела)
        Console.printWithoutDepartment(employeeBook.getAllTesters());

        // 3.1, 3.2 Поиск сотрудников с меньшей и большей зарплатой
        Console.printLessThenSalary(employeeBook.getAllTesters(), 70000);
        Console.printMoreThenSalary(employeeBook.getAllTesters(), 70000);

        System.out.println("\n--------- **Повышенная сложность 2** ---------\n");

        // Поиск всех сотрудников по названию отдела
        Console.printFullInfo(employeeBook.findByDepartment(employeeBook.getAllEmployees(), "Testing"));

        // Поиск сотрудника по имени
        Console.findByName(employeeBook.getAllEmployees(), "Petya");

        // Изменение зарплаты и отдела сотрудника, найденного по имени
        employeeBook.changeEmployeeByName(employeeBook.getAllEmployees(),"Petya", 1000000, "Director");
        Console.findByName(employeeBook.getAllEmployees(), "Petya");
        employeeBook.changeEmployeeByName(employeeBook.getAllEmployees(),"Sergei Ivanovich", 10000, "QA");
        Console.findByName(employeeBook.getAllEmployees(), "Sergei Ivanovich");

        // Поиск сотрудника по ID
        Console.findByID(employeeBook.getAllEmployees(), 1);

        Console.printFullInfo(employeeBook.add(employeeBook.getAllEmployees(), "Vasya", 55555, "Testing"));
    }
}
