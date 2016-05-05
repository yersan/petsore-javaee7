package com.legobrunch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="countries")
public class Country extends BaseEntity
{

   @Column(length = 2, name = "iso_code", nullable = false)
   @NotNull
   @Size(min = 2, max = 2)
   private String isoCode;

   @Column(length = 80, nullable = false)
   @NotNull
   @Size(min = 2, max = 80)
   private String name;

   @Column(length = 80, name = "printable_name", nullable = false)
   @NotNull
   @Size(min = 2, max = 80)
   private String printableName;

   @Column(length = 3)
   @NotNull
   @Size(min = 3, max = 3)
   private String iso3;

   @Column(length = 3)
   @NotNull
   @Size(min = 3, max = 3)
   private String numcode;

   public Country(){}

   public Country(String isoCode, String name, String printableName, String iso3, String numcode)
   {
      this.isoCode = isoCode;
      this.name = name;
      this.printableName = printableName;
      this.iso3 = iso3;
      this.numcode = numcode;
   }

   public String getIsoCode() {
      return isoCode;
   }

   public void setIsoCode(String isoCode) {
      this.isoCode = isoCode;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPrintableName() {
      return printableName;
   }

   public void setPrintableName(String printableName) {
      this.printableName = printableName;
   }

   public String getIso3() {
      return iso3;
   }

   public void setIso3(String iso3) {
      this.iso3 = iso3;
   }

   public String getNumcode() {
      return numcode;
   }

   public void setNumcode(String numcode) {
      this.numcode = numcode;
   }
}
