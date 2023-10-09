package lab2;

import lab1.models.Student;
import lab1.models.builders.StudentBuilder;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;

public class TextFile implements IOFile {

    @Override
    public void write(String filePath, Student student) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)));
        writer.write(student.getName() + ";" + student.getSurname() + ";" + student.getStudentsClass() + ";"
                + student.getPhoneNumber() + ";" + student.getParentsPhoneNumber() + ";" + student.getDateOfBirth());

        writer.close();
    }

    @Override
    public Student read(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
        String[] studentData = reader.readLine().split(";");
        reader.close();

        if (studentData[5].equals("null")) {
            studentData[5] = "1900-01-01";
        }

        return new StudentBuilder().setName(studentData[0]).setSurname(studentData[1]).
                setStudentsClass(studentData[2]).setPhoneNumber(studentData[3]).setParentsPhoneNumber(studentData[4]).
                setDateOfBirth(LocalDate.parse(studentData[5])).build();
    }
}
