package com.connecttalent.connecttalentsession.auth.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RefreshTokenRequestDto {
    private String refreshToken;
}
