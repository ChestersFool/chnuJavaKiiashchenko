package lab1.models.builders;

public class IdGenerator {
    private int id = 1;

    public int getId() {
        return id++;
    }
}
