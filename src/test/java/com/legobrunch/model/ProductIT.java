package com.legobrunch.model;

import org.junit.Test;

/**
 * Created by Yeray Santana Borges on 5/5/16.
 */
public class ProductIT extends PersistenceBase {

    @Test
    public void testMapping(){
        Category category = new Category("Name", "description");
        category.setId(1L);
        category = em().merge(category);

        Product cut = new Product("Product", "Product Description", category);
        cut.setId(1L);
        em().merge(cut);
    }
}
