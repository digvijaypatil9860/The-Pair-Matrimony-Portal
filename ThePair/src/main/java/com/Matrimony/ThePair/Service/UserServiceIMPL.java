package com.Matrimony.ThePair.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Matrimony.ThePair.Model.UserDetails;
import com.Matrimony.ThePair.Repository.UserRepo;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    UserRepo obj;

    @Override
    public UserDetails addUser(UserDetails user) {
        return obj.save(user);

    }

    @Override
    public UserDetails deleteUser(UserDetails user) {
        obj.deleteById(user.getId()); // Assuming UserDetails has a getId method
        return user;
    }
    @Override
    public UserDetails getUserById(int id) {
      return obj.findById(id).orElse(null);
    }

    @Override
    public List<UserDetails> getAllUsers() {
     return obj.findAll();
    }

    @Override
    public UserDetails save(UserDetails user) {
        return obj.save(user);
    }

    // @Override
    // public void updateUser(UserDetails user) {
    //      UserDetails existingUser = obj.findByEmail(user.getEmail());
    //     if (existingUser != null) {
    //         existingUser.setPassword(user.getPassword());
    //         obj.save(existingUser);
    //     }
    // }

    @Override
    public UserDetails updateUser(UserDetails user) {
        UserDetails existingUser = obj.findByEmail(user.getEmail());
        
        if (existingUser != null) {
         
            existingUser.setFullname(user.getFullname());
            existingUser.setGender(user.getGender());
            existingUser.setEmail(user.getEmail());
            existingUser.setContact(user.getContact());
            existingUser.setPassword(user.getPassword());
    
            // Update other fields as needed
    
            return obj.save(existingUser);
        }
        
        return null; // Or throw an exception if required
    }



    @Override
    public UserDetails getUserByEmail(String email) {
      return obj.findByEmail(email);
    }

  }
    
