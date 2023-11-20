package db;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CreateDB db = new CreateDB();
        db.createStructure();
    }
}
