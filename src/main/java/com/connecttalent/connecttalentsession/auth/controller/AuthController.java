    package com.connecttalent.connecttalentsession.auth.controller;


    import com.connecttalent.connecttalentsession.auth.model.LoginRequestDto;
    import com.connecttalent.connecttalentsession.auth.model.LoginResponseDto;
    import com.connecttalent.connecttalentsession.auth.model.RefreshTokenRequestDto;
    import com.connecttalent.connecttalentsession.auth.service.AuthService;
    import com.connecttalent.connecttalentsession.user.model.User;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.Map;

    @RestController
    @RequestMapping("auth")

    public class AuthController {

        private final AuthService authService;

        public AuthController(AuthService authService) {
            this.authService = authService;
        }

        @PostMapping("login")
        public ResponseEntity<?>login(@RequestBody LoginRequestDto loginRequestDto){
            LoginResponseDto loginResponseDto = this.authService.login(loginRequestDto);
            if(loginResponseDto == null){
                return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.ok(loginResponseDto);
        }



        @PostMapping("register")
        public ResponseEntity<?> register(@RequestBody User user) {
            try {
                return ResponseEntity.ok(this.authService.register(user));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
            }
        }


        @PostMapping("refresh")
        public ResponseEntity<?>refreshToken(@RequestBody RefreshTokenRequestDto refreshTokenRequestDto){
            LoginResponseDto loginResponseDto = this.authService.refreshToken(refreshTokenRequestDto);
            if(loginResponseDto == null){
                return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return ResponseEntity.ok(loginResponseDto);
        }

    }
