package com.cristianperez.revolutionstore.repository;


import com.cristianperez.revolutionstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
