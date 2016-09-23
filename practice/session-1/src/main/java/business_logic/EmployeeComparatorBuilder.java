package business_logic;

import entity.Employee;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class EmployeeComparatorBuilder {

    public List<Employee> sortByFirstName(List<Employee> employees, boolean ascending) {
        employees.sort((e1, e2) ->
                ascending ?
                        e1.getFirstName().compareTo(e2.getFirstName()) :
                        e2.getFirstName().compareTo(e1.getFirstName())
        );

        return employees;
//        return null;
    }

    public List<Employee> sortByAge(List<Employee> employees, boolean ascending) {
        employees.sort((e1, e2) ->
                ascending ?
                        getAgeInDays(e1) - getAgeInDays(e2) :
                        getAgeInDays(e2) - getAgeInDays(e1)
        );

        return employees;
//        return null;
    }

    private int getAgeInDays(Employee employee) {
        return Long.valueOf(DAYS.between(LocalDate.now(), employee.getBirthDate())).intValue();
    }
}
