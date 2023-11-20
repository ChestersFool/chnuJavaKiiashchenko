package db;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceMy {
    private Connection connection;
    private String configFile = "confige";

    private void createDataSource() throws SQLException {
        ClassLoader classLoader = DataSourceMy.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(configFile);
        Properties prop = new Properties();

        try {
            final String url = "jdbc:postgresql://localhost:5432/";
            final PGSimpleDataSource dataSource = new PGSimpleDataSource();

            prop.load(inputStream);

            dataSource.setURL(url);
            dataSource.setDatabaseName(prop.getProperty("db_name"));
            dataSource.setUser(prop.getProperty("user"));
            dataSource.setPassword(prop.getProperty("password"));

            connection = dataSource.getConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            createDataSource();
        }
        return connection;
    }
}
