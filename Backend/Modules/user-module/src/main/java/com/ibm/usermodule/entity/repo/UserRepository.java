package com.ibm.usermodule.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.usermodule.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    User findByEmailAndPassword(String email, String password);

}
