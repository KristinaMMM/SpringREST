package com.example.SpringREST.service;

import com.example.SpringREST.model.User;
import com.example.SpringREST.repository.UserRepository;
import com.example.SpringREST.util.UserNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findOne(int id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(UserNotFoundException::new);
    }

    @Transactional
    public void save  (User user){
        userRepository.save(user);
    }
}
