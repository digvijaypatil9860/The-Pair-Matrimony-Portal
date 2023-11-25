package com.Matrimony.ThePair.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Matrimony.ThePair.Model.UserDetails;


public interface UserRepo extends JpaRepository < UserDetails ,Integer> {

    public UserDetails findByEmail(String email);

  

   
    
}
