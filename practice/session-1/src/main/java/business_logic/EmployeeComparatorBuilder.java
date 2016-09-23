package business_logic;

import entity.Employee;

import java.util.List;

public class EmployeeComparatorBuilder {

    public List<Employee> sortByFirstName(List<Employee> employees, boolean asccendently) {
        employees.sort((e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName()));

        return employees;
//        return null;
    }
}
