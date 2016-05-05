package com.legobrunch.model;

import org.junit.Rule;

import javax.persistence.EntityManager;

/**
 * Created by Yeray Santana Borges on 5/5/16.
 */
public class PersistenceBase {
    @Rule
    public  PersistenceUnitRule pur = new PersistenceUnitRule("it-persistence");

    public EntityManager em() {
        return pur.em;
    }
}
