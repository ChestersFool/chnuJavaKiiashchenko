package lab1.models.builders;

import lab1.models.Student;

import java.time.LocalDate;

/**
 * This class is used to build Student objects. Fields you can set: <ul>
 * <li>name</li>
 * <li>surname</li>
 * <li>studentsClass</li>
 * <li>phoneNumber</li>
 * <li>parentsPhoneNumber</li>
 * <li>dateOfBirth</li>
 * </ul> ID is generated automatically.
 * Method {@link StudentBuilder#build()} returns a {@link Student} with specified parameters that you set before.
 *
 * @see Student
 */
public class StudentBuilder implements BuilderI<Student> {
    private static final IdGenerator idGenerator = new IdGenerator();
    private String name;
    private String surname;
    private String studentsClass;
    private String phoneNumber;
    private String parentsPhoneNumber;
    private LocalDate dateOfBirth;

    public StudentBuilder() {
        phoneNumber = "+380900000000";
        parentsPhoneNumber = "+380900000000";
        dateOfBirth = LocalDate.of(2017, 1, 1);
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public StudentBuilder setStudentsClass(String studentsClass) {
        this.studentsClass = studentsClass;
        return this;
    }

    public StudentBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public StudentBuilder setParentsPhoneNumber(String parentsPhoneNumber) {
        this.parentsPhoneNumber = parentsPhoneNumber;
        return this;
    }

    public StudentBuilder setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * @return a {@link Student} with specified parameters that you set before
     */
    @Override
    public Student build() {
        return new Student(idGenerator.getId(), name, surname,
                studentsClass, phoneNumber, parentsPhoneNumber, dateOfBirth);
    }
}
