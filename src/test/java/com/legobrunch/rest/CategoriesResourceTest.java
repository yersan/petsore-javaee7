package com.legobrunch.rest;

import com.legobrunch.model.Category;
import com.legobrunch.services.CategoriesService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Yeray Santana Borges on 6/5/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoriesResourceTest {

    public CategoriesResource cut = new CategoriesResource();
    public InMemoryRestServer server;

    @Mock
    public CategoriesService categoriesService;

    @Before
    public void setUp() throws Exception {
        cut.categoriesService = categoriesService;
        server = InMemoryRestServer.create(cut);
    }

    @Test
    public void categories() throws Exception {
        Category category = new Category("name", "description");
        when(categoriesService.findAll()).thenReturn(Collections.singletonList(category));

        Response response = server.newRequest("/categories").request().buildGet().invoke();
        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));

        ArrayList categoryList = response.readEntity(ArrayList.class);
        System.out.print(categoryList);
    }

    @Test
    public void categories2() throws Exception {
        Category category = new Category("name2", "description2");
        when(categoriesService.findAll()).thenReturn(Collections.singletonList(category));

        Response response = server.newRequest("/categories").request().buildGet().invoke();
        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));

        ArrayList categoryList = response.readEntity(ArrayList.class);
        System.out.print(categoryList);
    }


    @After
    public void tearDown() throws Exception {
        server.close();
    }

}