package session5.solution.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String function;
    private BigDecimal salary;
    private Genre genre;
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFunction() {
        return function;
    }

    public Genre getGenre() {
        return genre;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (birthDate != null ? !birthDate.equals(employee.birthDate) : employee.birthDate != null) return false;
        if (department != null ? !department.equals(employee.department) : employee.department != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (function != null ? !function.equals(employee.function) : employee.function != null) return false;
        if (genre != employee.genre) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (salary != null ? !salary.equals(employee.salary) : employee.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (function != null ? function.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }

    public static class EmployeeBuilder {
        private Employee employee;

        private EmployeeBuilder() {
            employee = new Employee();
        }

        public static EmployeeBuilder employee() {
            return new EmployeeBuilder();
        }

        public EmployeeBuilder withFirstName(String firstName) {
            employee.firstName = firstName;
            return this;
        }

        public EmployeeBuilder withLastName(String lastName) {
            employee.lastName = lastName;
            return this;
        }

        public EmployeeBuilder withBirthDate(LocalDate birthDate) {
            employee.birthDate = birthDate;
            return this;
        }

        public EmployeeBuilder withFunction(String function) {
            employee.function = function;
            return this;
        }

        public EmployeeBuilder withSalary(BigDecimal salary) {
            employee.salary = salary;
            return this;
        }

        public EmployeeBuilder withGenre(Genre genre) {
            employee.genre = genre;
            return this;
        }

        public EmployeeBuilder withDepartment(String department) {
            employee.department = department;
            return this;
        }

        public Employee build() {
            return employee;
        }
    }
}
