package com.Matrimony.ThePair.UserController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Matrimony.ThePair.Model.UserDetails;
// import com.Matrimony.ThePair.Service.UserService;
import com.Matrimony.ThePair.Service.UserServiceIMPL;

// import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping ("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserCon {

    @Autowired
    UserServiceIMPL service;

    @GetMapping("/index")
    public String index() {
        return "index";

    }

    @GetMapping("/Login")
    public String login() {
        return "Login";

    }

    // Authentication
    // @PostMapping("/Login")
    // public String login(@RequestParam String email, @RequestParam String password, Model model) {
    //     UserDetails user = service.getUserByEmail(email);
    //     if (user != null && user.getPassword().equals(password)) {

    //         return "index";
    //     } else {
    //         model.addAttribute("error", "Invalid email or password. Please try again.");
    //         return "Login";
    //     }
    // }


    @GetMapping("/Contact")
    public String contact() {
        return "Contact";

    }

    @GetMapping("/About")
    public String about() {
        return "About";

    }

    // @GetMapping("/Register")
    // public String register() {
    //     return "Register";

    // }

    // create opertion
    // @PostMapping("/Register")
    // public String registertologin(@ModelAttribute UserDetails a) {
    //     service.addUser(a);
    //     System.out.println("User is added!");
    //     return "Login";
    // }

    // Delete operation
    // @GetMapping("/deleteUser/{id}")
    // public String deleteUser(@PathVariable int id) {
    //     service.deleteUser(id);
    //     System.out.println("User is deleted!");
    //     return "redirect:/index"; 
    // }



    // Select particilar data
    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable int id, Model model) {
        UserDetails users = service.getUserById(id);
        System.out.println("User data:");
        System.out.println(users);
        return "index";

    }


    // Select Operation (alldata selected)
    // @GetMapping("/allUsers")
    // public String showAllUsers(Model model) {
    //     List<UserDetails> allUsers = service.getAllUsers();
    //     model.addAttribute("users", allUsers);
    //     System.out.println("All Data is readable");
    //     return "allUsersView"; 
    
    // }

    // // Update Operation
    // @GetMapping("/updatepassword")
    // public String logintoupdate() {
    //     return "updatepassword";

    // }

    // @PostMapping("/updatepassword")
    // public String updatePassword(@ModelAttribute UserDetails user, Model model) {
    //     // Retrieve the user by email
    //     UserDetails existingUser = service.getUserByEmail(user.getEmail());

    //     if (existingUser != null) {
    //         // Check if the old password matches the user's current password
    //         if (existingUser.getPassword().equals(user.getOldPassword())) {
    //             // Update the password
    //             existingUser.setPassword(user.getPassword());
    //             service.updateUser(existingUser);
    //             model.addAttribute("message", "Password updated successfully");
    //         } else {
    //             model.addAttribute("message", "Old password is incorrect");
    //         }
    //     } else {
    //         model.addAttribute("message", "User not found with the provided email");
    //     }
    //     System.out.println("Passward is updated");
    //     return "updatepasswordresult";
    // }
   
    @PostMapping("/submit")
    public String submitForm() {
        return "redirect:/login";
    }

//selction operation for angular view
    @GetMapping("/allUsers")
    @ResponseBody
    public List<UserDetails> showAllUsers() {
        return service.getAllUsers();
    }

// Insertion operation for angular view
   @PostMapping("/register")
   public UserDetails registertologin(@RequestBody UserDetails user) {
        service.addUser(user);
        System.out.println("User is added!");
        return user;}     // return the added user as json

  // Delete operation for angular
    // @GetMapping("/deleteUser/{id}")
    // public String deleteUser(@PathVariable int id) {
    //     service.deleteUser(id);
    //     System.out.println("User is deleted!");
    //     return "redirect:/index"; 
    // }

    @DeleteMapping("/register/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id) {
        UserDetails user = (UserDetails) service.getUserById(id);
        //   .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        service.deleteUser(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

// Update operation for angular view
   @PutMapping("/register/{id}")
	public ResponseEntity<UserDetails> updateEmployee(@PathVariable int id, @RequestBody UserDetails userDetails){
		UserDetails user = service.getUserById(id);
				// .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		user.setFullname(userDetails.getFullname());
		user.setGender(userDetails.getGender());
		user.setEmail(userDetails.getEmail());
		user.setContact(userDetails.getContact());
        user.setPassword(userDetails.getPassword());
		UserDetails updatedUser = service.save(user);
		return ResponseEntity.ok(updatedUser);
	}

    @GetMapping("/register/{id}")
	public ResponseEntity<UserDetails> getEmployeeById(@PathVariable int id) {
		UserDetails user = service.getUserById(id);
				// .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(user);
	}

    // Authentication for angular view
    //   @PostMapping("/Login")
    // public String login(@RequestParam String email, @RequestParam String password, Model model) {
    //     UserDetails user = service.getUserByEmail(email);
    //     if (user != null && user.getPassword().equals(password)) {

    //         return "index";
    //     } else {
    //         model.addAttribute("error", "Invalid email or password. Please try again.");
    //         return "Login";
    //     }
    // }

    

}
