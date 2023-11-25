package com.Matrimony.ThePair.Service;

import java.util.List;

// import org.apache.catalina.User;

import com.Matrimony.ThePair.Model.UserDetails;

public interface UserService {

    // for create
    public UserDetails addUser(UserDetails user);

    // for delete
    public UserDetails deleteUser(UserDetails user);

    // for select particular data
    public UserDetails getUserById(int id);

    // for select all data
    List<UserDetails> getAllUsers();

    // for updte
//  public void updateUser(UserDetails user);
    UserDetails updateUser(UserDetails user);
    UserDetails save(UserDetails user);

    //taking that email string
    public UserDetails getUserByEmail(String email);

}
