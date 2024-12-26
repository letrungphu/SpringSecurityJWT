package com.jwt.jwt_springboot2.api.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ListMapper {
    List<HashMap<String, Object>> getList(HashMap<String, Object> input);
}
