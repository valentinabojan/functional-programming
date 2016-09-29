package session1.solution.business_logic;

import org.junit.Test;
import session1.solution.entity.Employee;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static session1.solution.entity.Employee.EmployeeBuilder.employee;

public class EmployeeManagementTest {

    public static final String DEVELOPER = "Developer";
    public static final String MANAGER = "Manager";

    @Test
    public void givenAListOfEmployees_whenFilteringOnlyTheMales_thenTheEmployeesAreSortedCorrectly() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        List<Employee> employees = asList(
                employee().withFirstName("John").withLastName("Doe").withFunction(DEVELOPER).withSalary(100.0).build(),
                employee().withFirstName("Bob").withLastName("Smith").withFunction(MANAGER).withSalary(1200.0).build(),
                employee().withFirstName("Mary").withLastName("Dean").withFunction(DEVELOPER).withSalary(230.0).build(),
                employee().withFirstName("Paul").withLastName("James").withFunction(MANAGER).withSalary(720.0).build()
        );
        String expectedReport =
                "John Doe" + ", " + DEVELOPER + " - " + 100.0 + System.getProperty("line.separator") +
                        "Bob Smith" + ", " + MANAGER + " - " + 1200.0 + System.getProperty("line.separator") +
                        "Mary Dean" + ", " + DEVELOPER + " - " + 230.0 + System.getProperty("line.separator") +
                        "Paul James" + ", " + MANAGER + " - " + 720.0 + System.getProperty("line.separator");

        new EmployeeManagement().printReportBody(employees);

        assertThat(outContent.toString()).isEqualTo(expectedReport);
    }
}