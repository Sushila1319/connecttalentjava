package com.connecttalent.connecttalentsession.user.dao.impl;

import com.connecttalent.connecttalentsession.user.dao.UserDao;
import com.connecttalent.connecttalentsession.user.model.Role;
import com.connecttalent.connecttalentsession.user.model.User;
import com.connecttalent.connecttalentsession.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    private final UserRepository userRepository;

    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);

    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
    }



    @Override
    public User update(Long id, User updatedUser) {
        User existingUser = findById(id);
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        return this.userRepository.save(existingUser);
    }

    @Override
    public void deleteById(Long id) {
        User existingUser = findById(id);
        this.userRepository.delete(existingUser);
    }
}