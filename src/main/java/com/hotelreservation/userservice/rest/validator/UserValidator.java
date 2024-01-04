package com.hotelreservation.userservice.rest.validator;


import com.hotelreservation.userservice.api.request.UserAddRequest;
import com.hotelreservation.userservice.repository.BalanceRepository;
import com.hotelreservation.userservice.repository.UserRepository;
import com.hotelreservation.userservice.rest.exception.AuthException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.hotelreservation.userservice.lib.constants.Constants;

@Component
@RequiredArgsConstructor
@Slf4j

public class UserValidator {
    private final UserRepository userRepository;

    private final BalanceRepository balanceRepository;

    public void validateUserRegister(UserAddRequest userAddRequest) throws AuthException{
        if (userRepository.findByEmail(userAddRequest.getUsername()) != null) {
            throw new AuthException(Constants.EMAIL_IN_USE);
        } else if (userRepository.findByUsername(userAddRequest.getUsername()) != null) {
            throw new AuthException(Constants.USERNAME_IN_USE);
        }
    }
}