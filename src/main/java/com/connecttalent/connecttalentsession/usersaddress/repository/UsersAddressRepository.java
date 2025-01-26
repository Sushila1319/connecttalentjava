package com.connecttalent.connecttalentsession.usersaddress.repository;

import com.connecttalent.connecttalentsession.usersaddress.model.UsersAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersAddressRepository extends JpaRepository<UsersAddress, Long > {

}
