package lab2;

import lab1.models.Student;
import lab1.models.builders.StudentBuilder;

import java.io.*;
import java.time.LocalDate;

public class TextFile implements FileIO {

    @Override
    public void write(String filePath, Student student) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(student.getName() + ";" + student.getSurname() + ";" + student.getStudentsClass() + ";"
                    + student.getPhoneNumber() + ";" + student.getParentsPhoneNumber() + ";" + student.getDateOfBirth());
        }
    }

    @Override
    public Student read(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String[] studentData = reader.readLine().split(";");
        reader.close();

        LocalDate date = studentData[5].equals("null") ? null : LocalDate.parse(studentData[5]);

        return new StudentBuilder().setName(studentData[0]).setSurname(studentData[1]).
                setStudentsClass(studentData[2]).setPhoneNumber(studentData[3]).setParentsPhoneNumber(studentData[4]).
                setDateOfBirth(date).build();
    }
}
