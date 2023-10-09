package lab2;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab1.models.Student;

import java.io.File;
import java.io.IOException;

public class JsonFile implements IOFile {
    private final ObjectMapper objectMapper;

    JsonFile() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void write(String filePath, Student student) throws IOException {
        objectMapper.writeValue(new File(filePath), student);
    }

    @Override
    public Student read(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), Student.class);
    }
}
