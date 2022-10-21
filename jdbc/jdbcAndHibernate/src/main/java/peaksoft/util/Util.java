package peaksoft.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Util {
    // реализуйте настройку соеденения с БД

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("softpeak");

    public static EntityManager creatEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
