package business_logic;

import entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static entity.Employee.EmployeeBuilder.employee;

public class EmployeeComparatorBuilderTest {

    @Test
    public void test() {
        List<Employee> employees = Arrays.asList(employee().withFirstName("a").build(),
                employee().withFirstName("b").build(),
                employee().withFirstName("c").build(),
                employee().withFirstName("d").build());

        new EmployeeComparatorBuilder().sortByFirstName(employees, false);


    }
}