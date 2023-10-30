package lab3.service;

import lab1.models.Paym;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PaymServiceClassic implements PaymService {
    private final Set<Paym> payms; // TreeSet - sorted by date (from last to first)

    public PaymServiceClassic(Set<Paym> payms) {
        this.payms = payms;
    }

    public Set<Paym> getPayms() {
        return payms;
    }

    @Override
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
        double sum = 0;

        for (Paym paym : payms) {
            sum += paym.getSum();
        }

        return sum;
    }

    @Override
    public List<Paym> byDescriptionPart(String descPart) {
        List<Paym> result = new ArrayList<>();

        for (Paym paym : payms) {
            if (paym.getDescription().contains(descPart)) {
                result.add(paym);
            }
        }

        return result;
    }

    @Override
    public List<Paym> maxSum() {
        List<Paym> result = new ArrayList<>();
        double maxSum = 0;

        for (Paym paym : payms) {
            if (paym.getSum() > maxSum) {
                maxSum = paym.getSum();
            }
        }

        for (Paym paym : payms) {
            if (paym.getSum() == maxSum) {
                result.add(paym);
            }
        }

        return result;
    }

    @Override
    public List<Paym> sortBySumDesc() {
        List<Paym> result = new ArrayList<>(payms);

        result.sort((o1, o2) -> (int) (o2.getSum() - o1.getSum()));

        return result;
    }

}
