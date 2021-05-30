import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PayrollService {

    private Connection getConnection() throws Customexception {
        String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "root";
        Connection connection;
        try {
            System.out.println("Connecting to database " + jdbcUrl);
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Connected to " + connection + " Successfull");
        } catch (SQLException e) {
            throw new Customexception("Connection Failed");
        }
        return connection;
    }

    public List<EmployeData> readData() throws Customexception {
        String sql = "select * from employee_payroll;";
        List<EmployeData> employeeData = new ArrayList<>();

        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                double salary = result.getDouble("salary");
                LocalDate start = result.getDate("start").toLocalDate();
                employeeData.add(new EmployeData(id, name, salary, start));
            }
        } catch (SQLException e) {
            throw new Customexception("Failed");
        }
        return employeeData;
    }
}
