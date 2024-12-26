package com.jwt.jwt_springboot2.auth.service;

import com.jwt.jwt_springboot2.auth.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<HashMap<String, String>> user = userMapper.getUserAndRole(username);
        if (user.size() > 0) {
            HashMap<String, String> map = user.get(0);
            List<GrantedAuthority> auth = new ArrayList<>();
            auth.add(new SimpleGrantedAuthority(map.get("ROLE")));
            return new User(username, map.get("PASSWORD"), auth);
        } else {
            throw new UsernameNotFoundException("Invalid Username or Password");
        }
    }
}
