package com.connecttalent.connecttalentsession.user.dao;

import com.connecttalent.connecttalentsession.user.model.User;

import java.util.List;

public interface UserDao {
    User save(User user);

    List<User>getAll();

    User findById(long id);

    User update(Long id, User updatedUser);

    void deleteById(Long id);


}
