package com.diogoslz.marketplace.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private static final String KEY = "solochos";   //llave para firmar KEY -> debe ser mas compleja

    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())                      // usuario
                .setIssuedAt(new Date())                                                 //fecha creado el JWT
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 *10))//fecha de expiracion 10 horas
                .signWith(SignatureAlgorithm.HS256, KEY )                                //firmar con sha256 y una llave creada por nstros
                .compact();                                                              //crear el JWT
    }

    //validar si el token recibido es valido
    public boolean validateToken(String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extracUsername(token)) && !isTokenExpired(token);
    }


    public String extracUsername(String token){
        return getClaims(token).getSubject(); //objetos dentro de JWTs get username y passw
    }

    public boolean isTokenExpired(String token){
        return getClaims(token).getExpiration().before(new Date()); //verificar la expiracion del token
    }

    //Claim objetos dentro del JWT
    private Claims getClaims(String token){
        //como decodificar el token con la llave
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }
}
