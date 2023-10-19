package com.example.api;

import com.example.config.TokenProvider;
import com.example.dto.InfoResponse;
import com.example.dto.MyUser;
import com.example.dto.UserDTO;
import com.example.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
public class UserAPI {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenProvider jwtToken;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            userDTO.getUsername(),
                            userDTO.getPassword()
                    ));
            String token = jwtToken.generateToken(authentication);
            Date expiration = jwtToken.getExpirationDateFromToken(token);
            MyUser myUser = (MyUser)authentication.getPrincipal();
            String username = myUser.getUsername();
            String fullName = myUser.getFullName();
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(new InfoResponse(token, username, fullName, expiration));
        } catch (AuthenticationException e) {
            throw new ResourceNotFoundException("Thông tin tài khoản hoặc mật khẩu không chính xác");
        }
    }


}
