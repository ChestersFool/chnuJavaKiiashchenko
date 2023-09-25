package lab1.builders;

import lab1.models.Group;

public class GroupBuilder implements BuilderI<Group> {
    private static final IdGenerator idGenerator = new IdGenerator();
    private String name;
    private String subject;
    private String teacherName;
    private double cost;
    private int dayOfPayment;
    private int fromAge;
    private int toAge;

    public GroupBuilder() {
        cost = 0;
        fromAge = 5;
        toAge = 6;
    }

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

    public Group build() {
        return new Group(idGenerator.getId(), name, subject, teacherName,
                cost, dayOfPayment, fromAge, toAge);
    }
}
