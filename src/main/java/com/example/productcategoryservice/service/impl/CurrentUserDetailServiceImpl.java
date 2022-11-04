package com.example.productcategoryservice.service.impl;

import com.example.productcategoryservice.entity.User;
import com.example.productcategoryservice.repository.UserRepository;
import com.example.productcategoryservice.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrentUserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(s);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new CurrentUser(optionalUser.get());
    }
}