package session2.solution.business_logic;

import session2.solution.entity.Employee;

import java.util.List;

public class EmployeeComparatorBuilder {

    // TODO 5: Sort employees by firstName using Comparator functional interface
    public List<Employee> sortByFirstName(List<Employee> employees, boolean ascending) {
        employees.sort((e1, e2) ->
                ascending ?
                        e1.getFirstName().compareTo(e2.getFirstName()) :
                        e2.getFirstName().compareTo(e1.getFirstName())
        );

        return employees;
    }
}
