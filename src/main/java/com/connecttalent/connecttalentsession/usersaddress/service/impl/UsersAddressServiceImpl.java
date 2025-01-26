package com.connecttalent.connecttalentsession.usersaddress.service.impl;

import com.connecttalent.connecttalentsession.usersaddress.dao.UsersAddressDao;
import com.connecttalent.connecttalentsession.usersaddress.model.UsersAddress;
import com.connecttalent.connecttalentsession.usersaddress.service.UsersAddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersAddressServiceImpl implements UsersAddressService {
    private final UsersAddressDao usersAddressDao;

    public UsersAddressServiceImpl(UsersAddressDao usersAddressDao){
        this.usersAddressDao = usersAddressDao;
    }

    @Override
    public UsersAddress save(UsersAddress usersAddress) {
        return this.usersAddressDao.save(usersAddress);
    }

    public List<UsersAddress> getAll() {
        return this.usersAddressDao.getAll();
    }

    @Override
    public UsersAddress findById(long id) {
        return this.usersAddressDao.findById(id);
    }

    @Override
    public UsersAddress update(long id, UsersAddress updatedUserAddress) {
        return this.usersAddressDao.update(id, updatedUserAddress);
    }

    @Override
    public void deleteById(Long id) {
        this.usersAddressDao.deleteById(id);
    }


}

