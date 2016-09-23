package business_logic;

import entity.Employee;
import entity.Genre;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManagement {

    // Practice Predicate.class (using filter)
    public List<Employee> filterByGender(List<Employee> employees, Genre genre) {
        return employees
                .stream()
                .filter(employee -> employee.getGenre() == genre)
                .collect(Collectors.toList());
    }

    // Practice Function.class (using map)
    public Long getTotalSalaryByFunction(List<Employee> employees, String function) {
        return employees
                .stream()
                .filter(employee -> employee.getFunction().equals(function))
                .mapToLong(Employee::getSalary)
                .sum();
    }
}
