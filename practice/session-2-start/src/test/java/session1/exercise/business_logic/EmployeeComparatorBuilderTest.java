package session1.exercise.business_logic;

import session1.exercise.entity.Employee;
import org.junit.Test;

import java.util.List;

import static session1.exercise.entity.Employee.EmployeeBuilder.employee;
import static java.time.LocalDate.of;
import static java.time.Month.*;
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

    @Test
    public void givenAListOfEmployees_whenSortingThemAscendingByAge_thenTheEmployeesAreSortedCorrectly() {
        List<Employee> employees = asList(
                employee().withBirthDate(of(1992, JANUARY, 14)).build(),
                employee().withBirthDate(of(1992, MARCH, 23)).build(),
                employee().withBirthDate(of(1958, SEPTEMBER, 20)).build(),
                employee().withBirthDate(of(1961, MAY, 19)).build()
        );
        List<Employee> expectedEmployees = asList(
                employee().withBirthDate(of(1958, SEPTEMBER, 20)).build(),
                employee().withBirthDate(of(1961, MAY, 19)).build(),
                employee().withBirthDate(of(1992, JANUARY, 14)).build(),
                employee().withBirthDate(of(1992, MARCH, 23)).build()
        );

        List<Employee> actualEmployees = new EmployeeComparatorBuilder().sortByAge(employees, true);

        assertThat(actualEmployees).isEqualTo(expectedEmployees);
    }

    @Test
    public void givenAListOfEmployees_whenSortingThemDescendingByAge_thenTheEmployeesAreSortedCorrectly() {
        List<Employee> employees = asList(
                employee().withBirthDate(of(1992, JANUARY, 14)).build(),
                employee().withBirthDate(of(1992, MARCH, 23)).build(),
                employee().withBirthDate(of(1958, SEPTEMBER, 20)).build(),
                employee().withBirthDate(of(1961, MAY, 19)).build()
        );
        List<Employee> expectedEmployees = asList(
                employee().withBirthDate(of(1992, MARCH, 23)).build(),
                employee().withBirthDate(of(1992, JANUARY, 14)).build(),
                employee().withBirthDate(of(1961, MAY, 19)).build(),
                employee().withBirthDate(of(1958, SEPTEMBER, 20)).build()
        );

        List<Employee> actualEmployees = new EmployeeComparatorBuilder().sortByAge(employees, false);

        assertThat(actualEmployees).isEqualTo(expectedEmployees);
    }
}