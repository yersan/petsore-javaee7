package com.legobrunch.model;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by Yeray Santana Borges on 5/5/16.
 */
public class PersistenceUnitRule implements TestRule {
    public EntityManager em;

   public PersistenceUnitRule(String unitName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitName);
        this.em = emf.createEntityManager();
    }

    private void begin(){
        em.getTransaction().begin();
    }

    private void rollback(){
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }

    private void commit(){
        em.getTransaction().commit();
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                begin();
                base.evaluate();
                commit();
            }
        };
    }
}
