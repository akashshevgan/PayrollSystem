import java.time.LocalDate;

public class EmployeData {
    public int id;
    public String name;
    public double salary;
    public LocalDate start;

    public EmployeData(Integer id, String name, Double salary, LocalDate date) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.start = start;
    }

    @Override
    public String toString() {
        return "EmployeeData:->" + "Id = " + id + " Name = " + name + " Salary = " + salary + " Start = " + start;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeData that = (EmployeData) o;
        return id == that.id && Double.compare(that.salary, salary) == 0 && name.equals(that.name) && start.equals(that.start);
    }
}
