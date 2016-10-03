package session2.exercise.business_logic;

import session2.exercise.business_logic.EmployeeComparatorBuilder;
import session2.exercise.entity.Employee;
import org.junit.Test;

import java.util.List;

import static session2.exercise.entity.Employee.EmployeeBuilder.employee;
import static java.time.LocalDate.of;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeComparatorBuilderTest {

    @Test
    public void givenAListOfEmployees_whenSortingThemAscendingByFirstName_thenTheEmployeesAreSortedCorrectly() {
        List<Employee> employees = asList(
                employee().withFirstName("Carla").build(),
                employee().withFirstName("Anna").build(),
                employee().withFirstName("Danny").build(),
                employee().withFirstName("Bobby").build()
        );
        List<Employee> expectedEmployees = asList(
                employee().withFirstName("Anna").build(),
                employee().withFirstName("Bobby").build(),
                employee().withFirstName("Carla").build(),
                employee().withFirstName("Danny").build()
        );

        List<Employee> actualEmployees = new EmployeeComparatorBuilder().sortByFirstName(employees, true);

        assertThat(actualEmployees).isEqualTo(expectedEmployees);
    }

    @Test
    public void givenAListOfEmployees_whenSortingThemDescendingByFirstName_thenTheEmployeesAreSortedCorrectly() {
        List<Employee> employees = asList(
                employee().withFirstName("Carla").build(),
                employee().withFirstName("Anna").build(),
                employee().withFirstName("Danny").build(),
                employee().withFirstName("Bobby").build()
        );
        List<Employee> expectedEmployees = asList(
                employee().withFirstName("Danny").build(),
                employee().withFirstName("Carla").build(),
                employee().withFirstName("Bobby").build(),
                employee().withFirstName("Anna").build()
        );

        List<Employee> actualEmployees = new EmployeeComparatorBuilder().sortByFirstName(employees, false);

        assertThat(actualEmployees).isEqualTo(expectedEmployees);
    }
}