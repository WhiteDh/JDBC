package goit;

import org.flywaydb.core.Flyway;

public class FlywayMigrationService {

    public static void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:~/test", "sa", "")
                .load();

        flyway.repair();

        // Run the migrations
        flyway.migrate();
    }
}
