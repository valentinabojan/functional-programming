package session5.exercise.business_logic;

import session5.exercise.entity.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmployeeSecondReport {

    private final FileWriter fileWriter;

    public EmployeeSecondReport(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public void writeEmployeeReport(List<Employee> employees) throws IOException {
    }
}
