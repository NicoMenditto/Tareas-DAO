package utnfc.isi.back.infra;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;

public class DataSourceProvider {
    public static DataSource create() {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:legos;DB_CLOSE_DELAY=-1");
        ds.setUser("sa");
        ds.setPassword("");
        return ds;
    }
}
