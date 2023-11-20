package db;

import java.sql.*;

public class CreateDB {

    private Connection connection;

    CreateDB() throws SQLException {
        connection = new DataSourceMy().getConnection();
    }

    CreateDB(Connection connection) throws SQLException {
        this.connection = connection;
    }


    private void createStudentsTable() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("CREATE TABLE if not exists students (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(50) NOT NULL," +
                "surname VARCHAR(50) NOT NULL," +
                "studentsclass VARCHAR(8) NOT NULL," +
                "phonenumber VARCHAR(20) NOT NULL," +
                "parentphonenumber VARCHAR(20) NOT NULL," +
                "dateofbirth DATE NOT NULL" +
                ");");

        stmt.executeUpdate();
    }

    private void createGroupsTable() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("CREATE TABLE if not exists groups (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(50) NOT NULL," +
                "subject VARCHAR(50) NOT NULL," +
                "teachername VARCHAR(50) NOT NULL," +
                "cost float NOT NULL," +
                "dayofpayment int NOT NULL," +
                "fromage int NOT NULL," +
                "toage int NOT NULL" +
                ");");

        stmt.executeUpdate();
    }

    private void createStudGroup() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("CREATE TABLE if not exists studgroup (" +
                "id serial primary key," +
                "student_id int not null," +
                "group_id int not null," +
                "constraint student_id " +
                "foreign key (student_id) references students (id)" +
                "on update cascade on delete cascade," +
                "constraint group_id " +
                "foreign key (group_id) references groups (id)" +
                "on update cascade on delete cascade);");

        stmt.executeUpdate();
    }

    private void createPaymentsTable() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("create table if not exists payments (\n" +
                "id serial primary key unique not null," +
                "stud_group_id int not null," +
                "payment_date date not null," +
                "constraint stud_group_id " +
                "foreign key (stud_group_id) references studgroup (id)\n" +
                "on update cascade on delete cascade\n" +
                ");");

        stmt.executeUpdate();
    }

    public void createStructure() throws SQLException {
        createStudentsTable();
        createGroupsTable();
        createStudGroup();
        createPaymentsTable();
    }
}
