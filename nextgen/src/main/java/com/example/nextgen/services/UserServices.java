package com.example.nextgen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nextgen.model.User;
import com.example.nextgen.repository.UserRepository;
@Service
public class UserServices {
	@Autowired
	private UserRepository userRepository;
	

	 @Autowired
	    public UserServices(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	
	  public void insertUser(User user) {
	        userRepository.save(user);
	    }
	  
		public User gerUserByUsername(String username) {
			return userRepository.getUserByUsername(username);
			
		}
	
	

}
