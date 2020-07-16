package com.cg.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookstore.entity.UserData;
import com.cg.bookstore.exception.IdNotFoundException;
import com.cg.bookstore.service.UserManagementService;

@RestController
@RequestMapping("/UserManagement")
@CrossOrigin("http://localhost:4200")

public class UserManagementController
{
	@Autowired
	UserManagementService service;
	
	
	 @PostMapping(value="/createuser")
     public ResponseEntity<String> createUser(@RequestBody UserData user)
     {
    	 UserData  e= service.createUser(user);
    		
    			return new ResponseEntity<String>("User created successfully", new HttpHeaders(), HttpStatus.OK);
    		}	 
     
     @DeleteMapping("/deleteUser/{userId}")
     public String deleteUser(@PathVariable int userId)
     {
    	 service.deleteUserById(userId);
    	 return "User Details Deleted";
     }   
     @GetMapping(value="/getuserdetails/{userId}",produces="application/json")
	    public Optional<UserData> viewUserData(@PathVariable int userId)
	    {
    	
    	 Optional<UserData>  k= service.viewUserDataById( userId);
    	 if (k == null) {
 			throw new IdNotFoundException("Enter Valid Id");
 		} else {
 			return service.viewUserDataById(userId);
 		}	 
  }
   
		
		
		@GetMapping(value="/getalluserdetails",produces="application/json")
	    public List<UserData> viewUserData()
	    {
	   	 return service.viewUserData();
	    }
     

}
