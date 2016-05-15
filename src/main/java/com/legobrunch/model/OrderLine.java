package com.legobrunch.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_lines")
public class OrderLine extends BaseEntity
{
   @Column(nullable = false)
   @Min(1)
   private Integer quantity;

   @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "item_fk", nullable = false)
   private Item item;

   public OrderLine(){}

   public OrderLine(Integer quantity, Item item)
   {
      this.quantity = quantity;
      this.item = item;
   }

   @Override
   public String toString() {
      return "OrderLine{" +
              "quantity=" + quantity +
              ", item=" + item +
              '}';
   }
}
