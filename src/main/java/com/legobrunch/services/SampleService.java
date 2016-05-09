package com.legobrunch.services;

import javax.ejb.Stateless;

/**
 * Created by Yeray Santana Borges on 8/5/16.
 */
@Stateless
public class SampleService {

    public String sampleMethod(){
        return "from a EJB";
    }
}
