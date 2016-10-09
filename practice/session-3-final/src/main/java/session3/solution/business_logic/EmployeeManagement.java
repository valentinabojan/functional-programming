package session3.solution.business_logic;

import org.assertj.core.groups.Tuple;
import session3.solution.entity.Employee;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class EmployeeManagement {

    // TODO 2: Group employees by department and function; For each employee, return only the "firstname lastname".
    public Map<Tuple, List<String>> getEmployeesNameGroupedByDepartmentAndFunction(List<Employee> employees) {
        return employees
                .stream()
                .collect(
                        groupingBy(
                                e -> new Tuple(e.getDepartment(), e.getFunction()),
                                mapping(e ->
                                                e.getFirstName() + " " + e.getLastName(),
                                        toList()))
                );
    }

    // TODO 3: Group employees by department and function; For each group, count how many employees are.
    public Map<Tuple, Long> countEmployeesGroupedByDepartmentAndFunction(List<Employee> employees) {
        return employees
                .stream()
                .collect(
                        groupingBy(
                                e -> new Tuple(e.getDepartment(), e.getFunction()),
                                counting()
                        )
                );
    }
}
