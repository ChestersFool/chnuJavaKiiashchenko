package lab3.service;

import lab1.models.Paym;

import java.util.*;


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

    @Override
    public double getTotalSum() {
        return payms.stream().mapToDouble(Paym::getSum).sum();
    }

    @Override
    public List<Paym> byDescriptionPart(String descPart) {
        return payms.stream()
                .filter(paym -> paym.getDescription().toLowerCase().contains(descPart.toLowerCase()))
                .toList();
    }

    @Override
    public List<Paym> maxSum() {
        double max = payms.stream().mapToDouble(Paym::getSum).max().getAsDouble();
        return payms.stream().filter(paym -> paym.getSum() == max).toList();
    }

    @Override
    public List<Paym> sortBySumDesc() {
        return payms.stream().sorted(Comparator.comparing(Paym::getSum).reversed()).toList();
    }
}
