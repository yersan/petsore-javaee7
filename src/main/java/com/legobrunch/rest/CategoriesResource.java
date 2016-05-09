package com.legobrunch.rest;

import com.legobrunch.model.Category;
import com.legobrunch.services.CategoriesService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yeray Santana Borges on 5/5/16.
 */
@Path("categories")
@Produces(value = MediaType.APPLICATION_JSON)
public class CategoriesResource {

    @EJB
    CategoriesService categoriesService;

    @GET
    public Response categories(){
        List<Category> data = categoriesService.findAll();
        List<CategoryRest> ret = new ArrayList<>();
        for (Category category : data) {
            CategoryRest restData = new CategoryRest.Builder().withCategory(category).build();
            ret.add(restData);
        }

        GenericEntity<List<CategoryRest>> l = new GenericEntity<List<CategoryRest>>(ret){};
        return Response.ok(l).build();
    }


}
