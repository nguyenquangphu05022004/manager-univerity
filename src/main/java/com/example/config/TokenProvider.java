package com.example.config;

import com.example.constant.SystemConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class TokenProvider implements Serializable {

    public String getUserNameFromToken(String token) {
            return getAllClaimsFromToken(token)
                    .getSubject();
    }

    public Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token)
                .getExpiration();
    }


    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SystemConstant.SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
    public boolean isTokenExpired(String token) {
        Date exprired = getExpirationDateFromToken(token);
        boolean res = exprired.before(new Date());
        return res;
    }
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.compareTo(userDetails.getUsername()) == 0
                && !isTokenExpired(token);
    }

    public String generateToken(Authentication authentication) {
        String authorities = authentication.getAuthorities()
                .stream().map((authority) -> ((GrantedAuthority) authority).getAuthority())
                .collect(Collectors.joining(","));
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(SystemConstant.AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS256, SystemConstant.SIGNING_KEY)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()
                        + SystemConstant.ACCESS_TOKEN_VALIDITY__SECONDS))
                .compact();
    }

    public UsernamePasswordAuthenticationToken getAuthentication(
            String token, Authentication existingAuth, UserDetails userDetails
    ) {
        Claims claims = Jwts.parser().setSigningKey(SystemConstant.SIGNING_KEY)
                .parseClaimsJws(token).getBody();

        Collection<? extends GrantedAuthority> authorities
                = Arrays.stream(claims.get((SystemConstant.AUTHORITIES_KEY)).toString().split(","))
                .map((author) -> new SimpleGrantedAuthority(author))
                .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userDetails, "",authorities);
    }


}
