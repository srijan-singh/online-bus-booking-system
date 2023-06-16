/**
 * Module: User Module
 * Dependencies: Booking Module
 * Aim: To provide the service implementation for user
 * Author: Srijan Singh
 * Date: 07/06/2023
 */
package com.ibm.usermodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.usermodule.entity.User;

import java.util.List;

import com.ibm.usermodule.repo.UserRepository;

/**
 * Implementation for User Service
 */
@Repository
public class UserServiceImpl implements UserService {   

    /**
     * Autowired UserRepository
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Method to register a user
     * @param user
     */
    @Override
    public int register(User user) {
        userRepository.save(user);
        return user.getId();
    }

    /**
     * Method to login a user
     * @param email
     * @param password
     * @return
     */
    @Override
    public User login(String email, String password) {
        if (userRepository.findByEmailAndPassword(email, password) != null) {
            return userRepository.findByEmail(email);
        }
        return new User();
    }

    /**
     * Method to return a user
     * @param user
     * @return
     */
    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);        
    }

    /**
     * Method to get all users
     * @return List<User>
     */
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Method to update a user
     * @param userID
     * @return
     */
    @Override
    public boolean update(User userNew) {
        User userOld = userRepository.findById(userNew.getId()).orElse(null);
        if (userOld != null) {
            userOld.setName(userNew.getName());
            userOld.setEmail(userNew.getEmail());
            userOld.setPassword(userNew.getPassword());
            userRepository.save(userOld);
            return true;
        }
        return false;
    }

    /**
     * Method to delete a user by ID
     * @param userID
     * @return
     */
    @Override
    public boolean delete(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }
}
