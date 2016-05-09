package com.legobrunch.rest;

import com.legobrunch.model.Category;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by Yeray Santana Borges on 5/5/16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryRest {
    public Long id;
    public String name;
    public String description;


    @XmlTransient
    public static class Builder {
        CategoryRest rest = new CategoryRest();

        public Builder withCategory(Category category){
            this.rest.id = category.getId();
            this.rest.name = category.getName();
            this.rest.description = category.getDescription();

            return this;
        }

        CategoryRest build(){
            return this.rest;
        }
    }
}
