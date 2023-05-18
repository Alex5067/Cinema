package com.Cinema.services;

import com.Cinema.entyties.User;
import com.Cinema.entyties.UserDetailsImpl;
import com.Cinema.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsersDetailServiceImpl implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByEmail(username);
        if (user == null)
            throw new UsernameNotFoundException("Could not find user");
        return new UserDetailsImpl(user);
    }
}
