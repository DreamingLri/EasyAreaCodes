package com.project.eac.common.utils;

import com.project.eac.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {
    private String secret;
    private String tokenHeader;
    private Integer expiration;

    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis()+expiration*1000);
    }

    public String generateToken(Map<String, Object> claim){
        return Jwts.builder()
                .setClaims(claim)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String generateToken(User user){
        Map<String, Object> map = new HashMap<>();
        String CLAIM_KEY_CREATED = "created";
        map.put(CLAIM_KEY_CREATED, user.getUserName());
        String CLAIM_KEY_USERNAME = "sub";
        map.put(CLAIM_KEY_USERNAME, new Date());
        return generateToken(map);
    }

    public Claims getClaims(String token){
        Claims claims = null;

        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (ExpiredJwtException e){
            claims = e.getClaims();
        }catch (Exception e){
            e.printStackTrace();
        }

        return claims;
    }

    public String getUserNameFromToken(String token){
        String userName = null;
        try{
            Claims claims = getClaims(token);
            userName = claims.getSubject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return userName;
    }
}
