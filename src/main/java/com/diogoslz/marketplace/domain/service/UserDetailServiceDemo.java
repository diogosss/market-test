package com.diogoslz.marketplace.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service //para poder inyectar
public class UserDetailServiceDemo implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("diogol","{noop}solochos",new ArrayList<>()); //array list va los tipos de roles del usuario
        //{noop} porque no ha pasado por un cifrado
    }

    /*
    * ESTE ES UN DEMO
    * se deberia ir a una base de datos o un sistema Auth0
    * */
}
