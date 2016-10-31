package session6.solution.business_logic;

import session6.solution.api.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class EmployeeSecondReport implements AutoCloseable {

    private final FileWriter fileWriter;

    public EmployeeSecondReport(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
        fileWriter.write("==== Annual Employee Report ====" + "\n");
    }

    public void writeEmployeeReport(List<Employee> employees) throws IOException {
        fileWriter.write(EmployeeReport.getReportSupplierForEmployees(employees).get());
    }

    @Override
    public void close() throws Exception {
        fileWriter.write("\n" + "==========" + "\n");
        fileWriter.write("" + LocalDate.now().getYear());
        fileWriter.close();
    }
}
