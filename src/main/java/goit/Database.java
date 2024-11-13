package goit;

import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;
    private Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Flyway flyway = Flyway.configure()
                    .dataSource("jdbc:h2:~/test", "sa", "")
                    .load();


            flyway.migrate();
            var info = flyway.info();
            var migrationInfos = info.all(); // Получает все миграции

            for (var migrationInfo : migrationInfos) {
                System.out.println("Version: " + migrationInfo.getVersion() +
                        ", Description: " + migrationInfo.getDescription() +
                        ", Status: " + migrationInfo.getState());}
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
