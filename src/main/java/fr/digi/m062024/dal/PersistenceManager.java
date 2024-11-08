package fr.digi.m062024.dal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.Persistence;

public final class PersistenceManager {

    private static EntityManagerFactory emf;

    private PersistenceManager() {
    }

    public static EntityManager getEntityManager() {
        return null;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("default");
        }
        return emf;
    }

    public static void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
        }
    }
}
