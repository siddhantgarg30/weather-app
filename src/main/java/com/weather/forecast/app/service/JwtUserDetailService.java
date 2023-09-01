package com.weather.forecast.app.service;

import com.weather.forecast.app.entity.UserRequest;
import com.weather.forecast.app.entity.UserDetail;
import com.weather.forecast.app.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailService implements UserDetailsService {
    @Autowired
    UserDetailRepository userDetailRepository;

    public void createUser(UserRequest userRequest) {
        userDetailRepository.save(UserDetail.builder()
                .username(userRequest.getUsername())
                .password(new BCryptPasswordEncoder().encode(userRequest.getPassword()))
                .build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetail userDetail = userDetailRepository.findByUsername(username);
        if (userDetail != null) {
            return new User(username, userDetail.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Invalid user");
        }
    }
}
