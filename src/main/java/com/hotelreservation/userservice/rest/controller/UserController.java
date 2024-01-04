package com.hotelreservation.userservice.rest.controller;


import com.hotelreservation.userservice.api.request.AuthUserRequest;
import com.hotelreservation.userservice.api.request.UserAddRequest;
import com.hotelreservation.userservice.api.response.AuthUserResponse;
import com.hotelreservation.userservice.api.response.BaseResponse;
import com.hotelreservation.userservice.rest.service.UserServiceImp;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserServiceImp userServiceImp;

    @PostMapping(path = "/login")
    public ResponseEntity<AuthUserResponse> authUser(
            @NonNull @RequestBody AuthUserRequest request) {
        return ResponseEntity.ok(userServiceImp.authUser(request));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<BaseResponse> registerUser(
            @RequestBody UserAddRequest request) {
        return ResponseEntity.ok(userServiceImp.createUser(request));
    }
}
