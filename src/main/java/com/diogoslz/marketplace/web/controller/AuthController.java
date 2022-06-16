package com.diogoslz.marketplace.web.controller;

import com.diogoslz.marketplace.domain.dto.AuthenticationRequest;
import com.diogoslz.marketplace.domain.dto.AuthenticationResponse;
import com.diogoslz.marketplace.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;    //inyectar de Spring

    @Autowired
    private UserDetailsService userDetailsService;          //Servicio creado con los user y passw service/UserDetailsService se encarga de la seguridad en este ejemplo

    @Autowired
    private JWTUtil jwtUtil;                            //inyectar de security JWUtil security/

    //recibe peticiones POST usar @RequestBody
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){

        try {
            //recibe parametros se realiz por user and pasw de dto/AutenticationRequest
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
            //obtener userdetails que vienen de la peticion
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            //generar json web token
            String jwt = jwtUtil.generateToken(userDetails);

            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);

        }catch (BadCredentialsException bd){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }
}
