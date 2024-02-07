package com.petLovers.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.petLovers.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("petlovers_api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token", e);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            var response = JWT.require(algorithm)
                    .withIssuer("petlovers_api")
                    .build()
                    .verify(token)
                    .getSubject();
            return response;
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Falha na verificação do token: " + e.getMessage(), e);
        }
    }

    public Instant generateExpirationDate() {

        ZoneId zone = ZoneId.systemDefault();

        return LocalDateTime.now().plusHours(2).atZone(zone).toInstant();
    }
}
