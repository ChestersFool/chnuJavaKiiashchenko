package lab2;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab1.models.Student;

import java.io.File;
import java.io.IOException;

public class XMLFile implements FileIO {
    private final XmlMapper xmlMapper;

    XMLFile() {
        this.xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void write(String filePath, Student student) throws IOException {
        xmlMapper.writeValue(new File(filePath), student);
    }

    @Override
    public Student read(String filePath) throws IOException {
        return xmlMapper.readValue(new File(filePath), Student.class);
    }
}
