package session5.exercise.business_logic;

import session5.exercise.entity.Employee;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class EmployeeReport {

    // TODO 4: Get salaries by department
    public static Map<String, Double> getSalariesByDepartment(List<Employee> employees) {
        return null;
    }

    // TODO 5: Create supplier for getting salaries by department and returning
    // "department_name department_salary" string list, using new line separator
    public static Supplier<String> getReportSupplierForEmployees(List<Employee> employees) {
        return null;
    }

    // TODO 6: Write a report that has as header ""==== Annual Employee Report ====".
    // As footer use "==========" followed by the current date on a new line
    // The body is given by the supplier created by getReportSupplierForEmployees method
    public void writeEmployeeReport(String reportName, Supplier<String> supplier) {
    }

}
