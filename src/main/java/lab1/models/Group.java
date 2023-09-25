package lab1.models;

import java.util.Objects;

public class Group {
    private final int id;
    private String name;
    private String subject;
    private String teacherName;
    private double cost;
    private int dayOfPayment;
    private int fromAge;
    private int toAge;

    public Group(int id, String name, String subject, String teacher,
                 double cost, int dayOfPayment, int fromAge, int toAge) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.teacherName = teacher;
        this.cost = cost;
        this.dayOfPayment = dayOfPayment;
        this.fromAge = fromAge;
        this.toAge = toAge;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public double getCost() {
        return cost;
    }

    public int getDayOfPayment() {
        return dayOfPayment;
    }

    public int getFromAge() {
        return fromAge;
    }

    public int getToAge() {
        return toAge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDayOfPayment(int dayOfPayment) {
        this.dayOfPayment = dayOfPayment;
    }

    public void setFromAge(int fromAge) {
        this.fromAge = fromAge;
    }

    public void setToAge(int toAge) {
        this.toAge = toAge;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", cost=" + cost +
                ", dayOfPayment=" + dayOfPayment +
                ", fromAge=" + fromAge +
                ", toAge=" + toAge +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
