package lab2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab1.models.Student;

import java.io.File;
import java.io.IOException;

public class JsonFile implements FileIO {
    private final ObjectMapper objectMapper;

    JsonFile() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
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
