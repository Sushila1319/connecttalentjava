package com.connecttalent.connecttalentsession.auth.service;

import com.connecttalent.connecttalentsession.auth.model.LoginRequestDto;
import com.connecttalent.connecttalentsession.auth.model.LoginResponseDto;
import com.connecttalent.connecttalentsession.auth.model.RefreshTokenRequestDto;
import com.connecttalent.connecttalentsession.auth.model.RegisterResponseDto;
import com.connecttalent.connecttalentsession.user.model.User;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto loginRequestDto);

    LoginResponseDto refreshToken(RefreshTokenRequestDto refreshTokenRequestDto);

    RegisterResponseDto register(User user);
}
