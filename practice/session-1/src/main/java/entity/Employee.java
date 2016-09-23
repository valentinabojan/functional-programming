package entity;

import java.time.LocalDate;

public class Employee {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String function;
    private Genre genre;

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

        public EmployeeBuilder withGenre(Genre genre) {
            employee.genre = genre;
            return this;
        }

        public Employee build() {
            return employee;
        }
    }
}
