package com.Cinema.services;

import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import com.Cinema.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.Cinema.entyties.User;
import com.Cinema.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("usersService")
public class UsersService {

    @Autowired
    UsersRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Optional<User> convertFindByEmail(String email) {
        try {
            User user = userRepository.findByEmail(email);
            return (Optional.ofNullable(user));
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public void signUp(User user) {userRepository.saveAndFlush(
            new User(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber()
                    .replaceAll("[+)( ]",""), passwordEncoder.encode(user.getPassword())
                ));
    }

    public String getPicName(String email) {
        Optional<User> optionalUser = convertFindByEmail(email);
        return optionalUser.get().getPicName();
    }

    public void setPicName(String email, String picName) {
        userRepository.setUserPic(email, picName);
    }

    public boolean findEmail(String email) {
        return userRepository.findEmail(email);
    }
}
