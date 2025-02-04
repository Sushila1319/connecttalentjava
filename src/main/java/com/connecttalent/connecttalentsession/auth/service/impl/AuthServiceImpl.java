package com.connecttalent.connecttalentsession.auth.service.impl;

import com.connecttalent.connecttalentsession.auth.model.LoginRequestDto;
import com.connecttalent.connecttalentsession.auth.model.LoginResponseDto;
import com.connecttalent.connecttalentsession.auth.model.RefreshTokenRequestDto;
import com.connecttalent.connecttalentsession.auth.model.RegisterResponseDto;
import com.connecttalent.connecttalentsession.auth.service.AuthService;
import com.connecttalent.connecttalentsession.constant.AuthConstant;
import com.connecttalent.connecttalentsession.springsecurity.UserDetailsImpl;
import com.connecttalent.connecttalentsession.user.model.User;
import com.connecttalent.connecttalentsession.user.repository.UserRepository;
import com.connecttalent.connecttalentsession.utils.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail());
        if (user != null) {
            boolean matchPassword = passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword());
            if (matchPassword) {
                LoginResponseDto loginResponseDto = new LoginResponseDto();
                UserDetailsImpl userDetails = new UserDetailsImpl(user);
                String accessToken = this.jwtUtil.generateToken(userDetails);
                String refreshToken = this.jwtUtil.generateRefreshToken(user.getEmail());
                loginResponseDto.setAccessToken(accessToken);
                loginResponseDto.setRefreshToken(refreshToken);
                loginResponseDto.setExpiresIn(AuthConstant.expiration);
                user.setRefreshToken(refreshToken);
                this.userRepository.save(user);
                return loginResponseDto;
            }
        }
        return null;
    }

    @Override
    public LoginResponseDto refreshToken(RefreshTokenRequestDto refreshTokenRequestDto) {
        User user = this.userRepository.findByRefreshToken(refreshTokenRequestDto.getRefreshToken());
        if (user != null){
            UserDetailsImpl userDetails = new UserDetailsImpl(user);
            boolean validToken = jwtUtil.validateToken(refreshTokenRequestDto.getRefreshToken(), userDetails);
            if(validToken){
                String newAccessToken = jwtUtil.generateToken(userDetails);
                LoginResponseDto loginResponseDto = new LoginResponseDto();
                loginResponseDto.setAccessToken(newAccessToken);
                loginResponseDto.setExpiresIn(AuthConstant.expiration);
                loginResponseDto.setRefreshToken(refreshTokenRequestDto.getRefreshToken());
                return loginResponseDto;
            }
        }
        return null;
    }

    @Override
    public RegisterResponseDto register(User user) {
        User userIfExistsByEmail = userRepository.findByEmail(user.getEmail());
        if (userIfExistsByEmail != null) {
            throw new RuntimeException("Email already exists");
        }
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        try {
            this.userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Unable to register. Please try again later");
        }
        return new RegisterResponseDto("successfully registered");
    }
}