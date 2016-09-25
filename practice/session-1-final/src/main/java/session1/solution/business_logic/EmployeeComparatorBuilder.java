package session1.solution.business_logic;

import session1.solution.entity.Employee;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class EmployeeComparatorBuilder {

    // TODO 0: Sort employees by firstName using Comparator functional interface
    public List<Employee> sortByFirstName(List<Employee> employees, boolean ascending) {
        employees.sort((e1, e2) ->
                        ascending ?
                                e1.getFirstName().compareTo(e2.getFirstName()) :
                                e2.getFirstName().compareTo(e1.getFirstName())
        );

        return employees;
    }

    // TODO 1: Sort employees by age using Comparator functional interface
    public List<Employee> sortByAge(List<Employee> employees, boolean ascending) {
        employees.sort((e1, e2) ->
                        ascending ?
                                getAgeInDays(e1) - getAgeInDays(e2) :
                                getAgeInDays(e2) - getAgeInDays(e1)
        );

        return employees;
    }

    private int getAgeInDays(Employee employee) {
        return Long.valueOf(DAYS.between(LocalDate.now(), employee.getBirthDate())).intValue();
    }
}
