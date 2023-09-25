package lab1.builders;

import lab1.models.Group;
import lab1.models.Payment;
import lab1.models.Student;

import java.time.LocalDate;

public class PaymentBuilder implements BuilderI<Payment>{
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

    public lab1.models.Payment build() {
        return new lab1.models.Payment(idGenerator.getId(), student, group, paymentDate);
    }
}
