package com.connecttalent.connecttalentsession.usersaddress.controller;


import com.connecttalent.connecttalentsession.usersaddress.model.UsersAddress;
import com.connecttalent.connecttalentsession.usersaddress.service.UsersAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@RequiredArgsConstructor
@RestController
@RequestMapping("user-address")

public class UsersAddressController {

    private final UsersAddressService usersAddressService;

    public UsersAddressController(UsersAddressService usersAddressService) {
      this.usersAddressService = usersAddressService;
  }

  //  @Autowired
  //  private UserService userService;

    @PostMapping("save")
    public ResponseEntity<UsersAddress> save(@RequestBody UsersAddress usersAddress){
    usersAddress = this.usersAddressService.save(usersAddress);
        return ResponseEntity.ok(usersAddress);
    }

    @GetMapping("list")
    public ResponseEntity<List<UsersAddress>> getAll(){
        return ResponseEntity.ok(this.usersAddressService.getAll());
    }

    @GetMapping("find/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        try{
            return ResponseEntity.ok(this.usersAddressService.findById(id));
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("User not found with id " + id);
        }
    }


    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable long id,@RequestBody UsersAddress updatedUserAddress) {
        try {
            return ResponseEntity.ok(this.usersAddressService.update(id, updatedUserAddress));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "unable to update user with id " + id));
        }

    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        try {
            this.usersAddressService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error","unable to delete user with id " + id));       }

    }
}

