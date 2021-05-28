import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DatabaseCon {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "root";
        Connection conn = null;
        try {
            System.out.println("Connecting to database:"+jdbcURL);
            conn = DriverManager.getConnection(jdbcURL,userName,password);
            System.out.println("Connection is Successful"+conn);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listDrivers(){
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass =  (Driver) driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }
}