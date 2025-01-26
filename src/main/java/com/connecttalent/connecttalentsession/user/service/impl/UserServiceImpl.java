package com.connecttalent.connecttalentsession.user.service.impl;

import com.connecttalent.connecttalentsession.user.dao.UserDao;
import com.connecttalent.connecttalentsession.user.model.User;
import com.connecttalent.connecttalentsession.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public User save(User user) {
        return this.userDao.save(user);
    }

    @Override
    public List<User> getAll() {
        return this.userDao.getAll();
    }

    @Override
    public User findById(Long id) {
        return this.userDao.findById(id);
    }


    @Override
    public User update(Long id, User updatedUser){
        return this.userDao.update(id,updatedUser);
    }

    @Override
    public void deleteById(Long id) {
        this.userDao.deleteById(id);
    }


}

