package utnfc.isi.back.infra;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.stream.Collectors;

public class DbInitializer {
    private final String jdbcUrl = "jdbc:h2:mem:legos;DB_CLOSE_DELAY=-1";
    private final String user = "sa";
    private final String pass = "";

    public void init() throws Exception {
        try (Connection c = DriverManager.getConnection(jdbcUrl, user, pass);
             Statement s = c.createStatement()) {

            String ddl = readResourceAsString("/sql/ddl_legos.sql");
            for (String stmt : ddl.split(";\n")) {
                String t = stmt.trim();
                if (t.isEmpty()) continue;
                s.execute(t);
            }
        }
    }

    private String readResourceAsString(String path) throws Exception {
        try (InputStream in = getClass().getResourceAsStream(path)) {
            if (in == null) throw new IllegalStateException("Resource not found: " + path);
            try (BufferedReader r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
                return r.lines().collect(Collectors.joining("\n"));
            }
        }
    }
}
