package lab1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This class represents a student.
 */
public class Student {
    /**
     * This field represents a student's name.
     */
    @Pattern(regexp = "[\\pL{U}][\\pL{l}]{0,24}", message = "The name should contains only letters.")
    private String name;
    /**
     * This field represents a student's surname.
     */
    @Pattern(regexp = "[\\pL{U}][\\pL{l}]{0,24}")
    @NotNull(message = "Surname should be set")
    private String surname;
    /**
     * This field represents a student's class.
     */
    @Pattern(regexp = "[\\d]-[A-Z]", message = "The class of the student should be set as 'digit'-'Upper case letter'")
    private String studentsClass; // outer class
    /**
     * This field represents a student's phone number.
     */
    @Pattern(regexp = "[+]?[\\d]{9,20}", message = "The phone number should contains digits and/or '+'")
    @Size(min = 10, max = 20, message = "The phone number should contains from 10 to 20 signs")
    private String phoneNumber;
    /**
     * This field represents a student's parent's phone number.
     */
    @Pattern(regexp = "[+]?[\\d]{9,20}", message = "The phone number should contains digits and/or '+'")
    @Size(min = 10, max = 20, message = "The phone number should contains from 10 to 20 signs")
    private String parentsPhoneNumber;
    /**
     * This field represents a student's date of birth.
     */
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Past(message = "A birthday should be a thing of the past")
    @NotNull(message = "DoB should be set")
    private final LocalDate dateOfBirth;

    /**
     * This constructor creates a student with specified parameters.
     *
     * @param name               student's name
     * @param surname            student's surname
     * @param studentsClass      student's class
     * @param phoneNumber        student's phone number
     * @param parentsPhoneNumber student's parent's phone number
     * @param dateOfBirth        student's date of birth
     */
    public Student(String name, @NotNull String surname, String studentsClass,
                   String phoneNumber, String parentsPhoneNumber, @NotNull LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.studentsClass = studentsClass;
        this.phoneNumber = phoneNumber;
        this.parentsPhoneNumber = parentsPhoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getStudentsClass() {
        return studentsClass;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getParentsPhoneNumber() {
        return parentsPhoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setStudentsClass(String studentsClass) {
        this.studentsClass = studentsClass;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setParentsPhoneNumber(String parentsPhoneNumber) {
        this.parentsPhoneNumber = parentsPhoneNumber;
    }

    /**
     * This method returns a string representation of a student.
     *
     * @return a string representation of a student
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentsClass='" + studentsClass + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", parentsPhoneNumber='" + parentsPhoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(surname, student.surname)
                && Objects.equals(studentsClass, student.studentsClass)
                && Objects.equals(phoneNumber, student.phoneNumber)
                && Objects.equals(parentsPhoneNumber, student.parentsPhoneNumber)
                && Objects.equals(dateOfBirth, student.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, studentsClass, phoneNumber, parentsPhoneNumber, dateOfBirth);
    }
}

