package session1.exercise.business_logic;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class EmployeeComparatorBuilder {

    // TODO 0: Sort employees by firstName using Comparator functional interface
    public List<session1.exercise.entity.Employee> sortByFirstName(List<session1.exercise.entity.Employee> employees, boolean ascending) {
        return null;
    }

    // TODO 1: Sort employees by age using Comparator functional interface
    public List<session1.exercise.entity.Employee> sortByAge(List<session1.exercise.entity.Employee> employees, boolean ascending) {
        return null;
    }

    private int getAgeInDays(session1.exercise.entity.Employee employee) {
        return Long.valueOf(DAYS.between(LocalDate.now(), employee.getBirthDate())).intValue();
    }
}
