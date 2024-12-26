package com.jwt.jwt_springboot2.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {
    List<HashMap<String, String>> getUserAndRole(String user_name);
}
