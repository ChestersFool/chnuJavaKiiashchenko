package lab1.models.builders;

import lab1.models.Group;

/**
 * This class is used to build Group objects. Fields you can set: <ul>
 * <li>name</li>
 * <li>subject</li>
 * <li>teacherName</li>
 * <li>cost</li>
 * <li>dayOfPayment</li>
 * <li>fromAge</li>
 * <li>toAge</li>
 * </ul> ID is generated automatically.
 * Method {@link GroupBuilder#build()} returns a {@link Group} with specified parameters that you set before.
 *
 * @see Group
 */
public class GroupBuilder implements BuilderI<Group> {
    private String name;
    private String subject;
    private String teacherName;
    private double cost;
    private int dayOfPayment;
    private int fromAge;
    private int toAge;

    public GroupBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public GroupBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public GroupBuilder setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public GroupBuilder setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public GroupBuilder setDayOfPayment(int dayOfPayment) {
        this.dayOfPayment = dayOfPayment;
        return this;
    }

    public GroupBuilder setFromAge(int fromAge) {
        this.fromAge = fromAge;
        return this;
    }

    public GroupBuilder setToAge(int toAge) {
        this.toAge = toAge;
        return this;
    }

    /**
     * @return a {@link Group} with specified parameters that you set before
     */
    @Override
    public Group build() {
        return new Group(name, subject, teacherName,
                cost, dayOfPayment, fromAge, toAge);
    }
}
