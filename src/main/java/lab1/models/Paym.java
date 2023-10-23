package lab1.models;

import java.time.LocalDate;
import java.util.Objects;

public class Paym implements Comparable<Paym> {
    private LocalDate date;
    private double sum;
    private String description;

    public Paym(LocalDate date, double sum, String description) {
        this.date = date;
        this.sum = sum;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Paym{" +
                "date=" + date +
                ", sum=" + sum +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paym paym = (Paym) o;
        return Double.compare(paym.sum, sum) == 0 && Objects.equals(date, paym.date)
                && Objects.equals(description, paym.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, sum, description);
    }

    @Override
    public int compareTo(Paym o) {
        return o.date.compareTo(this.date);
    }
}
