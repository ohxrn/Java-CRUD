package com.exam.main.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.exam.main.models.LoginUser;
import com.exam.main.models.User;
import com.exam.main.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
    @Autowired
    private UserRepository userRepo;
    
    public User register(User newUser, BindingResult result) {
        
    	Optional<User> userLookUp = userRepo.findByEmail(newUser.getEmail());
    	if (userLookUp.isPresent()) {
    		result.rejectValue("email", "Unique", "Account with this email already exists.");
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}

    	if(result.hasErrors()) {
    		return null;
    	}

    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	
    	newUser = repo.save(newUser);
    	System.out.println("New user created with ID: " + newUser.getId());
    	
        return newUser;
    }
    
    public User login(LoginUser newLogin, BindingResult result) {
        
  
    	Optional<User> userLookUp = userRepo.findByEmail(newLogin.getEmail());
    	if (!userLookUp.isPresent()) {
    		result.rejectValue("email", "MissingAccount", "No account found.");
    		return null;
    	}
    	
    	User user = userLookUp.get();
        
     
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	

    	if(result.hasErrors()) {
    		return null;
    	}
 
        return user;
    }

	public User findByEmail(String email) {
		
		Optional<User> result = repo.findByEmail(email);
		if(result.isPresent()) {
			return result.get();
		}
		
		return null;
	}
	
	public User findById(Long id) {
		
		Optional<User> theResult = repo.findById(id);
		if(theResult.isPresent()) {
			return theResult.get();
		}
		
		return null;
	}
}