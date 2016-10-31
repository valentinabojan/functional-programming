package session6.solution.business_logic;

import session6.solution.api.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static java.util.stream.Collectors.*;

public class EmployeeReport {

    // TODO 6: Write a report that has as header ""==== Annual Employee Report ====".
    // As footer use "==========" followed by the current year on a new line
    // The body is given by the supplier created by getReportSupplierForEmployees method
    public void writeEmployeeReport(String reportName, Supplier<String> supplier) {
        try (FileWriter fileWriter = new FileWriter(reportName)) {
            fileWriter.write("==== Annual Employee Report ====" + "\n");

            fileWriter.write(supplier.get());

            fileWriter.write("\n" + "==========" + "\n");
            fileWriter.write("" + LocalDate.now().getYear());
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    // TODO 4: Get salaries by department
    public static Map<String, Double> getSalariesByDepartment(List<Employee> employees) {
        return employees
                .stream()
                .collect(
                        groupingBy(
                                Employee::getDepartment,
                                summingDouble(e -> e.getSalary().doubleValue())
                        ));
    }

    // TODO 5: Create supplier for getting salaries by department and returning
    // "department_name department_salary" string list, using new line separator
    public static Supplier<String> getReportSupplierForEmployees(List<Employee> employees) {
        return () ->
                getSalariesByDepartment(employees)
                        .entrySet()
                        .stream()
                        .sorted((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
                        .map(entry -> entry.getKey() + " " + entry.getValue())
                        .collect(joining("\n"));
    }

}
