package com.legobrunch.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="products")
@NamedQueries({
         @NamedQuery(name = Product.FIND_BY_CATEGORY_NAME, query = "SELECT p FROM Product p WHERE p.category.name = :pname"),
         @NamedQuery(name = Product.FIND_ALL, query = "SELECT p FROM Product p")
})
public class Product extends BaseEntity
{
   public static final String FIND_BY_CATEGORY_NAME = "Product.findByCategoryName";
   public static final String FIND_ALL = "Product.findAll";

   @Column(length = 30, nullable = false)
   @NotNull
   @Size(min = 1, max = 30)
   private String name;

   @Column(length = 3000, nullable = false)
   @NotNull
   @Size(max = 3000)
   private String description;

   @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "category_fk", nullable = false)
   private Category category;

   public Product(){}

   public Product(String name, String description, Category category)
   {
      this.name = name;
      this.description = description;
      this.category = category;
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

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }
}
