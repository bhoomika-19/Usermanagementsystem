package com.cg.usermanagement;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.cg.bookstore.BookstoreApplication;
import com.cg.bookstore.entity.UserData;
import com.cg.bookstore.repository.UserManagementRepository;
import com.cg.bookstore.service.UserManagementService;
import com.cg.bookstore.service.UserManagementServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(classes = BookstoreApplication.class)

public class BookstoreApplicationTests {

	@Mock
	private UserManagementRepository umr;

	@InjectMocks
	UserManagementServiceImpl service;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreateUser() {
		UserData u = new UserData();
		u.setUserid(11);
		u.setEmail("bhoomika12@gmail.com");
		u.setFirstName("bhoomika");
		u.setPassword("bhoomi26");	
		service.createUser(u);
		Mockito.verify(umr,Mockito.times(1)).save(u);		
	}
	
	@Test
	public void testfindById() {
		UserData ud=new UserData(12,"bhoomi@gmail.com","bhoomika","bhoomi26");
		when(umr.findById(12)).thenReturn(Optional.of(ud));
	}
		
		
	}


