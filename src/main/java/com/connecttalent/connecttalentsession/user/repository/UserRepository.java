package com.connecttalent.connecttalentsession.user.repository;

import com.connecttalent.connecttalentsession.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {

    User findByEmail(String email);

    User findByRefreshToken(String refreshToken);
}
