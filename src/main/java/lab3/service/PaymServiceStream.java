package lab3.service;

import lab1.models.Paym;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PaymServiceStream implements PaymService {
    private Set<Paym> payms; // TreeSet - sorted by date (from last to first)

    public PaymServiceStream(Set<Paym> payms) {
        this.payms = payms;
    }

    public Set<Paym> getPayms() {
        return payms;
    }
    public boolean add(Paym paym) throws UnsupportedOperationException, ClassCastException,
            IllegalArgumentException {
        return payms.add(paym);
    }

    @Override
    public boolean remove(Paym paym) throws UnsupportedOperationException, ClassCastException {
        return payms.remove(paym);
    }

    @Override
    public boolean remove(int index) throws UnsupportedOperationException, ClassCastException {
        int i = 0;

        for (Paym paym : payms) {
            if (i == index) {
                return payms.remove(paym);
            }
            i++;
        }

        return false;
    }

//    @Override
//    public boolean add(Paym paym) {
//        return false;
//    }
//
//    @Override
//    public boolean remove(Paym paym) {
////        Set<Paym> resultTree = payms.stream().filter(p -> !p.equals(paym)).collect(Collectors.toSet());
////        if (resultTree.size() == payms.size()) {
////            return false;
////        }
////        payms = resultTree;
//////        payms.add(new Paym(LocalDate.of(2019, 11, 10), 1100, "Fifth payment"));
//////        payms.remove(paym);
//        return true;
//    }
//
//    @Override
//    public boolean remove(int index) {
////        AtomicInteger i = new AtomicInteger(0);
////        payms.forEach((elem) -> {
////            if (i.get() == index) {
////                payms.remove(elem);
////                return;
////            }
////            i.getAndIncrement();
////        });
//
//        return false;
//    }

    @Override
    public double getTotalSum() {
        return payms.stream().mapToDouble(Paym::getSum).sum();
//        return payms.stream().reduce(0.0, (sum, paym) -> sum + paym.getSum(), Double::sum);
    }

    @Override
    public List<Paym> byDescriptionPart(String descPart) {
        return payms.stream()
                .filter(paym -> paym.getDescription().toLowerCase().contains(descPart.toLowerCase()))
                .toList();
    }

    @Override
    public List<Paym> maxSum() {
//        Paym collectedPaym = payms.stream().max(Comparator.comparing(Paym::getSum)).get();
        double max = payms.stream().mapToDouble(Paym::getSum).max().getAsDouble();
        return payms.stream().filter(paym -> paym.getSum() == max).toList();
    }

    @Override
    public List<Paym> sortBySumDesc() {
//        return payms.stream().sorted((o1, o2) -> (int) (o2.getSum() - o1.getSum())).toList();
        return payms.stream().sorted(Comparator.comparing(Paym::getSum).reversed()).toList();
    }
}
