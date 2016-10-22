package session5.exercise.business_logic;

import org.junit.Test;
import session5.exercise.business_logic.EmployeeSecondReport;
import session5.exercise.entity.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.math.BigDecimal.valueOf;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static session5.exercise.entity.Employee.EmployeeBuilder.employee;

public class EmployeeSecondReportTest {

//    @Test
//    public void givenAListOfEmployees_whenGetSalariesReportSupplier_thenTheCorrectReportSupplierIsReturned1() throws IOException {
//        List<Employee> employees = asList(
//                employee().withFirstName("John").withLastName("Doe").withSalary(valueOf(100)).withDepartment("Dept 1").build(),
//                employee().withFirstName("Bob").withLastName("Smith").withSalary(valueOf(200)).withDepartment("Dept 1").build(),
//                employee().withFirstName("Mary").withLastName("Dean").withSalary(valueOf(300)).withDepartment("Dept 1").build(),
//                employee().withFirstName("Anne").withLastName("Marie").withSalary(valueOf(400)).withDepartment("Dept 2").build(),
//                employee().withFirstName("Paul").withLastName("James").withSalary(valueOf(500)).withDepartment("Dept 2").build()
//        );
//        List<String> expectedResult = Files.readAllLines(Paths.get("./src/test/resources/expected_report2016.txt"));
//
//        try(EmployeeSecondReport employeeSecondReport = new EmployeeSecondReport("./src/test/resources/report2016.txt")) {
//            employeeSecondReport.writeEmployeeReport(employees);
//        } catch (Exception e) {
//            fail("assertions failed");
//        }
//        List<String> actualResult = Files.readAllLines(Paths.get("./src/test/resources/report2016.txt"));
//
//        assertThat(actualResult).isEqualTo(expectedResult);
//    }
}