package com.connecttalent.connecttalentsession.usersaddress.dao;

import com.connecttalent.connecttalentsession.usersaddress.model.UsersAddress;

import java.util.List;

public interface UsersAddressDao {

    UsersAddress save(UsersAddress usersAddress);

    List<UsersAddress> getAll();

    UsersAddress findById(long id);

    UsersAddress update(Long id, UsersAddress updatedUserAddress);

    void deleteById(Long id);

}
