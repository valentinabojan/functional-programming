package business_logic;

import entity.Employee;
import org.junit.Test;

import java.util.List;

import static entity.Employee.EmployeeBuilder.employee;
import static entity.Genre.FEMALE;
import static entity.Genre.MALE;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeManagementTest {

    public static final String DEVELOPER = "Developer";
    public static final String MANAGER = "Manager";

    @Test
    public void givenAListOfEmployees_whenFilteringOnlyTheMales_thenTheEmployeesAreSortedCorrectly() {
        List<Employee> employees = asList(
                employee().withGenre(MALE).build(),
                employee().withGenre(FEMALE).build(),
                employee().withGenre(MALE).build(),
                employee().withGenre(FEMALE).build()
        );
        List<Employee> expectedEmployees = asList(
                employee().withGenre(MALE).build(),
                employee().withGenre(MALE).build()
        );

        List<Employee> actualEmployees = new EmployeeManagement().filterByGender(employees, MALE);

        assertThat(actualEmployees).isEqualTo(expectedEmployees);
    }

    @Test
    public void givenAListOfEmployees_whenGettingTheTotalSalaryOfDevelopers_thenTheCorrectAmountIsReturned() {
        List<Employee> employees = asList(
                employee().withFunction(DEVELOPER).withSalary(1000L).build(),
                employee().withFunction(MANAGER).withSalary(730L).build(),
                employee().withFunction(DEVELOPER).withSalary(800L).build(),
                employee().withFunction(MANAGER).withSalary(650L).build()
        );
        Long expectedAmount = 1800L;

        Long actualAmount = new EmployeeManagement().getTotalSalaryByFunction(employees, DEVELOPER);

        assertThat(actualAmount).isEqualTo(expectedAmount);
    }

}