package firstCoursework.Employees;

public class Manager extends Employee {
    private double bonus;
    public Manager(String firstName, double salary, String department){
        super(firstName, salary, department);
    }

    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
    public void setBonus(double setBonus){
        bonus = setBonus;
    }

}
