package com.cristianperez.revolutionstore.service;


import com.cristianperez.revolutionstore.entity.User;

import java.util.List;

public interface UserService {
    List<User> list();
    User getByCode(Integer id);
    User create(User user);
    User update(Integer id, User user);
    void eliminate(Integer id);
    void save(User user);
}
