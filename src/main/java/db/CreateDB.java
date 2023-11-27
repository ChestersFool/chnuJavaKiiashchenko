package db;

import lab1.models.Student;

import java.sql.*;
import java.util.ArrayList;

public class CreateDB {

    private final Connection connection;

    CreateDB() throws SQLException {
        connection = new DataSourceMy().getConnection();
    }

    CreateDB(Connection connection) throws SQLException {
        this.connection = connection;
    }


    private void createStudentsTable() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("""
                CREATE TABLE if not exists students (
                id SERIAL PRIMARY KEY,
                name VARCHAR(50) NOT NULL,
                surname VARCHAR(50) NOT NULL,
                studentsclass VARCHAR(8) NOT NULL,
                phonenumber VARCHAR(20) NOT NULL,
                parentphonenumber VARCHAR(20) NOT NULL,
                dateofbirth DATE NOT NULL
                );""");

        stmt.executeUpdate();
    }

    private void createGroupsTable() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("""
                CREATE TABLE if not exists groups (
                id SERIAL PRIMARY KEY,
                name VARCHAR(50) NOT NULL,
                subject VARCHAR(50) NOT NULL,
                teachername VARCHAR(50) NOT NULL,
                cost float NOT NULL,
                dayofpayment int NOT NULL,
                fromage int NOT NULL,
                toage int NOT NULL
                );""");

        stmt.executeUpdate();
    }

    private void createStudGroup() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("""
                CREATE TABLE if not exists studgroup (
                id serial primary key,
                student_id int not null,
                group_id int not null,
                                
                constraint student_id
                foreign key (student_id) references students (id)
                on update cascade on delete cascade,
                                
                constraint group_id
                foreign key (group_id) references groups (id)
                on update cascade on delete cascade);""");

        stmt.executeUpdate();
    }

    private void createPaymentsTable() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("""
                create table if not exists payments (
                id serial primary key unique not null,
                stud_group_id int not null,
                payment_date date not null,
                constraint stud_group_id foreign key (stud_group_id) references studgroup (id)
                on update cascade on delete cascade
                );""");

        stmt.executeUpdate();
    }

    public void createStructure() throws SQLException {
        createStudentsTable();
        createGroupsTable();
        createStudGroup();
        createPaymentsTable();
    }

    public void dropStructure() throws SQLException {
        PreparedStatement stmt = connection
                .prepareStatement("DROP TABLE IF EXISTS payments, studgroup, groups, students;");
        stmt.executeUpdate();
    }

    public int insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (name, surname, studentsclass, phonenumber, parentphonenumber, dateofbirth)" +
                " VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        prepareStmtStudent(stmt, student);

        return stmt.executeUpdate();
    }

    public ArrayList<Student> readAllStudents() throws SQLException {
        String sql = "SELECT * FROM students";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        ArrayList<Student> res = new ArrayList<>();

        while (resultSet.next()) {
            res.add(new Student(resultSet.getString(2)
                    , resultSet.getString(3)
                    , resultSet.getString(4)
                    , resultSet.getString(5)
                    , resultSet.getString(6)
                    , resultSet.getDate(7).toLocalDate()));
        }

        return res;
    }

    public Student readStudent(int id) throws SQLException {
        String sql = "SELECT * FROM students WHERE id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();

        if (resultSet.next()) {
            return new Student(resultSet.getString(2)
                    , resultSet.getString(3)
                    , resultSet.getString(4)
                    , resultSet.getString(5)
                    , resultSet.getString(6)
                    , resultSet.getDate(7).toLocalDate());
        }

        return null;
    }

    public int updateStudent(int id, Student student) throws SQLException {
        String sql = "UPDATE students SET name = ?, surname = ?, studentsclass = ?, phonenumber = ?," +
                " parentphonenumber = ?, dateofbirth = ? WHERE id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        prepareStmtStudent(stmt, student);
        stmt.setInt(7, id);
        return stmt.executeUpdate();
    }

    public int deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        return stmt.executeUpdate();
    }

    public int deleteAllStudents() throws SQLException {
        String sql = "DELETE FROM students";

        PreparedStatement stmt = connection.prepareStatement(sql);
        return stmt.executeUpdate();
    }

    private void prepareStmtStudent(PreparedStatement stmt, Student student) throws SQLException {
        stmt.setString(1, student.getName());
        stmt.setString(2, student.getSurname());
        stmt.setString(3, student.getStudentsClass());
        stmt.setString(4, student.getPhoneNumber());
        stmt.setString(5, student.getParentsPhoneNumber());
        stmt.setDate(6, Date.valueOf(student.getDateOfBirth().toString()));
    }
}
