package org.example.final_metodologia_backend.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.example.final_metodologia_backend.entities.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {


    private static final String SECRET_KEY = "dHVTdXBlclNlY3JldGFDbGF2ZURlQWxNZW5vczMyQ2FyYWN0ZXJlc3M=";
    public String getToken(UserDetails usuario) {
        return getToken(new HashMap<>(), usuario);
    }

    private String getToken(Map<String,Object>extraClaims , UserDetails usuario) {

        if (usuario instanceof Usuario usuarioConId) {
            extraClaims.put("id", usuarioConId.getId());
        }

        extraClaims.put("rol", usuario.getAuthorities()
                .stream()
                .map(rol -> rol.getAuthority())
                .toList());

    return Jwts
            .builder()
            .setClaims(extraClaims)
            .setSubject(usuario.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            //Tiempo que dura el token, en este caso es de 1 hora
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
            .signWith(getKey(), SignatureAlgorithm.HS256)
            .compact();
    }

    private Key getKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public Long getIdFromToken(String token) {
        return getClaim(token, claims -> claims.get("id", Long.class));
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String nombre = getUsernameFromToken(token);
        return (nombre.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Claims getAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token) 
                .getBody();
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token){
        return getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }
}
