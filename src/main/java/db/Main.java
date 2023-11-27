package db;

import lab1.models.Student;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        CreateDB db = new CreateDB();
        db.dropStructure();
        db.createStructure();

        Student student1 = new Student("Misha1", "Kiiashchenko",
                "11-A", "1111111111111", "1111111111111",
                LocalDate.of(2004, 11, 20));

        Student student2 = new Student("Misha2", "Kiiashchenko",
                "11-A", "1111111111111", "1111111111111",
                LocalDate.of(2004, 11, 20));

        System.out.println("Amount of inserted rows: " + db.insertStudent(student1));
        System.out.println("Amount of inserted rows: " + db.insertStudent(student2));
        System.out.println(db.readAllStudents());

        Student student3 = new Student("Misha3", "Kiiashchenko",
                "11-A", "1111111111111", "1111111111111",
                LocalDate.of(2004, 11, 20));
        System.out.println("Amount of updated rows: " + db.updateStudent(1, student3));
        System.out.println(db.readStudent(1));

        System.out.println("Amount of deleted rows: " + db.deleteStudent(1));
        System.out.println(db.readStudent(1));

        System.out.println("Amount of deleted rows: " + db.deleteAllStudents());
        System.out.println(db.readAllStudents());
    }
}
