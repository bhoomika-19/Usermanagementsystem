package com.cg.bookstore.service;

import java.util.List;
import java.util.Optional;
import com.cg.bookstore.entity.UserData;

public interface UserManagementService {

	 UserData createUser(UserData user);
	
Optional<UserData> viewUserDataById(int userId);
	 
	 List<UserData> viewUserData();
	 String deleteUserById(int userId);
}
