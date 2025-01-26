package com.connecttalent.connecttalentsession.usersaddress.service;

import com.connecttalent.connecttalentsession.usersaddress.model.UsersAddress;

import java.util.List;

public interface UsersAddressService {
    UsersAddress save(UsersAddress usersAddress);

    List<UsersAddress> getAll();

    UsersAddress findById(long id);

    UsersAddress update(long id, UsersAddress updatedUserAddress);

    void deleteById(Long id);

}
