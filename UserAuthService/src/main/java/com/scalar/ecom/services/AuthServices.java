package com.scalar.ecom.services;

import com.scalar.ecom.exceptions.InvalidTokenException;
import com.scalar.ecom.exceptions.PasswordMismatchException;
import com.scalar.ecom.exceptions.UserAlreadyExistException;
import com.scalar.ecom.exceptions.UserNotSignedUpException;
import com.scalar.ecom.modals.Role;
import com.scalar.ecom.modals.State;
import com.scalar.ecom.modals.Token;
import com.scalar.ecom.modals.User;
import com.scalar.ecom.repositories.TokenRepository;
import com.scalar.ecom.repositories.UserRepository;
import org.antlr.v4.runtime.misc.Pair;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthServices implements IAuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TokenRepository tokenRepository;

    public User signUp(String name, String email, String phoneNumber, String password) throws UserAlreadyExistException {
        Optional<User> optionalUser = userRepository.findByEmailEquals(email);
        if(optionalUser.isPresent()){
            throw new UserAlreadyExistException("Please try login directly !!!");
        }
        User user = new User();
        user.setEmail(email);
        String encryptedPassword = bCryptPasswordEncoder.encode(password);
        user.setPassword(encryptedPassword);
        user.setPhoneNumber(phoneNumber);
        user.setName(name);
        user.setState(State.ACTIVE);
        //Setting up the default role to the user
        user.setRoles(List.of(new Role("user")));
        return userRepository.save(user);
    }

    public Token login(String email, String password) throws UserNotSignedUpException, PasswordMismatchException {
        Optional<User> userOptional = userRepository.findByEmailEquals(email);
        if(userOptional.isEmpty()){
            throw new UserNotSignedUpException("Please try signup first !!!");
        }
        if(!bCryptPasswordEncoder.matches(password, userOptional.get().getPassword())) {
            throw new PasswordMismatchException("Please type correct password");
        }

        Token token = new Token();
        token.setUser(userOptional.get());
        token.setValue(RandomStringUtils.randomAlphanumeric(128));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date dayAfter30Days = calendar.getTime();
        token.setExpiresAt(dayAfter30Days);
        return tokenRepository.save(token);
    }

    @Override
    public User validateToken(String tokenValue) throws InvalidTokenException {
        System.out.println("Validating token........................................");
        Optional<Token> optionalToken = tokenRepository.findByValueAndExpiresAtAfter(tokenValue, new Date());
        if(optionalToken.isEmpty()){
            throw new InvalidTokenException("Token is not valid or expired.");
        }
        return optionalToken.get().getUser();
    }

}
