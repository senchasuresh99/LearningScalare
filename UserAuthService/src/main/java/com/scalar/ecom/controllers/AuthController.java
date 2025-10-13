package com.scalar.ecom.controllers;

import com.scalar.ecom.dtos.LoginRequestDto;
import com.scalar.ecom.dtos.SignUpRequestDto;
import com.scalar.ecom.dtos.TokenResponseDto;
import com.scalar.ecom.dtos.UserDto;
import com.scalar.ecom.exceptions.InvalidTokenException;
import com.scalar.ecom.exceptions.PasswordMismatchException;
import com.scalar.ecom.exceptions.UserAlreadyExistException;
import com.scalar.ecom.exceptions.UserNotSignedUpException;
import com.scalar.ecom.modals.Token;
import com.scalar.ecom.modals.User;
import com.scalar.ecom.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService iAuthService;
    //Sign up
    @PostMapping("/signUp")
    public UserDto signUp(@RequestBody SignUpRequestDto signUpRequestDto) throws UserAlreadyExistException {
        User user = iAuthService.signUp(signUpRequestDto.getName(), signUpRequestDto.getEmail(), signUpRequestDto.getPhoneNumber(), signUpRequestDto.getPassword());
        return from(user);
    }

    //Login
    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody LoginRequestDto loginRequestDto) throws PasswordMismatchException, UserNotSignedUpException {
        Token token = iAuthService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        TokenResponseDto tokenResponseDto = new TokenResponseDto();
        tokenResponseDto.setTokenValue(token.getValue());
        tokenResponseDto.setEmail(token.getUser().getEmail());
        return tokenResponseDto;
    }

    @GetMapping("/validate")
    public UserDto validateToken(@RequestHeader String tokenValue) throws InvalidTokenException {
        return from(iAuthService.validateToken(tokenValue));
    }

    public UserDto from(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

}
