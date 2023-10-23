package lab1;

import lab1.models.Paym;
import lab1.models.builders.GroupBuilder;
import lab1.models.builders.PaymentBuilder;
import lab1.models.builders.StudentBuilder;
import lab1.models.Group;
import lab1.models.Payment;
import lab1.models.Student;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class Driver {

    public static void main(String[] args) {
        Student student = new StudentBuilder().setName("Ivan").setSurname("Ivanov").setStudentsClass("1-A").build();
        Student student1 = new StudentBuilder().setName("Ivan").setSurname("Ivanov").setStudentsClass("1-A").build();
        Group group = new GroupBuilder().setName("Math").setSubject("Math").setTeacherName("Anton").build();

        Set<Paym> payms = new TreeSet<>();
        payms.add(new Paym(LocalDate.of(2020, 10, 10), 1000, "First payment"));
        payms.add(new Paym(LocalDate.of(2021, 11, 10), 1100, "Second payment"));
        Payment payment = new PaymentBuilder().setStudent(student).
                setGroup(group).setPayms(payms).build();

        // alt + j
        System.out.println(student);
        System.out.println(student1);
        System.out.println(group);
        System.out.println(payment);

        if (student.equals(student1)) {
            System.out.println("Students are equal");
        } else {
            System.out.println("Students are not equal");
        }

        System.out.println("Student hashcode: " + student.hashCode() + "\nStudent1 hashcode: " + student1.hashCode());
    }
}
