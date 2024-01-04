package com.hotelreservation.userservice.rest.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.hotelreservation.userservice.api.request.AuthUserRequest;
import com.hotelreservation.userservice.api.request.UserAddRequest;
import com.hotelreservation.userservice.api.response.AuthUserResponse;
import com.hotelreservation.userservice.api.response.BaseResponse;
import com.hotelreservation.userservice.model.Role;
import com.hotelreservation.userservice.model.entity.User;
import com.hotelreservation.userservice.repository.UserRepository;
import com.hotelreservation.userservice.rest.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp implements IUserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final RestTemplate restTemplate;

    private Class<? extends ResponseEntity<java.lang.String>> String;

    @Override
    public BaseResponse createUser(UserAddRequest request) {
        User user = modelMapper.map(request, User.class);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (request.getUsername().equals("Pfand") && request.getFirstName().equals("Ataberk") && request.getLastName().equals("Bakir")) {
            user.setRole(Role.MANAGER);
        } else {
            user.setRole(Role.USER);
        }
        this.userRepository.save(user);

        return new BaseResponse();
    }
    //THIS IS REAL ONE
    /*@Override
    public AuthUserResponse authUser(AuthUserRequest request) {
        User user = userRepository.findByUsername(request.getUsername());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        ResponseEntity<AuthUserResponse> responseEntity = restTemplate.getForEntity("http://localhost:8082/jwt/generateToken/" + user.getId() , AuthUserResponse.class);

        String localToken = responseEntity.getBody().getToken();

        return AuthUserResponse.builder()
                .token(localToken)
                .build();
    }*/

    //TESTING PASSING OBJECT TO AUTHSERVICE  // test successfully
    @Override
    public AuthUserResponse authUser(AuthUserRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
//        ResponseEntity<AuthUserResponse> responseEntity = restTemplate.getForEntity("http://localhost:8082/jwt/generateToken/" + user.getId() , AuthUserResponse.class);

        AuthUserResponse response = restTemplate.postForObject("http://localhost:8082/jwt/generateToken",request,AuthUserResponse.class);

        String localToken = response.getToken();

        return AuthUserResponse.builder()
                .token(localToken)
                .build();
    }
}