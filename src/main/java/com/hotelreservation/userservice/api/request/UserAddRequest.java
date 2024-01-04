package com.hotelreservation.userservice.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddRequest {
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;
}
