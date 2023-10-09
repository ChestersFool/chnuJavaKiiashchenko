package lab1.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * This class represents a payment.
 */
public class Payment {
    /**
     * This field represents a payment's id.
     */
    private final int id;
    /**
     * This field represents a payment's student.
     */
    private final Student student;
    /**
     * This field represents a payment's group.
     */
    private final Group group;
    /**
     * This field represents a payment's date.
     */
    private final LocalDate paymentDate;
//    private Set<Paym> payms; // TreeSet - sorted by date (from last to first)

    /**
     * This constructor creates a payment with specified parameters.
     *
     * @param id          payment's id
     * @param student     payment's student
     * @param group       payment's group
     * @param paymentDate payment's date
     */
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

    /**
     * This method returns a string representation of a payment.
     *
     * @return a string representation of a payment
     */
    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ",\n\tstudent=" + student +
                ",\n\tgroup=" + group +
                ",\n\tpaymentDate=" + paymentDate +
                '}';
    }

    /**
     * This method compares two payments.
     * Compares payments by {@link Payment#id}.
     *
     * @param o payment to compare
     * @return true if payments are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id;
    }

    /**
     * This method returns a hashcode of a payment.
     *
     * @return a hashcode of a {@link Payment}
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

