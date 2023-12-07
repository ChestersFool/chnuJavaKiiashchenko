package db;

import lab1.models.Student;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        CreateDB db = new CreateDB();
        System.out.println("Total sum: " + db.getTotalSum(1));
        System.out.println("By description part: " + db.getByDescriptionPart("1", 1));
        System.out.println("Max sum: " + db.getMaxSum(1));
        System.out.println("Payments sorted by sum desc: " + db.getPaymsSortBySumDesc(1));
//        db.dropStructure();
//        db.createStructure();
//
//        Student student1 = new Student("Misha", "Kiiashchenko",
//                "11-B", "1111111111111", "1111111111111",
//                LocalDate.of(2004, 11, 20));
//
//        Student student2 = new Student("Mishaaaaaa", "Kiiashchenko",
//                "11-C", "1111111111111", "1111111111111",
//                LocalDate.of(2004, 11, 20));
//
//        System.out.println("Amount of inserted rows: " + db.insertStudent(student1));
//        System.out.println("Amount of inserted rows: " + db.insertStudent(student2));
//        System.out.println(db.readAllStudents());
//
//        Student student3 = new Student("Kisha", "Kiiashchenko",
//                "11-D", "1111111111111", "1111111111111",
//                LocalDate.of(2004, 11, 20));
//        System.out.println("Amount of updated rows: " + db.updateStudent(1, student3));
//        System.out.println(db.readStudent(1));
//
//        try {
//            System.out.println("Amount of deleted rows: " + db.deleteStudent(1));
//            System.out.println(db.readStudent(1));
//        } catch (SQLException e) {
//            System.out.println("Student with id = 1 doesn't exist");
//        }
//
//        System.out.println("Amount of deleted rows: " + db.deleteAllStudents());
//        System.out.println(db.readAllStudents());
    }
}
