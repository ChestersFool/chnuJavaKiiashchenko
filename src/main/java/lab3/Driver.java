package lab3;

import lab1.models.Paym;
import lab1.models.Payment;
import lab1.models.builders.GroupBuilder;
import lab1.models.builders.PaymentBuilder;
import lab1.models.builders.StudentBuilder;
import lab3.service.PaymServiceClassic;
import lab3.service.PaymServiceStream;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class Driver {
    public static void main(String[] args) {
        Set<Paym> payms = new TreeSet<>();
        payms.add(new Paym(LocalDate.of(2020, 10, 10), 1000, "First payment"));
        payms.add(new Paym(LocalDate.of(2021, 11, 10), 1100, "Second payment"));
        Payment payment = new PaymentBuilder().setStudent(new StudentBuilder().build()).
                setGroup(new GroupBuilder().build()).setPayms(payms).build();

//        System.out.println(payment);

//         Classic
//        PaymServiceClassic paymServiceClassic = new PaymServiceClassic(payms);
//        paymServiceClassic.add(new Paym(LocalDate.of(2022, 12, 10), 1200, "Third payment"));
//
//        System.out.println(payms);
//
//        paymServiceClassic.remove(1);
//
//        System.out.println(payms);
//
//        System.out.println("Sum: " + paymServiceClassic.getTotalSum());

//        // Stream API
        PaymServiceStream paymServiceStream = new PaymServiceStream(payms);
//        paymServiceStream.add(new Paym(LocalDate.of(2023, 1, 10), 1300, "Fourth payment"));

//        System.out.println(payment);
        paymServiceStream.remove(new Paym(LocalDate.of(2021, 11, 10), 1100, "Second payment"));
        System.out.println(payms);
//        paymServiceStream.remove(0);
//        System.out.println(payms);

//        System.out.println("Sum: " + paymServiceStream.getTotalSum());
    }
}
