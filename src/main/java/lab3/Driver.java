package lab3;

import lab1.models.Paym;
import lab3.service.PaymServiceStream;

import java.time.LocalDate;
import java.util.TreeSet;

public class Driver {
    public static void main(String[] args) {
        TreeSet<Paym> payms = new TreeSet<>();
        payms.add(new Paym(LocalDate.of(2020, 10, 10), 1000, "First payment"));
        payms.add(new Paym(LocalDate.of(2021, 11, 10), 1100, "Second payment"));
        payms.add(new Paym(LocalDate.of(2022, 11, 10), 1100, "5 payment"));

        System.out.println(payms);

        PaymServiceStream paymService = new PaymServiceStream(payms);
        paymService.add(new Paym(LocalDate.of(2022, 12, 10), 1200, "Third payment"));

        System.out.println("After add: " + payms);

        paymService.remove(1);

        System.out.println("After remove 1: " + payms);

        System.out.println("Sum: " + paymService.getTotalSum());

        System.out.println("By desc part (third): " + paymService.byDescriptionPart("Third"));
        System.out.println("By desc part (second): " + paymService.byDescriptionPart("Second"));

        System.out.println("Max sum: " + paymService.maxSum());

        System.out.println("Sorted by sum: " + paymService.sortBySumDesc());
    }
}
