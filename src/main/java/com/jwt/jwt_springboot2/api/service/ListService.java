package com.jwt.jwt_springboot2.api.service;

import com.jwt.jwt_springboot2.api.mapper.ListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ListService {
    @Autowired
    ListMapper listMapper;

    public class User {
        private String username = "";
        private String password = "";
        private String role = "";

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

    public List<User> getListUser(HashMap<String, Object> input) {
        List<User> result = new ArrayList<>();
        List<HashMap<String, Object>> data = listMapper.getList(input);
        if (data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
                User user = new User();
                user.setUsername(data.get(i).get("USER_NAME").toString());
                user.setPassword(data.get(i).get("PASSWORD").toString());
                user.setRole(data.get(i).get("ROLE").toString());
                result.add(user);
            }
        }
        return result;
    }
}
