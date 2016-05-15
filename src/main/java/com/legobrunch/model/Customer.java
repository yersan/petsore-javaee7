package com.legobrunch.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="customers")
@NamedQueries({
         @NamedQuery(name = Customer.FIND_BY_LOGIN, query = "SELECT c FROM Customer c WHERE c.login = :login"),
         @NamedQuery(name = Customer.FIND_BY_EMAIL, query = "SELECT c FROM Customer c WHERE c.email = :email"),
         @NamedQuery(name = Customer.FIND_BY_LOGIN_PASSWORD, query = "SELECT c FROM Customer c WHERE c.login = :login AND c.password = :password"),
         @NamedQuery(name = Customer.FIND_BY_UUID, query = "SELECT c FROM Customer c WHERE c.uuid = :uuid"),
         @NamedQuery(name = Customer.FIND_ALL, query = "SELECT c FROM Customer c")
})
public class Customer extends BaseEntity
{
   public static final String FIND_BY_LOGIN = "Customer.findByLogin";
   public static final String FIND_BY_LOGIN_PASSWORD = "Customer.findByLoginAndPassword";
   public static final String FIND_ALL = "Customer.findAll";
   public static final String FIND_BY_EMAIL = "Customer.findByEmail";
   public static final String FIND_BY_UUID = "Customer.findByUUID";


   @Column(length = 50, name = "first_name", nullable = false)
   @NotNull
   @Size(min = 2, max = 50)
   private String firstName;

   @Column(length = 50, name = "last_name", nullable = false)
   @NotNull
   @Size(min = 2, max = 50)
   private String lastName;

   private String telephone;

   private String email;

   @Column(length = 10, nullable = false)
   private String login;

   @Column(length = 256, nullable = false)
   @NotNull
   @Size(min = 1, max = 256)
   private String password;

   @Column(length = 256)
   @Size(min = 1, max = 256)
   private String uuid;

   @Column(name = "date_of_birth")
   @Temporal(TemporalType.DATE)
   private Date dateOfBirth;

   @Embedded
   private Address homeAddress = new Address();


   public Customer(){}

   public Customer(String firstName, String lastName, String login, String plainTextPassword, String email,
            Address address)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.login = login;
      this.password = plainTextPassword;
      this.email = email;
      this.homeAddress = address;
      this.dateOfBirth = new Date();
   }


   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getTelephone() {
      return telephone;
   }

   public void setTelephone(String telephone) {
      this.telephone = telephone;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getLogin() {
      return login;
   }

   public void setLogin(String login) {
      this.login = login;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getUuid() {
      return uuid;
   }

   public void setUuid(String uuid) {
      this.uuid = uuid;
   }

   public Date getDateOfBirth() {
      return dateOfBirth;
   }

   public void setDateOfBirth(Date dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
   }

   public Address getHomeAddress() {
      return homeAddress;
   }

   public void setHomeAddress(Address homeAddress) {
      this.homeAddress = homeAddress;
   }

   @Override
   public String toString() {
      return "Customer{" +
              "firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", telephone='" + telephone + '\'' +
              ", email='" + email + '\'' +
              ", login='" + login + '\'' +
              ", password='" + password + '\'' +
              ", uuid='" + uuid + '\'' +
              ", dateOfBirth=" + dateOfBirth +
              ", homeAddress=" + homeAddress +
              '}';
   }
}
