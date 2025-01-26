package com.connecttalent.connecttalentsession.user.controller;

import com.connecttalent.connecttalentsession.user.model.User;
import com.connecttalent.connecttalentsession.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //   @Autowired
//    private UserService userService;

    //response
    @PostMapping("save")
    public ResponseEntity<User> save(@RequestBody User user) {
        user = this.userService.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("list")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(this.userService.getAll());
    }

    @GetMapping("find/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.userService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "User not found with id " + id));
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User updatedUser) {
        try {
            return ResponseEntity.ok(this.userService.update(id, updatedUser));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Unable to update user with id " + id));
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            this.userService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Unable to delete user with id " + id));
        }
    }

}