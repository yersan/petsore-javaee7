package com.legobrunch.services;

import com.legobrunch.model.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Yeray Santana Borges on 5/5/16.
 */
@Stateless
public class CategoriesService {

    @PersistenceContext
    EntityManager em;

    public List<Category> findAll(){
       return em.createNamedQuery(Category.FIND_ALL).getResultList();
    }
}
