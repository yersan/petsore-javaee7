package com.legobrunch.model;

import org.junit.Test;

/**
 * Created by Yeray Santana Borges on 5/5/16.
 */
public class CountryIT extends PersistenceBase {

    @Test
    public void testMapping(){
        Country cut = new Country("ES", "SPAIN", "Spain", "ESP");
        cut.setId(1L);
        em().merge(cut);
    }
}
