package session5.solution.business_logic;

import org.junit.Test;
import session6.solution.business_logic.EmployeeReport;
import session6.solution.api.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.math.BigDecimal.valueOf;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static session6.solution.api.Employee.EmployeeBuilder.employee;

public class EmployeeReportTest {

    private EmployeeReport employeeReport = new EmployeeReport();

    @Test
    public void givenAListOfEmployees_whenGetSalariesByDepartment_thenTheSalariesAreSummarizedCorrectly() {
        List<Employee> employees = asList(
                employee().withFirstName("John").withLastName("Doe").withSalary(valueOf(100)).withDepartment("Dept 1").build(),
                employee().withFirstName("Bob").withLastName("Smith").withSalary(valueOf(200)).withDepartment("Dept 1").build(),
                employee().withFirstName("Mary").withLastName("Dean").withSalary(valueOf(300)).withDepartment("Dept 1").build(),
                employee().withFirstName("Anne").withLastName("Marie").withSalary(valueOf(400)).withDepartment("Dept 2").build(),
                employee().withFirstName("Paul").withLastName("James").withSalary(valueOf(500)).withDepartment("Dept 2").build()
        );
        Map<String, Double> expectedResult = Collections.unmodifiableMap(Stream.of(
                new SimpleEntry<>("Dept 1", valueOf(600)),
                new SimpleEntry<>("Dept 2", valueOf(900)))
                .collect(Collectors.toMap(SimpleEntry::getKey, e -> e.getValue().doubleValue())));

        Map<String, Double> actualResult = employeeReport.getSalariesByDepartment(employees);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void givenAListOfEmployees_whenGetSalariesReportSupplier_thenTheCorrectReportSupplierIsReturned() {
        List<Employee> employees = asList(
                employee().withFirstName("John").withLastName("Doe").withSalary(valueOf(100)).withDepartment("Dept 1").build(),
                employee().withFirstName("Bob").withLastName("Smith").withSalary(valueOf(200)).withDepartment("Dept 1").build(),
                employee().withFirstName("Mary").withLastName("Dean").withSalary(valueOf(300)).withDepartment("Dept 1").build(),
                employee().withFirstName("Anne").withLastName("Marie").withSalary(valueOf(400)).withDepartment("Dept 2").build(),
                employee().withFirstName("Paul").withLastName("James").withSalary(valueOf(500)).withDepartment("Dept 2").build()
        );
        String expectedResult = "Dept 1" + " " + valueOf(600.0) + "\n" + "Dept 2" + " " + valueOf(900.0);

        String actualResult = employeeReport.getReportSupplierForEmployees(employees).get();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void givenAListOfEmployees_whenGetSalariesReportSupplier_thenTheCorrectReportSupplierIsReturned1() throws IOException {
        List<Employee> employees = asList(
                employee().withFirstName("John").withLastName("Doe").withSalary(valueOf(100)).withDepartment("Dept 1").build(),
                employee().withFirstName("Bob").withLastName("Smith").withSalary(valueOf(200)).withDepartment("Dept 1").build(),
                employee().withFirstName("Mary").withLastName("Dean").withSalary(valueOf(300)).withDepartment("Dept 1").build(),
                employee().withFirstName("Anne").withLastName("Marie").withSalary(valueOf(400)).withDepartment("Dept 2").build(),
                employee().withFirstName("Paul").withLastName("James").withSalary(valueOf(500)).withDepartment("Dept 2").build()
        );
        List<String> expectedResult = Files.readAllLines(Paths.get("./src/test/resources/expected_report2016.txt"));

        employeeReport.writeEmployeeReport("./src/test/resources/report2016.txt", employeeReport.getReportSupplierForEmployees(employees));
        List<String> actualResult = Files.readAllLines(Paths.get("./src/test/resources/report2016.txt"));

        assertThat(expectedResult).isEqualTo(actualResult);
    }
}