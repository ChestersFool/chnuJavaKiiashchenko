package db;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
    public static void main(String[] args) {
        final DataSource dataSource = createDataSource();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            getAllStudents(conn);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    private static DataSource createDataSource() {
        final String url = "jdbc:postgresql://localhost:5432/SchoolCircles?user=postgres&password=kod675mi";
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();

        dataSource.setURL(url);

        return dataSource;
    }

    private static void getAllStudents(Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("Name: " + rs.getString("studentname") +
                    "; Last name: " + rs.getString("studentlastname") +
                    "; Student Class: " + rs.getString("studentclass") +
                    "; Phone: " + rs.getString("phonenumber") + ";");
        }
    }
}
