package com.scalar.ecom.services;

import com.scalar.ecom.exceptions.InvalidTokenException;
import com.scalar.ecom.exceptions.PasswordMismatchException;
import com.scalar.ecom.exceptions.UserAlreadyExistException;
import com.scalar.ecom.exceptions.UserNotSignedUpException;
import com.scalar.ecom.modals.Token;
import com.scalar.ecom.modals.User;
import org.antlr.v4.runtime.misc.Pair;

public interface IAuthService {
    User signUp(String name, String email, String phoneNumber, String password) throws UserAlreadyExistException;
    Token login(String email, String password) throws UserNotSignedUpException, PasswordMismatchException;
    User validateToken(String tokenValue) throws InvalidTokenException;
}
