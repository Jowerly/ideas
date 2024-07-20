package com.joseflores.examen.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseflores.examen.models.User;
import com.joseflores.examen.repositorys.UserRepository;

@Service
public class UserService {
    @Autowired
        private UserRepository userRepository;

    public List<User> findall(){
        return (List<User>) userRepository.findAll();
    }
    // public boolean existsByUsername(String username) {
    //     return userRepository.findUserEntityByUsername(username).isPresent();
    // }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    public boolean authenticateUser(String email, String password) {
        // primero encontrar el usuario por su email
        User user = userRepository.findByEmail(email);
        // si no lo podemos encontrar por su email, retornamos false
        if(user == null) {
            return false;
        } else {
            // si el password coincide devolvemos true, sino, devolvemos false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}