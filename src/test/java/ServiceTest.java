import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ServiceTest {
    @Test
    void giveDataFromADatabase_WhenRetrived_ShouldMatchTheCount() throws Customexception {
        PayrollService payrollService = new PayrollService();
        List<EmployeData> employeeData = payrollService.readData();
        System.out.println(employeeData.size());
        Assertions.assertEquals(3, employeeData.size());
    }
}
