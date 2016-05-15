package com.legobrunch.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="items")
@NamedQueries({
         @NamedQuery(name = Item.FIND_BY_PRODUCT_ID, query = "SELECT i FROM Item i WHERE i.product.id = :productId"),
         @NamedQuery(name = Item.SEARCH, query = "SELECT i FROM Item i WHERE UPPER(i.name) LIKE :keyword OR UPPER(i.product.name) LIKE :keyword ORDER BY i.product.category.name, i.product.name"),
         @NamedQuery(name = Item.FIND_ALL, query = "SELECT i FROM Item i")
})
public class Item extends BaseEntity
{
   public static final String FIND_BY_PRODUCT_ID = "Item.findByProductId";
   public static final String SEARCH = "Item.search";
   public static final String FIND_ALL = "Item.findAll";

   @Column(length = 30, nullable = false)
   @NotNull
   @Size(min = 1, max = 30)
   private String name;

   @Column(length = 3000, nullable = false)
   @NotNull
   @Size(max = 3000)
   private String description;

   @Column(name = "image_path")
   private String imagePath;

   @Column(name = "unit_cost", nullable = false)
   @NotNull
   private Float unitCost;

   @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "product_fk", nullable = false)
   private Product product;

   public Item(){}

   public Item(String name, Float unitCost, String imagePath, String description, Product product)
   {
      this.name = name;
      this.unitCost = unitCost;
      this.imagePath = imagePath;
      this.description = description;
      this.product = product;
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

   public String getImagePath() {
      return imagePath;
   }

   public void setImagePath(String imagePath) {
      this.imagePath = imagePath;
   }

   public Float getUnitCost() {
      return unitCost;
   }

   public void setUnitCost(Float unitCost) {
      this.unitCost = unitCost;
   }

   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   @Override
   public String toString() {
      return "Item{" +
              "name='" + name + '\'' +
              ", description='" + description + '\'' +
              ", imagePath='" + imagePath + '\'' +
              ", unitCost=" + unitCost +
              ", product=" + product +
              '}';
   }
}
