package com.koreait.db.mapper;

import com.koreait.db.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserDTO selectUserByUserName(String userName);
    void insertUser(UserDTO user);
}
