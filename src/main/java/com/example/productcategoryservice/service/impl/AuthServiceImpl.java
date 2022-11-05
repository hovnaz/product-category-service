package com.example.productcategoryservice.service.impl;

import com.example.productcategoryservice.entity.User;
import com.example.productcategoryservice.entity.model.UserRole;
import com.example.productcategoryservice.exception.AuthenticatedException;
import com.example.productcategoryservice.exception.UserEmailConflictException;
import com.example.productcategoryservice.mapper.UserRegistrationMapper;
import com.example.productcategoryservice.repository.UserRepository;
import com.example.productcategoryservice.service.AuthService;
import com.example.productcategoryservice.transfer.request.UserAuthRequest;
import com.example.productcategoryservice.transfer.request.UserRegistrationRequest;
import com.example.productcategoryservice.transfer.response.UserAuthResponse;
import com.example.productcategoryservice.transfer.response.UserRegistrationResponse;
import com.example.productcategoryservice.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserRegistrationMapper userRegistrationMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public UserAuthResponse auth(UserAuthRequest userAuthRequest) {
        log.info("Request from user {} to get authenticated", userAuthRequest.getEmail());
        Optional<User> optionalUser = userRepository.findByEmail(userAuthRequest.getEmail());
        if (optionalUser.isEmpty()
                || !passwordEncoder.matches(userAuthRequest.getPassword(), optionalUser.get().getPassword())) {
            log.debug("{}: Provided wrong credentials for authentication", userAuthRequest.getEmail());
            throw new AuthenticatedException(userAuthRequest.getEmail() + ": Provided wrong credentials for authentication");
        }
        log.info("Succeed get user by email: {}", userAuthRequest.getEmail());
        return UserAuthResponse.builder()
                .token(jwtTokenUtil.generateToken(userAuthRequest.getEmail()))
                .build();
    }

    @Override
    public UserRegistrationResponse registration(UserRegistrationRequest userRegistrationRequest) {
        log.info("Request from user {} to registration", userRegistrationRequest.getEmail());
        Optional<User> optionalUser = userRepository.findByEmail(userRegistrationRequest.getEmail());
        if (optionalUser.isPresent()) {
            log.debug("User with email: {} already exists", userRegistrationRequest.getEmail());
            throw new UserEmailConflictException("User with email: " + userRegistrationRequest.getEmail() + " already exists");
        }
        User user = userRegistrationMapper.toEntity(userRegistrationRequest);
        user.setPassword(passwordEncoder.encode(userRegistrationRequest.getPassword()));
        user.setRole(UserRole.USER);
        userRepository.save(user);
        UserRegistrationResponse save = userRegistrationMapper.toResponse(user);
        log.info("Succeed registered user by email: {}", userRegistrationRequest.getEmail());
        return save;
    }
}
