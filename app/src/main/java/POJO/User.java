package POJO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HeshamMuhammed on 5  ggggggggggggggggggg/21/2018.
 */

public class User implements Serializable{

   private Integer personId;
   private String image;
   private String first;
   private String last;
   private String password;
   private String email;
   private String type;
   private String gender;
   private Boolean enabled;
   private String username;
   private Object lastPasswordResetDate;
   private List<Authority> authorities = null;
   private CustomerService customerService;
   private TaaUser taaUser;

   public Integer getPersonId() {
      return personId;
   }

   public void setPersonId(Integer personId) {
      this.personId = personId;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public String getFirst() {
      return first;
   }

   public void setFirst(String first) {
      this.first = first;
   }

   public String getLast() {
      return last;
   }

   public void setLast(String last) {
      this.last = last;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public Boolean getEnabled() {
      return enabled;
   }

   public void setEnabled(Boolean enabled) {
      this.enabled = enabled;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public Object getLastPasswordResetDate() {
      return lastPasswordResetDate;
   }

   public void setLastPasswordResetDate(Object lastPasswordResetDate) {
      this.lastPasswordResetDate = lastPasswordResetDate;
   }

   public List<Authority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(List<Authority> authorities) {
      this.authorities = authorities;
   }

   public TaaUser getTaaUser() {
      return taaUser;
   }

   public void setTaaUser(TaaUser taaUser) {
      this.taaUser = taaUser;
   }

   public CustomerService getCustomerService() {
      return customerService;
   }

   public void setCustomerService(CustomerService customerService) {
      this.customerService = customerService;
   }
}