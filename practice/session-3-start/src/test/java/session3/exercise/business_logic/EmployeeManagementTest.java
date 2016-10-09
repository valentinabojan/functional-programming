package session3.exercise.business_logic;

import org.assertj.core.groups.Tuple;
import org.junit.Test;
import session3.exercise.entity.Employee;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static session3.exercise.entity.Employee.EmployeeBuilder.employee;

public class EmployeeManagementTest {

    public static final String DEVELOPER = "Developer";
    public static final String MANAGER = "Manager";

    @Test
    public void givenAListOfEmployees_whenGetEmployeesNameGroupedByDepartmanetAndFunction_thenTheEmployeesAreGroupedCorrectly() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        List<Employee> employees = asList(
                employee().withFirstName("John").withLastName("Doe").withFunction(DEVELOPER).withDepartment("Dept 1").build(),
                employee().withFirstName("Bob").withLastName("Smith").withFunction(MANAGER).withDepartment("Dept 1").build(),
                employee().withFirstName("Mary").withLastName("Dean").withFunction(DEVELOPER).withDepartment("Dept 1").build(),
                employee().withFirstName("Anne").withLastName("Marie").withFunction(MANAGER).withDepartment("Dept 2").build(),
                employee().withFirstName("Paul").withLastName("James").withFunction(MANAGER).withDepartment("Dept 2").build()
        );

        Map<Tuple, List<String>> expectedResult = Collections.unmodifiableMap(Stream.of(
                new SimpleEntry<>(new Tuple("Dept 1", MANAGER), asList("Bob Smith")),
                new SimpleEntry<>(new Tuple("Dept 1", DEVELOPER), asList("John Doe", "Mary Dean")),
                new SimpleEntry<>(new Tuple("Dept 2", MANAGER), asList("Anne Marie", "Paul James")))
                .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue)));

        Map<Tuple, List<String>> actualResult = new EmployeeManagement().getEmployeesNameGroupedByDepartmentAndFunction(employees);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void givenAListOfEmployees_whenCountingEmployeesGroupedByDepartmanetAndFunction_thenTheEmployeesAreCountedCorrectly() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        List<Employee> employees = asList(
                employee().withFirstName("John").withLastName("Doe").withFunction(DEVELOPER).withDepartment("Dept 1").build(),
                employee().withFirstName("Bob").withLastName("Smith").withFunction(MANAGER).withDepartment("Dept 1").build(),
                employee().withFirstName("Mary").withLastName("Dean").withFunction(DEVELOPER).withDepartment("Dept 1").build(),
                employee().withFirstName("Anne").withLastName("Marie").withFunction(MANAGER).withDepartment("Dept 2").build(),
                employee().withFirstName("Paul").withLastName("James").withFunction(MANAGER).withDepartment("Dept 2").build()
        );

        Map<Tuple, Long> expectedResult = Collections.unmodifiableMap(Stream.of(
                new SimpleEntry<>(new Tuple("Dept 1", MANAGER), 1L),
                new SimpleEntry<>(new Tuple("Dept 1", DEVELOPER), 2L),
                new SimpleEntry<>(new Tuple("Dept 2", MANAGER), 2L))
                .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue)));

        Map<Tuple, Long> actualResult = new EmployeeManagement().countEmployeesGroupedByDepartmentAndFunction(employees);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}