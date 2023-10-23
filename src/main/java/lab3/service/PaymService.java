package lab3.service;

import lab1.models.Paym;

import java.util.List;

public interface PaymService {
boolean add(Paym paym);

    boolean remove(Paym paym);

    boolean remove(int index);

    double getTotalSum();

    List<Paym> byDescPart(String descPart);

    List<Paym> maxSum();

    List<Paym> sortBySum();
}
