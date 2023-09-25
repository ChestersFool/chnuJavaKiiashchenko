package lab1.builders;

public class IdGenerator {
    private int id = 1;

    public int getId() {
        return id++;
    }
}
