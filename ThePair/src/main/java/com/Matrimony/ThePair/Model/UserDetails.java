package com.Matrimony.ThePair.Model;

// import org.hibernate.annotations.EmbeddableInstantiator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Groom")
public class UserDetails {
   
    @Id 
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String fullname;
    private String email;
    private String password;
    private String contact;
    private String gender;
    private String address;
    private String oldPassword;
    
    
 public UserDetails() {
    }



    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDetails [id=" + id + ", fullname=" + fullname + ", email=" + email + ", password=" + password
                + ", contact=" + contact + ", gender=" + gender + ", address=" + address + ", oldPassword="
                + oldPassword + "]";
    }



   
}
