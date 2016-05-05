package com.legobrunch.model;

import org.junit.Test;

/**
 * Created by Yeray Santana Borges on 5/5/16.
 */
public class ItemIT extends PersistenceBase {

    @Test
    public void testMapping(){

        Category category = new Category("Name", "description");
        category.setId(1L);
        category = em().merge(category);

        Product product = new Product("Product", "Product Description", category);
        product.setId(1L);
        product = em().merge(product);

        Item cut = new Item("Item", 10f, "/", "test item", product);
        cut.setId(1L);

        em().merge(cut);

    }
}
