package session1.solution.business_logic;

import session1.solution.entity.Employee;
import session1.solution.entity.Genre;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManagement {

    // TODO 2: Filter employees by their genre using Predicate.class inside a filter
    public List<Employee> filterByGender(List<Employee> employees, Genre genre) {
        return employees
                .stream()
                .filter(employee -> employee.getGenre() == genre)
                .collect(Collectors.toList());
    }

    // TODO 3: Compute the salary average for the employees having a certain function using Function.class inside a map
    // TODO 4: For the average, use a reduction function of the stream
    public Double getTotalSalaryByFunction(List<Employee> employees, String function) {
        return employees
                .stream()
                .filter(employee -> employee.getFunction().equals(function))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    // TODO 5: Increase the salary of each employee using Consumer.class inside a forEach
    public List<Employee> increaseSalary(List<Employee> employees, Double percentage) {
        employees
                .stream()
                .forEach(employee -> employee.setSalary(increaseAmount(employee.getSalary(), percentage)));

        return employees;
    }

    private double increaseAmount(Double amount, Double percentage) {
        return amount + amount * percentage;
    }
}
