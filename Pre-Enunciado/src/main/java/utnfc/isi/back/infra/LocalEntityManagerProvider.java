package utnfc.isi.back.infra;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocalEntityManagerProvider {
    private static EntityManagerFactory emf;

    public static EntityManagerFactory get() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("legosPU");
        }
        return emf;
    }

    public static void close() {
        if (emf != null) emf.close();
    }
}
