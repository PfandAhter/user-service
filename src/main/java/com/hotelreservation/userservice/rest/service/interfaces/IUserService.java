package com.hotelreservation.userservice.rest.service.interfaces;

import com.hotelreservation.userservice.api.request.AuthUserRequest;
import com.hotelreservation.userservice.api.request.UserAddRequest;
import com.hotelreservation.userservice.api.response.AuthUserResponse;
import com.hotelreservation.userservice.api.response.BaseResponse;

public interface IUserService {

    BaseResponse createUser (UserAddRequest request);

    AuthUserResponse authUser (AuthUserRequest request);

}
