package com.cg.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookstore.entity.UserData;
import com.cg.bookstore.repository.UserManagementRepository;

@Service

public class UserManagementServiceImpl  implements UserManagementService
{
	@Autowired
	UserManagementRepository umrepo;
	
	@Override
	public UserData createUser(UserData user) {
		
		return umrepo.save(user);
	}
	

	@Override
	public Optional<UserData> viewUserDataById(int userId) {
		
		return umrepo.findById(userId);
	}

	@Override
	public List<UserData> viewUserData() {
		
		return umrepo.findAll();
	}
	@Override
	public String deleteUserById(int userId) {
		umrepo.deleteById(userId);
		return "user details deleted successfully";	

	}
}


