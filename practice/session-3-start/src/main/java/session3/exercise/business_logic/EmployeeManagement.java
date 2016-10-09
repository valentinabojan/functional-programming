package session3.exercise.business_logic;

import org.assertj.core.groups.Tuple;
import session3.exercise.entity.Employee;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class EmployeeManagement {

    // TODO 2: Group employees by department and function; For each employee, return only the "firstname lastname".
    public Map<Tuple, List<String>> getEmployeesNameGroupedByDepartmentAndFunction(List<Employee> employees) {
        return null;
    }

    // TODO 3: Group employees by department and function; For each group, count how many employees are.
    public Map<Tuple, Long> countEmployeesGroupedByDepartmentAndFunction(List<Employee> employees) {
        return null;
    }
}
