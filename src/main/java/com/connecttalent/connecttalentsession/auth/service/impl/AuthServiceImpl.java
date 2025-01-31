package com.connecttalent.connecttalentsession.auth.service.impl;

import com.connecttalent.connecttalentsession.auth.model.RegisterResponseDto;
import com.connecttalent.connecttalentsession.auth.service.AuthService;
import com.connecttalent.connecttalentsession.user.model.User;
import com.connecttalent.connecttalentsession.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public RegisterResponseDto register(User user) {
        User userIfExistsByEmail = userRepository.findByEmail(user.getEmail());
        if(userIfExistsByEmail != null){
            throw new RuntimeException("Email already exists");
        }
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        try{
            this.userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException("Unable to register please try again later");
        }
        return new RegisterResponseDto("successfully registered");
    }
}
