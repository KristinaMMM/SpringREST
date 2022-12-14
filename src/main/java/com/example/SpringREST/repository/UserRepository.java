package com.example.SpringREST.repository;

import com.example.SpringREST.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
