package com.diogoslz.marketplace.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service //para poder inyectar
public class UserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("diogol","{noop}solochos",new ArrayList<>());
    }

    /*
    * ESTE ES UN DEMO
    * se deberia ir a una base de datos o un sistema Auth0
    * */
}
