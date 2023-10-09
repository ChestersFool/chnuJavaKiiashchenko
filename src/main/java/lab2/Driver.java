package lab2;

import lab1.models.Student;
import lab1.models.builders.StudentBuilder;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) {
        Student student = new StudentBuilder().setName("Ivan").setSurname("Ivanov").setStudentsClass("1-A").build();

        JsonFile jsonFile = new JsonFile();
        try {
            jsonFile.write("student.json", student);
            System.out.println(jsonFile.read("student.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        XMLFile xmlFile = new XMLFile();
        try {
            xmlFile.write("student.xml", student);
            System.out.println(xmlFile.read("student.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        TextFile textFile = new TextFile();
        try {
            textFile.write("student.txt", student);
            System.out.println(textFile.read("student.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
