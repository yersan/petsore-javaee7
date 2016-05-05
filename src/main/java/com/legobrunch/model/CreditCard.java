package com.legobrunch.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Embeddable
public class CreditCard implements Serializable
{

   @Column(length = 30, name = "credit_card_number", nullable = false)
   @NotNull
   @Size(min = 1, max = 30)
   private String creditCardNumber;

   @Enumerated
   @Column(name = "credit_card_type")
   @NotNull
   private CreditCardType creditCardType;

   @Column(length = 5, name = "credit_card_expiry_date", nullable = false)
   @NotNull
   @Size(min = 1, max = 5)
   private String creditCardExpDate;


   public CreditCard(){}

   public CreditCard(String creditCardNumber, CreditCardType creditCardType, String creditCardExpDate)
   {
      this.creditCardNumber = creditCardNumber;
      this.creditCardType = creditCardType;
      this.creditCardExpDate = creditCardExpDate;
   }

   public String getCreditCardNumber() {
      return creditCardNumber;
   }

   public void setCreditCardNumber(String creditCardNumber) {
      this.creditCardNumber = creditCardNumber;
   }

   public CreditCardType getCreditCardType() {
      return creditCardType;
   }

   public void setCreditCardType(CreditCardType creditCardType) {
      this.creditCardType = creditCardType;
   }

   public String getCreditCardExpDate() {
      return creditCardExpDate;
   }

   public void setCreditCardExpDate(String creditCardExpDate) {
      this.creditCardExpDate = creditCardExpDate;
   }
}
