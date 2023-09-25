package lab1;

import lab1.builders.GroupBuilder;
import lab1.builders.PaymentBuilder;
import lab1.builders.StudentBuilder;
import lab1.models.Group;
import lab1.models.Payment;
import lab1.models.Student;

public class Driver {

    public static void main(String[] args) {
        Student student = new StudentBuilder().setName("Ivan").setSurname("Ivanov").setStudentsClass("1-A").build();
        Group group = new GroupBuilder().setName("Math").setSubject("Math").setTeacherName("Anton").build();
        Payment payment = new PaymentBuilder().setStudent(student).setGroup(group).build();

        System.out.println(student);
        System.out.println(group);
        System.out.println(payment);
    }
}
