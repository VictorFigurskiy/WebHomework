package com.victor.web.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Sonikb on 19.07.2017.
 */
public class JpaUtil {
    private static EntityManagerFactory entityManagerFactory;

    static {
        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("persistence");

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    public static void shutDown(){
        entityManagerFactory.close();
    }

}
