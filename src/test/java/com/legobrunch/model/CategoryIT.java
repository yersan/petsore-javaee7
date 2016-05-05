package com.legobrunch.model;

import org.junit.Test;

/**
 * Created by Yeray Santana Borges on 5/5/16.
 */
public class CategoryIT extends PersistenceBase {

    @Test
    public void testMapping(){
        Category cut = new Category("NAME", "DESCRIPTION");
        cut.setId(1L);
        em().merge(cut);
    }
}