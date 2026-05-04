package com.cristianperez.revolutionstore.service;

import com.cristianperez.revolutionstore.entity.User;
import com.cristianperez.revolutionstore.exception.ResourceNotFoundException;
import com.cristianperez.revolutionstore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User getByCode(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with ID not found: " + id ));
    }

    @Override
    public User create(User user) {
        user.setCodeUser(null);
        return null;
    }

    @Override
    public User update(Integer id, User user) {
        User existing = getByCode(id);
        existing.setUsername(user.getUsername());
        existing.setPassword(user.getPassword());
        existing.setEmail(user.getEmail());
        existing.setUserRole(user.getUserRole());
        return userRepository.save(existing);
    }

    @Override
    public void eliminate(Integer id) {
        if (!userRepository.existsById(id)){
            throw new ResourceNotFoundException("user with ID not found: " + id);
        }
        userRepository.deleteById(id);

    }

    @Override
    public void save(User user) {

        userRepository.save(user);
    }
    }

