package session3.solution.business_logic;

import org.junit.Test;
import session3.solution.entity.Employee;

import java.util.List;

import static java.math.BigDecimal.valueOf;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static session3.solution.entity.Employee.EmployeeBuilder.employee;

public class EmployeeComparatorBuilderTest {

    @Test
    public void givenAListOfEmployees_whenSortingDescendingBySalaryAndAlphabeticallyByFirstnameAndLastname_thenTheEmployeesAreSortedCorrectly() {
        List<Employee> employees = asList(
                employee().withSalary(valueOf(100.0)).withFirstName("Carla").withLastName("Bright").build(),
                employee().withSalary(valueOf(100.0)).withFirstName("Carla").withLastName("Adams").build(),
                employee().withSalary(valueOf(100.0)).withFirstName("Anna").withLastName("O'Riley").build(),
                employee().withSalary(valueOf(500.0)).withFirstName("Danny").withLastName("Evens").build()
        );
        List<Employee> expectedEmployees = asList(
                employee().withSalary(valueOf(500.0)).withFirstName("Danny").withLastName("Evens").build(),
                employee().withSalary(valueOf(100.0)).withFirstName("Anna").withLastName("O'Riley").build(),
                employee().withSalary(valueOf(100.0)).withFirstName("Carla").withLastName("Adams").build(),
                employee().withSalary(valueOf(100.0)).withFirstName("Carla").withLastName("Bright").build()
        );

        List<Employee> actualEmployees = new EmployeeComparatorBuilder().sortEmployeesDescendingBySalaryAndAlphabeticallyByFirstnameAndLastname(employees);

        assertThat(actualEmployees).isEqualTo(expectedEmployees);
    }
}