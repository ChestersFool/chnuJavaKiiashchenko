package lab1.models;

import java.time.LocalDate;
import java.util.Objects;

public class Payment {
    private final int id;
    private final Student student;
    private final Group group;
    private final LocalDate paymentDate;

    public Payment(int id, Student student, Group group, LocalDate paymentDate) {
        this.id = id;
        this.student = student;
        this.group = group;
        this.paymentDate = paymentDate;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ",\n\tstudent=" + student +
                ",\n\tgroup=" + group +
                ",\n\tpaymentDate=" + paymentDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

