package com.legobrunch.model;

import org.junit.Test;

/**
 * Created by Yeray Santana Borges on 5/5/16.
 */
public class PurcharseOrderIT extends PersistenceBase {

    @Test
    public void testMapping(){
        Country country = new Country("ES", "SPAIN", "Spain", "ESP");
        country.setId(1L);
        country = em().merge(country);

        Address address = new Address("Street1", "city", "zipcode", country);

        Customer customer = new Customer("Test", "Test", "TEST", "TEST", "test@test.com", address);
        customer = em().merge(customer);

        CreditCard creditCard = new CreditCard("000111220011", CreditCardType.MASTER_CARD, "10/10");
        PurchaseOrder cut = new PurchaseOrder(customer,creditCard, address);
        cut.setId(1L);

        em().merge(cut);
    }

}
