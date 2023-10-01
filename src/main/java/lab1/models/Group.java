package lab1.models;

import java.util.Objects;

/**
 * This class represents a group.
 */
public class Group {
    /**
     * This field represents a group's id.
     */
    private final int id;
    /**
     * This field represents a group's name.
     */
    private String name;
    /**
     * This field represents a group's subject.
     */
    private String subject;
    /**
     * This field represents a group's teacher's name.
     */
    private String teacherName;
    /**
     * This field represents a group's cost.
     */
    private double cost;
    /**
     * This field represents a group's day of payment.
     */
    private int dayOfPayment;
    /**
     * This field represents a group's minimum age for the student.
     */
    private int fromAge;
    /**
     * This field represents a group's maximum age for the student.
     */
    private int toAge;

    /**
     * This constructor creates a group with specified parameters.
     *
     * @param id           group's id
     * @param name         group's name
     * @param subject      group's subject
     * @param teacher      group's teacher's name
     * @param cost         group's cost
     * @param dayOfPayment group's day of payment
     * @param fromAge      group's minimum age for the student.
     * @param toAge        group's maximum age for the student.
     */
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

    /**
     * This method returns a string representation of a group.
     *
     * @return a string representation of a group
     */
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

    /**
     * This method checks if two groups are equal.
     * Compares groups by {@link Group#id}.
     *
     * @param o an object to be compared with this group
     * @return true if two groups are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id;
    }

    /**
     * This method returns a hashcode of a group.
     *
     * @return a hashcode of a {@link Group#id}
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
