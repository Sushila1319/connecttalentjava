package com.connecttalent.connecttalentsession.user.service;

import com.connecttalent.connecttalentsession.user.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getAll();

    User findById(Long id);

    User update(Long id, User updatedUser);

    void deleteById(Long id);

}
