package session1.solution.business_logic;

import org.junit.Test;
import session1.solution.entity.Employee;

import java.util.List;

import static session1.solution.entity.Employee.EmployeeBuilder.employee;
import static session1.solution.entity.Genre.FEMALE;
import static session1.solution.entity.Genre.MALE;
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
                employee().withFunction(DEVELOPER).withSalary(1000.0).build(),
                employee().withFunction(MANAGER).withSalary(730.0).build(),
                employee().withFunction(DEVELOPER).withSalary(800.0).build(),
                employee().withFunction(MANAGER).withSalary(650.0).build()
        );
        Double expectedAmount = 900.0;

        Double actualAmount = new EmployeeManagement().getTotalSalaryByFunction(employees, DEVELOPER);

        assertThat(actualAmount).isEqualTo(expectedAmount);
    }


    @Test
    public void givenAListOfEmployees_whenIncreasingTheirSalaryWith10Percent_thenTheEmployeesHaveTheCorrectIncreasedSalaries() {
        List<Employee> employees = asList(
                employee().withFunction(DEVELOPER).withSalary(1000.0).build(),
                employee().withFunction(MANAGER).withSalary(730.0).build(),
                employee().withFunction(DEVELOPER).withSalary(800.0).build(),
                employee().withFunction(MANAGER).withSalary(650.0).build()
        );
        List<Employee> expectedEmployees = asList(
                employee().withFunction(DEVELOPER).withSalary(1100.0).build(),
                employee().withFunction(MANAGER).withSalary(803.0).build(),
                employee().withFunction(DEVELOPER).withSalary(880.0).build(),
                employee().withFunction(MANAGER).withSalary(715.0).build()
        );

        List<Employee> actualEmployees = new EmployeeManagement().increaseSalary(employees, 0.1);

        assertThat(actualEmployees).isEqualTo(expectedEmployees);
    }
}