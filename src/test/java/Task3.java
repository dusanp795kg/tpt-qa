import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeesPage;

import java.io.IOException;

public class Task3 extends BaseTest {

    @Test
    public void Task3_test1() throws IOException {

        EmployeesPage employeesPage = new EmployeesPage(driver).open();

        employeesPage.filterUSEmployees();
        employeesPage.printUSEmployeeInfo();
        employeesPage.exportOnlineUSEmployees();
        Assert.assertTrue(employeesPage.verifyExportedTable(), "Wrong exported data! ");
    }
}
