package lab3.service;

import lab1.models.Paym;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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

    @Override
    public boolean add(Paym paym) {
        return false;
    }

    @Override
    public boolean remove(Paym paym) {
//        Set<Paym> resultTree = payms.stream().filter(p -> !p.equals(paym)).collect(Collectors.toSet());
//        if (resultTree.size() == payms.size()) {
//            return false;
//        }
//        payms = new
        payms.add(new Paym(LocalDate.of(2021, 11, 10), 1100, "Fifth payment"));
        payms.remove(paym);
        return true;
    }

    @Override
    public boolean remove(int index) {
        AtomicInteger i = new AtomicInteger(0);
        payms.forEach((elem) -> {
            if (i.get() == index) {
                payms.remove(elem);
                return;
            }
            i.getAndIncrement();
        });

        return false;
    }

    @Override
    public double getTotalSum() {
        return payms.stream().reduce(0.0, (sum, paym) -> sum + paym.getSum(), Double::sum);
    }

    @Override
    public List<Paym> byDescPart(String descPart) {
        return null;
    }

    @Override
    public List<Paym> maxSum() {
        return null;
    }

    @Override
    public List<Paym> sortBySum() {
        return null;
    }
}
