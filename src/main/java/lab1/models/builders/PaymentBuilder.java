package lab1.models.builders;

import lab1.models.Group;
import lab1.models.Paym;
import lab1.models.Payment;
import lab1.models.Student;

import java.time.LocalDate;
import java.util.Set;

/**
 * This class is used to build Payment objects. Fields you can set: <ul>
 * <li>student</li>
 * <li>group</li>
 * <li>paymentDate</li>
 * </ul> ID is generated automatically.
 * Method {@link PaymentBuilder#build()} returns a {@link Payment} with specified parameters that you set before.
 *
 * @see Payment
 */
public class PaymentBuilder implements BuilderI<Payment> {
    private Student student;
    private Group group;
    private Set<Paym> payms; // TreeSet - sorted by date (from last to first)

    public PaymentBuilder setStudent(Student student) {
        this.student = student;
        return this;
    }

    public PaymentBuilder setGroup(Group group) {
        this.group = group;
        return this;
    }

    public PaymentBuilder setPayms(Set<Paym> payms) {
        this.payms = payms;
        return this;
    }

    /**
     * @return a {@link Payment} with specified parameters that you set before
     */
    @Override
    public Payment build() {
        return new lab1.models.Payment(student, group, payms);
    }
}
