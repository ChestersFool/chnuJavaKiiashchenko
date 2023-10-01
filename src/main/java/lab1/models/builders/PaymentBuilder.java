package lab1.models.builders;

import lab1.models.Group;
import lab1.models.Payment;
import lab1.models.Student;

import java.time.LocalDate;

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
    private static final IdGenerator idGenerator = new IdGenerator();
    private Student student;
    private Group group;
    private LocalDate paymentDate;

    public PaymentBuilder setStudent(Student student) {
        this.student = student;
        return this;
    }

    public PaymentBuilder setGroup(Group group) {
        this.group = group;
        return this;
    }

    public PaymentBuilder setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    /**
     * @return a {@link Payment} with specified parameters that you set before
     */
    @Override
    public Payment build() {
        return new lab1.models.Payment(idGenerator.getId(), student, group, paymentDate);
    }
}
