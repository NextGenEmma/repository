package com.example.nextgen.servicestest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.nextgen.model.User;
import com.example.nextgen.repository.UserRepository;
import com.example.nextgen.services.UserServices;

@SpringBootTest
public class UserServicesTest {
	
	
	    @MockBean
	    private UserRepository userRepository;

	    private UserServices userServices;

	    @BeforeEach
	    public void setUp() {
	        userServices = new UserServices(userRepository);
	    }

	    @Test
	    public void testInsertUser() {
	        User user = new User();
	        user.setUsername("testUser");
	        user.setPassword("testPassword");

	        userServices.insertUser(user);

	        // Verify that userRepository.save() was called with the correct user
	        verify(userRepository, times(1)).save(user);
	    }

	    @Test
	    public void testGetUserByUsername() {
	        String username = "testUser";
	        User expectedUser = new User();
	        expectedUser.setUsername(username);
	        expectedUser.setPassword("testPassword");

	        // Mocking the behavior of userRepository.getUserByUsername()
	        when(userRepository.getUserByUsername(username)).thenReturn(expectedUser);

	        User actualUser = userServices.gerUserByUsername(username);

	        // Verify that the returned user matches the expected user
	        assertEquals(expectedUser, actualUser);
	    }


}
