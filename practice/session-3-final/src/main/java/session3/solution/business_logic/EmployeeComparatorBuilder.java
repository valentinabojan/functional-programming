package session3.solution.business_logic;

import session3.solution.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class EmployeeComparatorBuilder {

    // TODO 1: Sort employees descending by salary and alphabetically by their firstName and lastName
    public List<Employee> sortEmployeesDescendingBySalaryAndAlphabeticallyByFirstnameAndLastname(List<Employee> employees) {
        return employees
                .stream()
                .sorted(
                        comparing(Employee::getSalary)
                                .reversed()
                                .thenComparing(Employee::getFirstName)
                                .thenComparing(Employee::getLastName)
                )
                .collect(Collectors.toList());
    }
}
