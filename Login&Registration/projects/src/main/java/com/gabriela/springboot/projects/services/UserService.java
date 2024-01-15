package com.gabriela.springboot.projects.services;

import com.gabriela.springboot.projects.models.LoginUser;
import com.gabriela.springboot.projects.models.User;
import com.gabriela.springboot.projects.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User register(User newUser, BindingResult result) {

    if (userRepo.findByEmail(newUser.getEmail()) == null) {
			result.rejectValue("email", "EmailTaken", "Email address is already in use.");  // another way of doing it?
		}

      /*  Optional<User> potentialUser = this.userRepo.findByEmail(newUser.getEmail());

        if (potentialUser.isPresent()) {
            result.rejectValue("email", "EmailTaken", "Email address is already in use.");
        }*/


        if (!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }

        if (result.hasErrors()) {
            return null;
        }

        else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }

    }

    public User login(LoginUser newLoginObject, BindingResult result) {

        Optional<User> potentialUser = this.userRepo.findByEmail(newLoginObject.getEmail());


        if (!potentialUser.isPresent()) {
            result.rejectValue("email", "EmailNotFound", "No user found with that Email address.");
        } else {

            if (!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
                // Reject if BCrypt password match fails
                result.rejectValue("password", "Matches", "Invalid Password!");
            }
        }

        if (result.hasErrors()) {

            return null;
        } else {

            return potentialUser.get();
        }
    }

    public User findOneUser(Long id) {
        return this.userRepo.findById(id).orElse(null);
    }


}