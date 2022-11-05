package com.example.productcategoryservice.service;

import com.example.productcategoryservice.transfer.request.UserAuthRequest;
import com.example.productcategoryservice.transfer.request.UserRegistrationRequest;
import com.example.productcategoryservice.transfer.response.UserAuthResponse;
import com.example.productcategoryservice.transfer.response.UserRegistrationResponse;

public interface AuthService {
    /**
     * generate token
     * @param userAuthRequest username("email") and password
     * @return AuthResponse
     */
    UserAuthResponse auth(final UserAuthRequest userAuthRequest);

    /**
     * create new user
     * @param userRegistrationRequest
     * @return UserRegistrationResponse
     */
    UserRegistrationResponse registration(final UserRegistrationRequest userRegistrationRequest);
}
