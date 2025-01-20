package com.example.hw5.user.controller;

import com.example.hw5.user.dto.UserRequest;
import com.example.hw5.user.dto.UserResponse;
import com.example.hw5.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResponse.ReadUser getUser(@PathVariable Long userId){
        return userService.readUser(userId);
    }
    @PostMapping("")
    public void createUser(@RequestBody UserRequest.UserCreateRequest req){
        userService.createUser(req);
    }

    @PatchMapping("/{userId}")
    public UserResponse.ReadUser update(@PathVariable Long userId, @RequestBody UserRequest.UserCreateRequest req){
        return userService.updateUser(userId, req);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
