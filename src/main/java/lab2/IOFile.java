package lab2;

import lab1.models.Student;

import java.io.IOException;
import java.io.Serializable;

public interface IOFile extends Serializable {
    void write(String filePath, Student student) throws IOException;

    Student read(String filePath) throws IOException;
}
