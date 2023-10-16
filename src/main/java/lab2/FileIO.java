package lab2;

import lab1.models.Student;

import java.io.IOException;

public interface FileIO {
    void write(String filePath, Student student) throws IOException;

    Student read(String filePath) throws IOException;
}
