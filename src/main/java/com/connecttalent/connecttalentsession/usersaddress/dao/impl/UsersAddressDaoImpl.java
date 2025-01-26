package com.connecttalent.connecttalentsession.usersaddress.dao.impl;

import com.connecttalent.connecttalentsession.usersaddress.dao.UsersAddressDao;
import com.connecttalent.connecttalentsession.usersaddress.model.UsersAddress;
import com.connecttalent.connecttalentsession.usersaddress.repository.UsersAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class UsersAddressDaoImpl implements UsersAddressDao {
   private final UsersAddressRepository usersAddressRepository;

    public UsersAddressDaoImpl(UsersAddressRepository usersAddressRepository) {
        this.usersAddressRepository = usersAddressRepository;
    }
    //@Autowired
   //private UserRepository userRepository;

    @Override
    public UsersAddress save(UsersAddress usersAddress){
        return this.usersAddressRepository.save(usersAddress);

    }

    public List<UsersAddress> getAll() {
        return this.usersAddressRepository.findAll();
    }

    @Override
    public UsersAddress findById(long id) {
        return this.usersAddressRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
    }

    @Override
    public UsersAddress update(Long id, UsersAddress updatedUserAddress) {
        UsersAddress existingUserAddress = findById(id);
        existingUserAddress.setCountry(updatedUserAddress.getCountry());
        existingUserAddress.setCity(updatedUserAddress.getCity());
        return this.usersAddressRepository.save(existingUserAddress);
    }

    @Override
    public void deleteById(Long id) {
        UsersAddress existingUserAddress = findById(id);
        this.usersAddressRepository.delete(existingUserAddress);
    }


}

