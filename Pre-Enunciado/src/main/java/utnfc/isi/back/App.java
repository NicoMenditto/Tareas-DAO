package utnfc.isi.back;

import utnfc.isi.back.infra.DbInitializer;
import utnfc.isi.back.infra.LocalEntityManagerProvider;

import jakarta.persistence.EntityManager;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Inicializando BD...");
        DbInitializer init = new DbInitializer();
        init.init();
        System.out.println("BD inicializada.");

        var emf = LocalEntityManagerProvider.get();
        EntityManager em = emf.createEntityManager();
        try {
            var countries = em.createQuery("SELECT c FROM Country c", Object.class).getResultList();
            System.out.println("Countries count: " + countries.size());
        } finally {
            em.close();
            LocalEntityManagerProvider.close();
        }
    }
}
