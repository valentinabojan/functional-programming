package session1.exercise.business_logic;

import session1.exercise.entity.Employee;
import session1.exercise.entity.Genre;

import java.util.List;

public class EmployeeManagement {

    // TODO 2: Filter employees by their genre using Predicate.class inside a filter
    public List<Employee> filterByGender(List<Employee> employees, Genre genre) {
        return null;
    }

    // TODO 3: Compute the salary average for the employees having a certain function using Function.class inside a map
    // TODO 4: For the average, use a reduction function of the stream
    public Double getTotalSalaryByFunction(List<Employee> employees, String function) {
        return null;
    }

    // TODO 5: Increase the salary of each employee using Consumer.class inside a forEach
    public List<Employee> increaseSalary(List<Employee> employees, Double percentage) {
        return null;
    }

    private double increaseAmount(Double amount, Double percentage) {
        return amount + amount * percentage;
    }
}
