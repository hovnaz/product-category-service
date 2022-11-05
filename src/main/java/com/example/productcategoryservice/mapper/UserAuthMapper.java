package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.entity.User;
import com.example.productcategoryservice.mapper.base.BaseMapper;
import com.example.productcategoryservice.transfer.request.UserAuthRequest;
import com.example.productcategoryservice.transfer.response.UserAuthResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @see ModelMapper
 */
@Service
@RequiredArgsConstructor
public class UserAuthMapper implements BaseMapper<User, UserAuthRequest, UserAuthResponse> {

    private final ModelMapper modelMapper;

    @Override
    public User toEntity(UserAuthRequest userAuthRequest) {
        return modelMapper.map(userAuthRequest, User.class);
    }

    @Override
    public UserAuthResponse toResponse(User user) {
        return modelMapper.map(user, UserAuthResponse.class);
    }
}
