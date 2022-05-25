package com.lebedev.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

public class EmfUtil {
    private static EntityManagerFactory emf;

    public static EntityManagerFactory entityManagerFactory() {
        if (Objects.isNull(emf)) {
            emf = Persistence.createEntityManagerFactory(
                    "CinemaPersistence");
        }
        return emf;
    }
}