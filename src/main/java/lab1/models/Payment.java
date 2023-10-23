package lab1.models;

import java.util.Objects;
import java.util.Set;

/**
 * This class represents a payment.
 */
public class Payment {
    /**
     * This field represents a payment's student.
     */
    private final Student student;
    /**
     * This field represents a payment's group.
     */
    private final Group group;
    //    /**
//     * This field represents a payment's date.
//     */
//    private final LocalDate paymentDate;
    private Set<Paym> payms; // TreeSet - sorted by date (from last to first)

    /**
     * This constructor creates a payment with specified parameters.
     *
     * @param student payment's student
     * @param group   payment's group
     * @param payms   payments
     */
    public Payment(Student student, Group group, Set<Paym> payms) {
        this.student = student;
        this.group = group;
        this.payms = payms;
    }

    public Student getStudent() {
        return student;
    }

    public Group getGroup() {
        return group;
    }

    public Set<Paym> getPayms() {
        return payms;
    }

    /**
     * This method returns a string representation of a payment.
     *
     * @return a string representation of a payment
     */
    @Override
    public String toString() {
        return "Payment{" +
                "student=" + student +
                ",\n\tgroup=" + group +
                ",\n\tpayms=" + payms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(student, payment.student) && Objects.equals(group, payment.group)
                && Objects.equals(payms, payment.payms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, group, payms);
    }
}

