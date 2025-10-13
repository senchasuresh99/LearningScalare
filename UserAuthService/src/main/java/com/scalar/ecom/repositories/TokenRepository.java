package com.scalar.ecom.repositories;

import com.scalar.ecom.modals.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByValueAndExpiresAtAfter(String token, Date expiresAt);
}
