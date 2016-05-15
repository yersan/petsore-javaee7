package com.legobrunch.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "purchase_orders")
@NamedQueries({
         @NamedQuery(name = PurchaseOrder.FIND_ALL, query = "SELECT o FROM PurchaseOrder o")
})
public class PurchaseOrder extends BaseEntity
{
   public static final String FIND_ALL = "Order.findAll";


   @Column(name = "order_date", updatable = false)
   @Temporal(TemporalType.DATE)
   private Date orderDate;

   private Float totalWithoutVat;

   @Column(name = "vat_rate")
   private Float vatRate;

   private Float vat;

   private Float totalWithVat;

   @Column(name = "discount_rate")
   private Float discountRate;

   private Float discount;

   private Float total;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "customer_fk", nullable = false)
   private Customer customer;

   @OneToMany
   @JoinTable(name = "t_order_order_line", joinColumns = { @JoinColumn(name = "order_fk") }, inverseJoinColumns = {
            @JoinColumn(name = "order_line_fk") })
   private Set<OrderLine> orderLines = new HashSet<>();

   @Embedded
   private Address deliveryAddress = new Address();

   @Embedded
   private CreditCard creditCard = new CreditCard();

   public PurchaseOrder(){}

   public PurchaseOrder(Customer customer, CreditCard creditCard, Address deliveryAddress)
   {
      this.customer = customer;
      this.creditCard = creditCard;
      this.deliveryAddress = deliveryAddress;
   }

   public Date getOrderDate() {
      return orderDate;
   }

   public void setOrderDate(Date orderDate) {
      this.orderDate = orderDate;
   }

   public Float getTotalWithoutVat() {
      return totalWithoutVat;
   }

   public void setTotalWithoutVat(Float totalWithoutVat) {
      this.totalWithoutVat = totalWithoutVat;
   }

   public Float getVatRate() {
      return vatRate;
   }

   public void setVatRate(Float vatRate) {
      this.vatRate = vatRate;
   }

   public Float getVat() {
      return vat;
   }

   public void setVat(Float vat) {
      this.vat = vat;
   }

   public Float getTotalWithVat() {
      return totalWithVat;
   }

   public void setTotalWithVat(Float totalWithVat) {
      this.totalWithVat = totalWithVat;
   }

   public Float getDiscountRate() {
      return discountRate;
   }

   public void setDiscountRate(Float discountRate) {
      this.discountRate = discountRate;
   }

   public Float getDiscount() {
      return discount;
   }

   public void setDiscount(Float discount) {
      this.discount = discount;
   }

   public Float getTotal() {
      return total;
   }

   public void setTotal(Float total) {
      this.total = total;
   }

   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   public Set<OrderLine> getOrderLines() {
      return orderLines;
   }

   public void setOrderLines(Set<OrderLine> orderLines) {
      this.orderLines = orderLines;
   }

   public Address getDeliveryAddress() {
      return deliveryAddress;
   }

   public void setDeliveryAddress(Address deliveryAddress) {
      this.deliveryAddress = deliveryAddress;
   }

   public CreditCard getCreditCard() {
      return creditCard;
   }

   public void setCreditCard(CreditCard creditCard) {
      this.creditCard = creditCard;
   }

   @Override
   public String toString() {
      return "PurchaseOrder{" +
              "orderDate=" + orderDate +
              ", totalWithoutVat=" + totalWithoutVat +
              ", vatRate=" + vatRate +
              ", vat=" + vat +
              ", totalWithVat=" + totalWithVat +
              ", discountRate=" + discountRate +
              ", discount=" + discount +
              ", total=" + total +
              ", customer=" + customer +
              ", orderLines=" + orderLines +
              ", deliveryAddress=" + deliveryAddress +
              ", creditCard=" + creditCard +
              '}';
   }
}
