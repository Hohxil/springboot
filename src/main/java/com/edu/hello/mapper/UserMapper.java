package com.edu.hello.mapper;

import com.edu.hello.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    public User Sel();
    public User findOne(int id);
}

