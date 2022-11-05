package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.entity.User;
import com.example.productcategoryservice.mapper.base.BaseMapper;
import com.example.productcategoryservice.transfer.request.UserRegistrationRequest;
import com.example.productcategoryservice.transfer.response.UserRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @see ModelMapper
 */
@Service
@RequiredArgsConstructor
public class UserRegistrationMapper implements BaseMapper<User, UserRegistrationRequest, UserRegistrationResponse> {

    private final ModelMapper modelMapper;

    @Override
    public User toEntity(UserRegistrationRequest userRegistrationRequest) {
        return modelMapper.map(userRegistrationRequest, User.class);
    }

    @Override
    public UserRegistrationResponse toResponse(User user) {
        return modelMapper.map(user, UserRegistrationResponse.class);
    }
}