package com.connecttalent.connecttalentsession.auth.service;

import com.connecttalent.connecttalentsession.auth.model.RegisterResponseDto;
import com.connecttalent.connecttalentsession.user.model.User;

public interface AuthService {

    RegisterResponseDto register(User user);
}
