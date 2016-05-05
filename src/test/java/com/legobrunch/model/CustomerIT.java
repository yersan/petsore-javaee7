package com.legobrunch.model;

import org.junit.Test;

/**
 * Created by Yeray Santana Borges on 5/5/16.
 */
public class CustomerIT extends PersistenceBase {

    @Test
    public void testMapping(){

        Country country = new Country("ES", "SPAIN", "Spain", "ESP");
        country.setId(1L);
        country = em().merge(country);

        Address address = new Address("Street1", "city", "zipcode", country);
        Customer cut = new Customer("Test", "Test", "TEST", "TEST", "test@test.com", address);
        em().merge(cut);

    }
}
