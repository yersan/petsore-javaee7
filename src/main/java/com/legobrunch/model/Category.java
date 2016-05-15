package com.legobrunch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
         @NamedQuery(name = Category.FIND_BY_NAME, query = "SELECT c FROM Category c WHERE c.name = :pname"),
         @NamedQuery(name = Category.FIND_ALL, query = "SELECT c FROM Category c")
})
@Table(name="categories")
public class Category extends BaseEntity
{

   public static final String FIND_BY_NAME = "Category.findByName";
   public static final String FIND_ALL = "Category.findAll";

   @Column(length = 30, nullable = false)
   @NotNull
   @Size(min = 1, max = 30)
   private String name;

   @Column(length = 3000, nullable = false)
   @NotNull
   @Size(max = 3000)
   private String description;

   public Category(){}

   public Category(String name, String description)
   {
      this.name = name;
      this.description = description;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   @Override
   public String toString() {
      return "Category{" +
              "name='" + name + '\'' +
              ", description='" + description + '\'' +
              '}';
   }
}
