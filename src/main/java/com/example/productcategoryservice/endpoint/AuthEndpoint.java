package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.service.AuthService;
import com.example.productcategoryservice.transfer.request.UserAuthRequest;
import com.example.productcategoryservice.transfer.request.UserRegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthEndpoint {
    private final AuthService authService;

    @GetMapping
    public ResponseEntity<?> auth(@RequestBody UserAuthRequest userAuthRequest) {
        return ResponseEntity.ok(authService.auth(userAuthRequest));
    }

    @PostMapping
    public ResponseEntity<?> registration(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        return ResponseEntity.ok(authService.registration(userRegistrationRequest));
    }

}
